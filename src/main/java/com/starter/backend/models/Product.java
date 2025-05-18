package com.starter.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "inventory_id",referencedColumnName = "id")
    private Inventory inventory;
    private String category;
    public Product(String name, String description, int price, int quantity, String category,String inventoryLocation,int inventoryQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.inventory = new Inventory();
        this.inventory.setLocation(inventoryLocation);
        this.inventory.setQuantity(inventoryQuantity);
    }
}
