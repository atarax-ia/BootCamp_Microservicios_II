package com.everis.bootcamp.priceservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {
    private final PriceRepository repository;

    public PriceController(PriceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Price> findAll() {

        return repository.findAll();
    }

    @PostMapping("/")
    public Price insert(@RequestBody Price newPrice) {
        return this.repository.save(newPrice);
    }

    @GetMapping("/{id}")
    public Price findOne(@PathVariable Integer id) {
        Price pr = new Price(0,0);
        pr.setProductId(0);
        try {
            return this.repository.findById(id).orElseThrow(() -> new PriceNotFoundException(id));
        } catch (PriceNotFoundException exc) {
            return pr;
        }
    }
}
