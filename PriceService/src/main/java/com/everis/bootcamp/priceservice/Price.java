package com.everis.bootcamp.priceservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Price {

    @Id
    @GeneratedValue
    private Integer productId;

    private Integer priceValue;

    public Price() { }

    public Price(Integer productId, Integer priceValue) {
        this.productId = productId;
        this.priceValue = priceValue;
    }

    public Integer getPriceValue() {
        return this.priceValue;
    }

    public void setPriceValue(final Integer priceValue) {
        this.priceValue = priceValue;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Price{" +
                "productId=" + productId +
                ", priceValue=" + priceValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(productId, price.productId) && Objects.equals(priceValue, price.priceValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, priceValue);
    }
}
