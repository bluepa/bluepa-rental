package com.bluepa.backend.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bluepa.backend.user.domain.User;
import com.bluepa.backend.user.domain.UserRepository;
import com.bluepa.backend.user.dto.SignUpRequest;
import org.assertj.core.api.Assertions;
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
}
