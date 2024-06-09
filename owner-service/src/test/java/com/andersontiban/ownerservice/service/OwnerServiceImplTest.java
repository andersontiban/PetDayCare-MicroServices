package com.andersontiban.ownerservice.service;

import com.andersontiban.ownerservice.client.PetsClient;
import com.andersontiban.ownerservice.model.OwnerEntity;
import com.andersontiban.ownerservice.repository.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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
        //given
        OwnerEntity testOwner = new OwnerEntity(
                1L,
                "test",
                "9083323434");
        //when
        ownerService.addOwner(testOwner);
        //then
        ArgumentCaptor<OwnerEntity> ownerArgumentCaptor = ArgumentCaptor.forClass(OwnerEntity.class); // this line goes to the actual ownerRepo.save(owner) and gets the owner from the param
        verify(ownerRepository).save(ownerArgumentCaptor.capture());

        OwnerEntity capturedOwner = ownerArgumentCaptor.getValue();
        assertThat(capturedOwner).isEqualTo(testOwner);

    }

    @Test
    void getOwner() {
        //when
        ownerService.getOwner(1L);
        //then
        verify(ownerRepository).findById(1L);

    }

//    @Test
//    void updateOwner() {
//        OwnerEntity testOwner = new OwnerEntity(
//                1L,
//                "test",
//                "9083323434");
//         //when
//        ownerService.updateOwner(eq(1L), any(OwnerEntity.class));
//
//        //then
//        verify(ownerRepository).findById(any());
//    }
}