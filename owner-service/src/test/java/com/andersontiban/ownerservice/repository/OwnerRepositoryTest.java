package com.andersontiban.ownerservice.repository;

import com.andersontiban.ownerservice.model.OwnerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
        ownerRepository.deleteAll();
    }

    @Test
    void shouldFindOwnerByName() {
        //given
        OwnerEntity owner = new OwnerEntity(1L,
                "testUser",
                "9083312349"
        );
        ownerRepository.save(owner);

        //when
        OwnerEntity ownerfromDb = ownerRepository.findByName("testUser");
        //then
        assertThat(ownerfromDb).isEqualTo(owner);

    }
}
