package com.example.endPointAuthorizationBasic.service;

import com.example.endPointAuthorizationBasic.repository.MemberRepository;
import com.example.endPointAuthorizationBasic.security.SecurityMember;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        return Optional.of(memberRepository.findMemberByUserName(username)).map(SecurityMember::new).orElseThrow(
                ()-> new UsernameNotFoundException("user not found")
        );
    }
}
