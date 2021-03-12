package com.bluepa.backend.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    void 회원가입() {
        SignUpRequest signUpRequest = SignUpRequest.builder()
            .email("aaa@gmail.com")
            .password("abc123")
            .nickname("aaa")
            .build();
        User user = User.builder()
            .id(1L)
            .email("aaa@gmail.com")
            .password("abc123")
            .nickname("aaa")
            .build();
        EmailAuth emailAuth = new EmailAuth("aaa@gmail.com,123456,true");
        when(passwordEncoder.encode(any())).thenReturn("abc123");
        when(userRepository.save(any())).thenReturn(user);
        when(emailAuthRepository.findByEmail("aaa@gmail.com")).thenReturn(Optional.of(emailAuth));

        Long userId = userService.signUp(signUpRequest);

        verify(userRepository).save(any());
        verify(emailAuthRepository).deleteByEmail("aaa@gmail.com");
        assertThat(userId).isEqualTo(user.getId());
    }

    @Test
    void 로그인() {
        SignInRequest signInRequest = SignInRequest.builder()
            .email("aaa@gmail.com")
            .password("abc123")
            .build();
        User user = User.builder()
            .id(1L)
            .email("aaa@gmail.com")
            .password("abc123")
            .nickname("aaa")
            .build();
        when(passwordEncoder.matches(any(), any())).thenReturn(true);
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));
        when(provider.createToken(user)).thenReturn("token");

        String token = userService.signIn(signInRequest);

        assertThat(token).isNotNull();
    }

    @Test
    void 이메일_전송() {
        String email = "voiciphil@gmail.com";
        when(userRepository.existsByEmail(email)).thenReturn(false);

        userService.sendEmail(email);

        verify(emailAuthRepository).save(any());
        verify(javaMailSender).send((SimpleMailMessage) any());
    }

    @Test
    void 이메일_인증() {
        String email = "aaa@gmail.com";
        EmailAuth emailAuth = new EmailAuth(email, 123456);
        when(emailAuthRepository.findByEmail(email)).thenReturn(Optional.of(emailAuth));

        userService.authenticateEmail(email, 123456);

        assertThat(emailAuth.isChecked()).isTrue();
    }
}
