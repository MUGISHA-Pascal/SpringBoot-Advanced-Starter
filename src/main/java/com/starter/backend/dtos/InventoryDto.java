package com.starter.backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDto {
    private int quantity;
    private String productName;
    private ProductDto product;
}
