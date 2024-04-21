package com.andersontiban.petsservice.repository;

import com.andersontiban.petsservice.model.PetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetsEntity, Long> {
    PetsEntity findPetsEntityById(Long id);

    PetsEntity findPetsEntityByOwnerId(Long id);
}
