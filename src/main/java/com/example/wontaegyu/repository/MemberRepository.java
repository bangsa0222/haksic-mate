package com.example.wontaegyu.repository;
import com.example.wontaegyu.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginId(String loginId);


    boolean existsByLoginId(String loginId);


    boolean existsByNickname(String nickname);


    boolean existsByUniversityEmail(String universityEmail);
}
