package com.starter.backend.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starter.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;
@Getter
@Setter
@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private UUID id;
    @JsonIgnore
    private String email;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String mobile;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority>  authorities;
    public static UserPrincipal create(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new UserPrincipal(user.getId(),user.getEmail(),user.getFirstName(),user.getLastName(),user.getMobile(),user.getPassword(),authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }
    @Override
    public String getPassword(){

        System.out.println("password being called "+password);
        return password;
    }
    @Override
    public String getUsername(){
        return email;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
}
