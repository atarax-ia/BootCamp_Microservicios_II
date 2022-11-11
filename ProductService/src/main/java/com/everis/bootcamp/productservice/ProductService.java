package com.everis.bootcamp.productservice;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findOne(String productId);

    Product insert (Product price);
}
