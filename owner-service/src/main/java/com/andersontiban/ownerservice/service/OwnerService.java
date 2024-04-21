package com.andersontiban.ownerservice.service;

import com.andersontiban.ownerservice.model.OwnerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    List<OwnerEntity> getAllOwners();

    Optional<OwnerEntity> getOwnerById(Long id);

    ResponseEntity<Object> addOwner(OwnerEntity owner);

    ResponseEntity<OwnerEntity> getOwner(Long id);

    ResponseEntity<Object> updateOwner(Long id, OwnerEntity owner);
    List<OwnerEntity> getOwnersAndPets();
}
