package com.project.MyLibrary.dtos;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class UserAccountDTO {
    private String username;
    private List<SimpleGrantedAuthority> authorities;

    public String getUsername() {
        return username;
    }

    public UserAccountDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public UserAccountDTO setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }
}
