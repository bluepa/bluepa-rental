package com.bluepa.backend.user.service;

import com.bluepa.backend.global.exception.AlreadyExistsEntityException;
import com.bluepa.backend.global.exception.NotFoundEntityException;
import com.bluepa.backend.global.exception.NotMatchedPasswordException;
import com.bluepa.backend.global.security.JwtProvider;
import com.bluepa.backend.user.domain.EmailAuth;
import com.bluepa.backend.user.domain.User;
import com.bluepa.backend.user.dto.EmailRequest;
import com.bluepa.backend.user.repository.EmailAuthRepository;
import com.bluepa.backend.user.repository.UserRepository;
import com.bluepa.backend.user.dto.SignInRequest;
import com.bluepa.backend.user.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailAuthRepository emailAuthRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final JavaMailSender javaMailSender;

    @Value("spring.mail.username")
    private String serviceEmail;

    @Override
    public Long signUp(SignUpRequest request) {
        User user = User.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .nickname(request.getNickname())
            .role("ROLE_USER")
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

    @Override
    public void sendEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new AlreadyExistsEntityException();
        }

        int code = (int) (Math.random() * 900000 + 100000);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(serviceEmail);
        message.setTo(email);
        message.setSubject("Bluepa Rental 인증번호입니다.");
        message.setText("인증번호는 " + code + "입니다.");

        javaMailSender.send(message);
        emailAuthRepository.save(new EmailAuth(email, code));
    }

    @Override
    public void authenticateEmail(String email, int code) {

    }
}
