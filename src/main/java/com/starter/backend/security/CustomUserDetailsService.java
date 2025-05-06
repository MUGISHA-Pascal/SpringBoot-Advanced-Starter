package com.starter.backend.security;

import com.starter.backend.models.User;
import com.starter.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserDetails loadUserById(UUID id){
        User user = userRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("user not found with id : "+id));
        return  UserPrincipal.create(user);
    }
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
    User user = userRepository.findByEmailOrMobile(s,s).orElseThrow(()-> new UsernameNotFoundException("user not found with email or mobile of "+s));
    System.out.println("user in the user details service "+user.getPassword());
    return UserPrincipal.create(user);
    }
}
