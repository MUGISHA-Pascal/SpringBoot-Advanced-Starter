package com.starter.backend.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class UpdateInventoryDto {
    private int quantity;
    private String location;
}
