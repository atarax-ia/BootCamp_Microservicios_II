package com.everis.bootcamp.priceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping        // == @GetMapping("/")
    public ResponseEntity<List<Price>> findAll() {

        return ResponseEntity.ok(priceService.findAll());
    }

    @PostMapping        // == @PostMapping("/")
    public ResponseEntity<Price> insert(@RequestBody final Price newPrice) {

        return (newPrice != null && newPrice.getProductId() != null)
                ? ResponseEntity.ok(this.priceService.insert(newPrice))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> findOne(@PathVariable final Integer id) {
        if(id == 0) {
            throw new IllegalArgumentException();
        }
        return (id != null)
                ? ResponseEntity.ok(priceService.findOne(id))
                : ResponseEntity.badRequest().build();
    }
}
