package com.starter.backend.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    private  static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);
    @Override
    public void commence( HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.error("responding with unauthorized error.message - {}",e.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Sorry , you are not authorised to access this resource"+e.getMessage());
    }
}
