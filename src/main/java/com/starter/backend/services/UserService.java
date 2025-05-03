package com.starter.backend.services;

import com.starter.backend.exceptions.ApiRequestException;
import com.starter.backend.models.User;
import com.starter.backend.repository.RoleRepository;
import com.starter.backend.repository.UserRepository;
import com.starter.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }
    public User getUser(UUID userId){
        return this.userRepository.findById(userId).orElseThrow(()-> new ApiRequestException("user with id "+userId+" not found"));
    }
    public User deleteUser(UUID userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new ApiRequestException("user with id "+userId+" not found"));
   this.userRepository.delete(user);

   return user;
    }
    public Page<User> getAllUsers(int page,int size){
        Constants.validatePageNumberAndPageSize(page,size);
        Pageable pageable = (Pageable) PageRequest.of(page,size, Sort.Direction.ASC,"firstName");
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }
    public User getLoggedInUser(){
        String email;

    }
}
