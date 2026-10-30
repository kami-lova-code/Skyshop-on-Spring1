package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final double discountPercent;

    public DiscountedProduct(UUID id, String name, double basePrice, double discountPercent, boolean special) {

        super(id, name, basePrice * (1.0 - discountPercent), special);

        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {

        return basePrice * (1.0 - discountPercent);
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
}
