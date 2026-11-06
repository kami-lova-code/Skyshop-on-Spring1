package org.skypro.skyshop.model.basket.data;

import java.util.List;

public record UserBasket(List<BasketItem> items,double total){
    public UserBasket(List<BasketItem> items) {
        this(List.copyOf(items),
                items.stream()
                        .mapToDouble(item -> item.product().getPrice() * item.quantity())
                        .sum());





    }

}
