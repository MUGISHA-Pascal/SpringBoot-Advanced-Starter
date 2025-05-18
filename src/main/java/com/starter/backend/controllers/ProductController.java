package com.starter.backend.controllers;

import com.starter.backend.dtos.ProductDto;
import com.starter.backend.models.Product;
import com.starter.backend.services.ProductService;
import com.starter.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/order")
    public Page<Product> getPaginatedAndSortedProducts(@RequestParam(value = "page" ,defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page, @RequestParam(value = "size",defaultValue = Constants.DEFAULT_PAGE_SIZE) int size, @RequestParam(value = "column") String column){
        return productService.productsPagination(page,size,column);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/category/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable String category){
        return this.productService.findProductsByCategory(category);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable UUID id){
        return productService.getProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDto productDto){
        System.out.println("product log in controller"+productDto.getInventory().getLocation());
        return productService.addProduct(productDto);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable UUID id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
        return "Product with id " + id + " has been deleted successfully.";
    }
}
