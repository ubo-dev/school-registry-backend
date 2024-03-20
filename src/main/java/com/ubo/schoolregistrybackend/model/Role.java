package com.ubo.schoolregistrybackend.model;

import com.ubo.schoolregistrybackend.enums.RoleType;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Enumerated(EnumType.STRING)
    private RoleType name ;

    public String getName() {
        return name.toString();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(name.toString()));
        return authorities;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
