package com.everis.bootcamp.priceservice;

import java.util.List;

public interface PriceService {
    List<Price> findAll();

    Price findOne(Integer productId);

    Price insert (Price price);
}
