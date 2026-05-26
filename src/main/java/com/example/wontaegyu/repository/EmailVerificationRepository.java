package com.example.wontaegyu.repository;
import com.example.wontaegyu.entity.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long> {
    Optional<EmailVerification> findTopByVerificationEmailAndVerificationPurposeOrderByCreatedAtDesc(String email, String purpose);
}
