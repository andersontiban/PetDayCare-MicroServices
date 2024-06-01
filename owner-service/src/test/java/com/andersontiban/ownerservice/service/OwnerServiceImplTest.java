package com.andersontiban.ownerservice.service;

import com.andersontiban.ownerservice.client.PetsClient;
import com.andersontiban.ownerservice.model.OwnerEntity;
import com.andersontiban.ownerservice.repository.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    private OwnerServiceImpl ownerService;
    @Mock
    private OwnerRepository ownerRepository;
    private PetsClient petsClient;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceImpl(ownerRepository, petsClient);
    }

    @Test
    void getAllOwners() {
        //when
        ownerService.getAllOwners();
        //then
        verify(ownerRepository).findAll();
    }

    @Test
    void getOwnerById() {
        //when
        ownerService.getOwnerById(1L);
        //then
        verify(ownerRepository).findById(1L);
    }

    @Test
    void addOwner() {
        //when
        OwnerEntity testOwner = new OwnerEntity(
                1L,
                "test",
                "9083323434");
        ownerService.addOwner(testOwner);
        //then
        verify(ownerRepository).save(testOwner);

    }

    @Test
    void getOwner() {
        //when
        ownerService.getOwner(1L);
        //then
        verify(ownerRepository).findById(1L);

    }
}