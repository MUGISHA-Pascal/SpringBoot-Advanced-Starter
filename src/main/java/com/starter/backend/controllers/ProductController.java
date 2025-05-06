package com.starter.backend.controllers;

import com.starter.backend.dtos.ProductDto;
import com.starter.backend.models.Product;
import com.starter.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // GET all products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // GET product by ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable UUID id){
        return productService.getProduct(id);
    }

    // POST - Add new product
    @PostMapping
    public Product addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    // PUT - Update product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable UUID id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
        return "Product with id " + id + " has been deleted successfully.";
    }
}
