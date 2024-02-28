package com.example.endPointAuthorizationBasic.security;

import com.example.endPointAuthorizationBasic.entities.Authority;
import com.example.endPointAuthorizationBasic.entities.Member;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.sound.midi.MetaMessage;


@AllArgsConstructor
public class SecurityAuthority  implements GrantedAuthority {
    private final Authority authorityObj;

    @Override
    public String toString() {
        return "SecurityAuthority{" +
                "authorityObj=" + authorityObj.getAuthority() +
                '}';
    }

    @Override
    public String getAuthority() {
        return authorityObj.getAuthority();
    }


}
