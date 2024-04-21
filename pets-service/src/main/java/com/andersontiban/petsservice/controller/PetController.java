package com.andersontiban.petsservice.controller;

import com.andersontiban.petsservice.model.PetsEntity;
import com.andersontiban.petsservice.service.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/pets")
public class PetController {
    private final PetServiceImpl petService;

    @Autowired
    public PetController(PetServiceImpl petService) {
        this.petService = petService;
    }

    @GetMapping()
    public ResponseEntity<List<PetsEntity>> getAllPets() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPets());
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetsEntity> getPetById(@PathVariable final Long petId) {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetById(petId));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<PetsEntity> getByOwnerId(@PathVariable final long ownerId) {
        PetsEntity pet = petService.getPetByOwnerId(ownerId);
        if (pet != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<PetsEntity> newPet(@RequestBody PetsEntity pet) {
        return petService.addPet(pet);
    }

}
