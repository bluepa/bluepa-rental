package com.bluepa.backend.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

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
        given(passwordEncoder.encode(any())).willReturn(password);
        given(userRepository.save(any())).willReturn(user);
        given(emailAuthRepository.findByEmail(email)).willReturn(Optional.of(emailAuth));

        Long userId = userService.signUp(signUpRequest);

        then(userRepository).should().save(any());
        then(emailAuthRepository).should().deleteByEmail(email);
        assertThat(userId).isEqualTo(user.getId());
    }

    @Test
    void 로그인() {
        SignInRequest signInRequest = SignInRequest.builder()
            .email(email)
            .password(password)
            .build();
        given(passwordEncoder.matches(any(), any())).willReturn(true);
        given(userRepository.findByEmail(any())).willReturn(Optional.of(user));
        given(provider.createToken(user)).willReturn("token");

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
        given(userRepository.existsByEmail(email)).willReturn(false);

        userService.sendEmail(email);

        then(emailAuthRepository).should().save(any());
        then(javaMailSender).should().send((SimpleMailMessage) any());
    }

    @Test
    void 이메일_인증() {
        EmailAuth emailAuth = new EmailAuth(email, 123456);
        given(emailAuthRepository.findByEmail(email)).willReturn(Optional.of(emailAuth));

        userService.authenticateEmail(email, 123456);

        assertThat(emailAuth.isChecked()).isTrue();
    }
}
