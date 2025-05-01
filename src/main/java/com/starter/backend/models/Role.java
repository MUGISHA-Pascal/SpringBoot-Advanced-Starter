package com.starter.backend.models;

import com.starter.backend.enums.ERoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ERoleType name;
    public Role(ERoleType name){
        this.name=name;
    }
}
