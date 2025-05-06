package com.starter.backend.services;

import com.starter.backend.dtos.ProductDto;
import com.starter.backend.exceptions.ApiRequestException;
import com.starter.backend.models.Product;
import com.starter.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(ProductDto productDto){
        Product product = new Product(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getQuantity(),
                productDto.getCategory()
        );
        return productRepository.save(product);
    }

    public Product getProduct(UUID id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Product with id " + id + " not found"));
    }

    public Product updateProduct(UUID id, ProductDto productDto){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Product with id " + id + " not found"));

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setQuantity(productDto.getQuantity());
        existingProduct.setCategory(productDto.getCategory());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(UUID id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Product with id " + id + " not found"));
        productRepository.delete(product);
    }
    public List<Product> findProductsByCategory(String category){
        List<Product> products = productRepository.findByCategory(category);
        return products;
    }
}
