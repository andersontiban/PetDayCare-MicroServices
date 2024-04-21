package com.andersontiban.ownerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetsEntity implements Serializable {
    private String name;

    private String age;

    private Long ownerId;
}
