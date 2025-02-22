package com.andersontiban.ownerservice.repository;

import com.andersontiban.ownerservice.model.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
    OwnerEntity findByName(String name);
}
