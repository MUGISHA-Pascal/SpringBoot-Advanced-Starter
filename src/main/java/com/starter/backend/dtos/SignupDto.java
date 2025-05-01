package com.starter.backend.dtos;

import com.starter.backend.enums.EGender;
import com.starter.backend.enums.ERoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    @Size(max=100)
    @Email
    private String email;
    @NotBlank
    @Size(min=4,max = 40)
    private String firstName;
    @NotBlank
    @Size(min=4,max=40)
    private String lastName;
    @NotBlank
    private String mobile;
    private EGender gender;
    private ERoleType role;
    private String password;

}
