package com.bluepa.backend.user.repository;

import com.bluepa.backend.user.domain.EmailAuth;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmailAuthRepositoryImpl implements EmailAuthRepository {

    private final StringRedisTemplate stringRedisTemplate;
    private final String keyPrefix = "email:";

    @Override
    public EmailAuth save(EmailAuth emailAuth) {
        stringRedisTemplate.opsForValue()
            .set(keyPrefix + emailAuth.getEmail(), emailAuth.toString());
        return emailAuth;
    }

    @Override
    public Optional<EmailAuth> findByEmail(String email) {
        Optional<String> emailAuth = Optional
            .ofNullable(stringRedisTemplate.opsForValue().get(keyPrefix + email));
        return emailAuth.map(EmailAuth::new);
    }

    @Override
    public void deleteByEmail(String email) {
        stringRedisTemplate.delete(keyPrefix + email);
    }
}
