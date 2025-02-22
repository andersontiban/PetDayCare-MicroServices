package com.andersontiban.ownerservice.service;

import com.andersontiban.ownerservice.model.OwnerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    List<OwnerEntity> getAllOwners();

    ResponseEntity<Object> addOwner(OwnerEntity owner);

    ResponseEntity<OwnerEntity> getOwner(Long id);

    ResponseEntity<Object> updateOwner(OwnerEntity owner);
}
