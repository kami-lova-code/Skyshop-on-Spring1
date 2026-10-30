package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private final double fixedPrice;

    public FixPriceProduct(UUID id, String name, double fixedPrice, boolean special) {
        super(id,name,fixedPrice,special);
        this.fixedPrice = fixedPrice;
    }

    @Override
    public double getPrice() {
        return this.fixedPrice;
    }
}