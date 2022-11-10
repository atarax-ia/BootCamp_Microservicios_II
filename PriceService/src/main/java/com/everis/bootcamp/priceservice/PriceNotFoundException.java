package com.everis.bootcamp.priceservice;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(Integer id) {
        super("No se pudo encontrar el precio con Id: " + id);
    }
}
