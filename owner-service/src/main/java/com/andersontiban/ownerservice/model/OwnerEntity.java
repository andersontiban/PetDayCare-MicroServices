package com.andersontiban.ownerservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phoneNumber;

    // Store pet IDs or handle via API calls
    @Transient // This marks the field to be not persistent
    private List<String> petNames = new ArrayList<>();

    public OwnerEntity() {
    }

    public OwnerEntity(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}