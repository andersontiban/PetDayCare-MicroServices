package com.andersontiban.ownerservice.controller;

import com.andersontiban.ownerservice.model.OwnerEntity;
import com.andersontiban.ownerservice.service.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerServiceImpl ownerService;

    @Autowired
    public OwnerController(final OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    //Get all owners
    @GetMapping()
    public List<OwnerEntity> allOwners() {
        return ownerService.getAllOwners();
    }

    //Get owner by ID
    @GetMapping("/{id}")
    public ResponseEntity<OwnerEntity> specificOwner(@PathVariable Long id) {
        return ownerService.getOwner(id);
    }

    //Add an owner
    @PostMapping("/new")
    public ResponseEntity<Object> newOwner(@RequestBody OwnerEntity owner) {
        return ownerService.addOwner(owner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editOwner(@RequestBody OwnerEntity owner) {
        return ownerService.updateOwner(owner);
    }

}
