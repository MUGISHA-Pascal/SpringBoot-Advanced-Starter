package com.starter.backend.repository;

import com.starter.backend.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository  extends JpaRepository<File, UUID> {
}
