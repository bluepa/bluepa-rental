package com.bluepa.backend.user.service;

import com.bluepa.backend.global.exception.NotFoundEntityException;
import com.bluepa.backend.global.exception.NotMatchedPasswordException;
import com.bluepa.backend.global.security.JwtProvider;
import com.bluepa.backend.user.domain.User;
import com.bluepa.backend.user.repository.UserRepository;
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
    public Long signUp(SignUpRequest request) {
        User user = User.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .nickname(request.getNickname())
            .build();

        User result = userRepository.save(user);

        return result.getId();
    }

    @Override
    public String signIn(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(NotFoundEntityException::new);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new NotMatchedPasswordException();
        }

        return jwtProvider.createToken(user);
    }
}
