package com.bluepa.backend.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bluepa.backend.global.security.JwtProvider;
import com.bluepa.backend.user.domain.User;
import com.bluepa.backend.user.domain.UserRepository;
import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtProvider provider;

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
        when(passwordEncoder.encode(any())).thenReturn("abc123");
        when(userRepository.save(any())).thenReturn(user);

        Long userId = userService.register(signUpRequest);

        verify(userRepository).save(any());
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
        when(provider.createToken(any(), any(), any())).thenReturn("token");

        String token = userService.signIn(signInRequest);

        assertThat(token).isNotNull();
    }
}
