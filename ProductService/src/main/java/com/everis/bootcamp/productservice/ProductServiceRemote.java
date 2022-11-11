package com.everis.bootcamp.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(name = "app.everis.bootcamp.services.price.type", havingValue = "remote")
public class ProductServiceRemote implements ProductService{

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceRemote.class);
    private static final String SUFFIX_GET_PRICE = "/{id}";

    private final Map<Integer, Product> internalStorage = new HashMap<>();

    @Value("${app.everis.bootcamp.services.price.endpoint}")
    private String endpoint;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Product> findAll() {
        final List<Product> resultList = this.internalStorage.values().stream().map(product -> {
            final Price priceResponse = this.restTemplate.getForObject(this.endpoint + SUFFIX_GET_PRICE, Price.class, product.getId());     // Obtenemos el objeto
            product.setPrice(priceResponse.getPriceValue());
            return product;
        }).collect(Collectors.toList());
        return resultList;
    }

    @Override
    public Product findOne(String productId) {
        if(productId != null) {
            Product product = this.internalStorage.get(Integer.valueOf(productId));
            final ResponseEntity<Price> priceResponse = this.restTemplate.getForEntity(this.endpoint + SUFFIX_GET_PRICE, Price.class, productId);   // Obtenemos las cabeceras y el cuerpo (con el objeto)
            product.setPrice(priceResponse.getBody().getPriceValue());
            return product;
        }
        return null;
    }

    @Override
    public Product insert(Product product) {
        if(product != null && product.getId() != null) {
            Integer priceValue = product.getPrice();
            product.setPrice(null);
            Price price = new Price(product.getId(), priceValue);
            Price priceResponse = this.restTemplate.postForObject(this.endpoint, price, Price.class);
            return this.internalStorage.putIfAbsent(product.getId(), product);
        }
        return null;
    }
}
