package com.starter.backend.services;

import com.starter.backend.dtos.UpdateInventoryDto;
import com.starter.backend.models.Inventory;
import com.starter.backend.models.Product;
import com.starter.backend.repository.InventoryRepository;
import com.starter.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductRepository productRepository;
    public ResponseEntity<Product> updateInventory( UUID id, UpdateInventoryDto updateInventoryDto){
        return productRepository.findById(id).map(existingProduct -> {
            if(updateInventoryDto != null) {
                Inventory existingInventory = existingProduct.getInventory();
                existingInventory.setQuantity(updateInventoryDto.getQuantity());
                existingInventory.setLocation(updateInventoryDto.getLocation());
            }
            Product updatedProduct = productRepository.save(existingProduct);
            return ResponseEntity.ok(updatedProduct);
        }).orElse(ResponseEntity.notFound().build());
    }
}
