package com.starter.backend.controllers;

import com.starter.backend.dtos.UserUpdateDto;
import com.starter.backend.models.User;
import com.starter.backend.payload.ApiResponse;
import com.starter.backend.services.UserService;
import com.starter.backend.util.Constants;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
@Autowired
private UserService userService;
@GetMapping
    public Page<User> getUsers(@RequestParam(value = "page" ,defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,@RequestParam(value = "size",defaultValue = Constants.DEFAULT_PAGE_SIZE) int size,@RequestParam(value = "column") String column){
    return userService.getAllUsers(page,size,column);
}
@DeleteMapping(path = "/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@Parameter(description = "userId",required = true) @PathVariable("userId") UUID userId){
    return ResponseEntity.ok(new ApiResponse(true,"user removed successfully",userService.deleteUser(userId)));
}
@PutMapping(path = "/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable("userId") UUID userId, @Valid @RequestBody UserUpdateDto userdataRequest){
    userService.updateUser(userId,userdataRequest);
    User user = userService.getUser(userId);
    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{email}").buildAndExpand(user.getEmail()).toUri();
    return ResponseEntity.created(location).body(new ApiResponse(true,"user updated successfully",user));
}
@GetMapping(path = "/{userId}")
    public ResponseEntity<ApiResponse> getUser(@Parameter(description="Get user by id",required = true) @PathVariable("userId") UUID userId ){
    return ResponseEntity.ok(new ApiResponse(true,"user found",this.userService.getUser(userId)));
}
}
