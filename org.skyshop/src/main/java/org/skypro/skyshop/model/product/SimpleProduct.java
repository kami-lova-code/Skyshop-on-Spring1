package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {

    public SimpleProduct(UUID id, String name, double price, boolean special) {
        super(id, name, price, special);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

}



