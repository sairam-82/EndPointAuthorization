package com.example.endPointAuthorizationBasic.security;

import com.example.endPointAuthorizationBasic.entities.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.sound.midi.MetaMessage;
import java.util.Collection;
import java.util.stream.Collectors;


@AllArgsConstructor

public class SecurityMember implements UserDetails {
    @Override
    public String toString() {
        return "SecurityMember{" +
                "user=" + user.getUsername() +
                '}';
    }

    private final Member user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities().stream().map(SecurityAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
