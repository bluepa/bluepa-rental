package com.bluepa.backend.user.repository;

import com.bluepa.backend.user.domain.EmailAuth;
import java.util.Optional;

public interface EmailAuthRepository {

    EmailAuth save(EmailAuth emailAuth);

    Optional<EmailAuth> findByEmail(String email);

    void deleteByEmail(String email);
}
