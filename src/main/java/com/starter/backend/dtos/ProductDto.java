package com.starter.backend.dtos;

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
//    private String image_url;
}
