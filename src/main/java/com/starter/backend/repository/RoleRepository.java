package com.starter.backend.repository;

import com.starter.backend.enums.ERoleType;
import com.starter.backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository  extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(ERoleType roleType);
}
