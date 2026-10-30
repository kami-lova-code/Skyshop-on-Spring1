package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final UUID id;
    private final String name;
    private final double price;
    private final boolean special;


    public Product(UUID id, String name, double price, boolean special) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.special = special;

    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSpecial() {
        return special;
    }


    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getName();
    }
}





