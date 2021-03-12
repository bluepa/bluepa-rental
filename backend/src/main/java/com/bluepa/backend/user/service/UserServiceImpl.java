package com.bluepa.backend.user.service;

import com.bluepa.backend.global.exception.NotFoundEntityException;
import com.bluepa.backend.global.exception.NotMatchedPasswordException;
import com.bluepa.backend.global.security.JwtProvider;
import com.bluepa.backend.user.domain.User;
import com.bluepa.backend.user.domain.UserRepository;
import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public Long register(SignUpRequest signUpRequest) {
        User user = User.builder()
            .email(signUpRequest.getEmail())
            .password(passwordEncoder.encode(signUpRequest.getPassword()))
            .nickname(signUpRequest.getNickname())
            .build();

        User result = userRepository.save(user);

        return result.getId();
    }

    @Override
    public String login(SignInRequest signInRequest) {
        User user = userRepository.findByEmail(signInRequest.getEmail())
            .orElseThrow(NotFoundEntityException::new);

        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new NotMatchedPasswordException();
        }

        return jwtProvider.createToken(user.getEmail(), user.getId(), user.getRole());
    }
}
