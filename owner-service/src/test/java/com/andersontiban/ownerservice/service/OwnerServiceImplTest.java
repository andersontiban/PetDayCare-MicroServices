package com.andersontiban.ownerservice.service;

import com.andersontiban.ownerservice.model.OwnerEntity;
import com.andersontiban.ownerservice.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    private OwnerServiceImpl ownerService;
    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceImpl(ownerRepository);
    }

    @Test
    void getAllOwners() {
        //when
        ownerService.getAllOwners();
        //then
        verify(ownerRepository).findAll();
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
}