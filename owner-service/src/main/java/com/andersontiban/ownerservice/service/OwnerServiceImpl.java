package com.andersontiban.ownerservice.service;

import com.andersontiban.ownerservice.model.OwnerEntity;
import com.andersontiban.ownerservice.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{
    private final OwnerRepository repository;


    @Autowired
    public OwnerServiceImpl(OwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("owners")
    public List<OwnerEntity> getAllOwners() {
        return repository.findAll();
    }

    //add owner
    @Override
    public ResponseEntity<Object> addOwner(final OwnerEntity owner) {
        //check if owner already in db, if true return error or something
        OwnerEntity existingOwner = repository.findByName(owner.getName());

        if (existingOwner != null) return ResponseEntity.status(HttpStatus.CONFLICT).body("Owner exist");

        repository.save(owner);

        return ResponseEntity.status(HttpStatus.CREATED).body(owner.getName() + " Added");
    }

    // find owner by Id
    @Override
    public ResponseEntity<OwnerEntity> getOwner(Long id) {
        Optional<OwnerEntity> owner = repository.findById(id);

        if (owner.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(owner.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<Object> updateOwner(OwnerEntity owner) {
        if (owner.getId() == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Owner ID is required");

        OwnerEntity ownerEntity = repository.findById(owner.getId())
                .orElseThrow(() -> new EntityNotFoundException("Owner does not exist"));
        if (owner.getName() != null) {
            ownerEntity.setName(owner.getName());
        }
        if (owner.getPhoneNumber() != null) {
            ownerEntity.setPhoneNumber(owner.getPhoneNumber());
        }
        OwnerEntity updatedOwner = repository.save(ownerEntity);
        return ResponseEntity.status(HttpStatus.OK).body(updatedOwner);

    }

}
