package com.andersontiban.petsservice.service;

import com.andersontiban.petsservice.model.PetsEntity;
import com.andersontiban.petsservice.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public PetsEntity getPetById(final Long petId) {
        return petRepository.findPetsEntityById(petId);
    }

    @Override
    public ResponseEntity<PetsEntity> addPet(@RequestBody final PetsEntity pet) {
        PetsEntity entity = petRepository.save(pet);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @Override
    public List<PetsEntity> getPets() {
        return petRepository.findAll();
    }

    @Override
    public List<PetsEntity> getPetsByOwnerId(final Long ownerId) {
        return petRepository.findPetsEntityByOwnerId(ownerId);
    }
}
