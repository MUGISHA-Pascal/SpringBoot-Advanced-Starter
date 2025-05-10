package com.starter.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String filename;
    @Lob
    private byte[] file;
}
