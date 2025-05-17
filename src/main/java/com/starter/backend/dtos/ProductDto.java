package com.starter.backend.dtos;

import com.starter.backend.models.Inventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String category;
    private Inventory inventory;
//    private String image_url;
}
