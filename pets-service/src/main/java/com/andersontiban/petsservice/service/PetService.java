package com.andersontiban.petsservice.service;

import com.andersontiban.petsservice.model.PetsEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PetService {
    PetsEntity getPetById(Long petId);

    ResponseEntity<PetsEntity> addPet(PetsEntity pet);

    List<PetsEntity> getPets();

    PetsEntity getPetByOwnerId(final Long ownerId);
}
