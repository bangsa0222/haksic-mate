package com.example.wontaegyu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "EMAIL_VERIFICATION")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verification_id")
    private Long id;

    @Column(name = "verification_email", nullable = false, length = 100)
    private String verificationEmail;

    @Column(name = "verification_code", nullable = false, length = 20)
    private String verificationCode;

    @Column(name = "verification_purpose", nullable = false, length = 30)
    private String verificationPurpose;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "is_verified", nullable = false, length = 1)
    private String isVerified;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public EmailVerification(String verificationEmail, String verificationCode, String verificationPurpose, LocalDateTime expiresAt, String isVerified) {
        this.verificationEmail = verificationEmail;
        this.verificationCode = verificationCode;
        this.verificationPurpose = verificationPurpose;
        this.expiresAt = expiresAt;

        this.isVerified = isVerified != null ? isVerified : "N";
    }


    public void verify() {
        this.isVerified = "Y";
    }
}

