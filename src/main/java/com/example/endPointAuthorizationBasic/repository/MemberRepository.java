package com.example.endPointAuthorizationBasic.repository;

import com.example.endPointAuthorizationBasic.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    @Query("select m from Member m where m.username= :name")
    public Member findMemberByUserName(String name);
}
