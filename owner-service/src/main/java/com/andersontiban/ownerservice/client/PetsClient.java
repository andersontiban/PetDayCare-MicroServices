package com.andersontiban.ownerservice.client;

import com.andersontiban.ownerservice.model.PetsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface PetsClient {

    @GetExchange("pets/owner/{ownerId}")
    public PetsEntity getByOwnerId(@PathVariable final long ownerId);
}
