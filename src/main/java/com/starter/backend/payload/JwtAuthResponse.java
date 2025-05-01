package com.starter.backend.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType="Bearer";
    public JwtAuthResponse(String accessToken){
        this.accessToken=accessToken;
    }
}
