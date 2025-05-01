package com.starter.backend.repository;

import com.starter.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailOrMobile(String email,String mobile);
    Optional<User> findById(UUID id);
    Boolean existsByMobile(String mobile);
}
