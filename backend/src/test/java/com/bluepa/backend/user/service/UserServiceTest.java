package com.bluepa.backend.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bluepa.backend.global.security.JwtProvider;
import com.bluepa.backend.user.domain.EmailAuth;
import com.bluepa.backend.user.domain.User;
import com.bluepa.backend.user.repository.EmailAuthRepository;
import com.bluepa.backend.user.repository.UserRepository;
import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    @Mock
    EmailAuthRepository emailAuthRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    JwtProvider provider;
    @Mock
    JavaMailSender javaMailSender;
    @Mock
    HttpSession httpSession;

    String email;
    String password;
    User user;

    @BeforeEach
    void init() {
        email = "aaa@gmail.com";
        password = "abc123";
        user = User.builder()
            .id(1L)
            .email(email)
            .password(password)
            .build();
    }

    @Test
    void 회원가입() {
        SignUpRequest signUpRequest = SignUpRequest.builder()
            .email(email)
            .password(password)
            .build();
        EmailAuth emailAuth = new EmailAuth("aaa@gmail.com,123456,true");
        when(passwordEncoder.encode(any())).thenReturn(password);
        when(userRepository.save(any())).thenReturn(user);
        when(emailAuthRepository.findByEmail(email)).thenReturn(Optional.of(emailAuth));

        Long userId = userService.signUp(signUpRequest);

        verify(userRepository).save(any());
        verify(emailAuthRepository).deleteByEmail(email);
        assertThat(userId).isEqualTo(user.getId());
    }

    @Test
    void 로그인() {
        SignInRequest signInRequest = SignInRequest.builder()
            .email(email)
            .password(password)
            .build();
        when(passwordEncoder.matches(any(), any())).thenReturn(true);
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));
        when(provider.createToken(user)).thenReturn("token");

        String token = userService.signIn(signInRequest);

        assertThat(token).isNotNull();
    }

    @Test
    void 소셜_로그인() {
        given(httpSession.getAttribute("email")).willReturn(email);
        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));
        given(provider.createToken(user)).willReturn("token");

        String token = userService.signIn(httpSession);

        assertThat(token).isNotNull();
    }

    @Test
    void 이메일_전송() {
        when(userRepository.existsByEmail(email)).thenReturn(false);

        userService.sendEmail(email);

        verify(emailAuthRepository).save(any());
        verify(javaMailSender).send((SimpleMailMessage) any());
    }

    @Test
    void 이메일_인증() {
        EmailAuth emailAuth = new EmailAuth(email, 123456);
        when(emailAuthRepository.findByEmail(email)).thenReturn(Optional.of(emailAuth));

        userService.authenticateEmail(email, 123456);

        assertThat(emailAuth.isChecked()).isTrue();
    }
}
