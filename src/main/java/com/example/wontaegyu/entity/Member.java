package com.example.wontaegyu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "login_id", nullable = false, unique = true, length = 50)
    private String loginId;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String nickname;

    @Column(name = "university_email", nullable = false, unique = true, length = 100)
    private String universityEmail;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(length = 10)
    private String gender;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "preferred_food_category", length = 50)
    private String preferredFoodCategory;

    @Column(name = "profile_image_file_id")
    private Long profileImageFileId;

    @Column(nullable = false, length = 20)
    private String role;

    @Column(name = "account_status", nullable = false, length = 20)
    private String accountStatus;

    @Column(name = "manner_temperature", nullable = false, precision = 5, scale = 2)
    private BigDecimal mannerTemperature;

    @Column(name = "no_show_count", nullable = false)
    private Integer noShowCount;

    @Column(name = "withdrawn_at")
    private LocalDateTime withdrawnAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Builder
    public Member(String loginId, String password, String name, String nickname, String universityEmail,
                  String phoneNumber, String gender, LocalDate birthDate, String preferredFoodCategory,
                  String role, String accountStatus, BigDecimal mannerTemperature, Integer noShowCount) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.universityEmail = universityEmail;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.preferredFoodCategory = preferredFoodCategory;

        this.role = role != null ? role : "USER";
        this.accountStatus = accountStatus != null ? accountStatus : "ACTIVE";
        this.mannerTemperature = mannerTemperature != null ? mannerTemperature : new BigDecimal("36.50");
        this.noShowCount = noShowCount != null ? noShowCount : 0;
    }
}
