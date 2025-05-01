package com.starter.backend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Response {
    private String message;
    private ZonedDateTime timstamp;
    private Boolean success;
}
