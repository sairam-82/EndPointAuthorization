package com.example.endPointAuthorizationBasic.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id;

    private String username;

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    private String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "member_authorities",
    joinColumns = @JoinColumn(name = "member_id"),
    inverseJoinColumns =@JoinColumn(name = "authority_id"))
    @Fetch(FetchMode.JOIN)
    private List<Authority> authorities;

}
