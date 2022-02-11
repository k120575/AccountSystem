package com.example.accountsystem.repository;

import com.example.accountsystem.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByNameAndPassword(String name, String password);

    Member findByName(String name);
}
