package com.starter.backend.repository;

import com.starter.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value="SELECT * from Product where category = :category",nativeQuery = true)
    List<Product> findByCategory(String category);
}
