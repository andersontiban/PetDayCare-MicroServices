package com.andersontiban.petsservice.repository;

import com.andersontiban.petsservice.model.PetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetsEntity, Long> {
    PetsEntity findPetsEntityById(Long id);

    List<PetsEntity> findPetsEntityByOwnerId(Long id);
}
