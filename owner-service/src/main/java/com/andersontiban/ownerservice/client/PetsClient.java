package com.andersontiban.ownerservice.client;

import com.andersontiban.ownerservice.model.PetsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface PetsClient {

    @GetExchange("pets/owner/{ownerId}")
    //make method name more descriptive as to what it get, getpetlistbyOwnerID
    public List<PetsEntity> getByOwnerId(@PathVariable final long ownerId);
}
