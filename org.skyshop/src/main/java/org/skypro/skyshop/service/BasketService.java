package org.skypro.skyshop.service;

import java.util.Optional; // ✅ ЭТО ПРАВИЛЬНО

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.data.BasketItem;
import org.skypro.skyshop.model.basket.data.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    @Autowired
    public BasketService(ProductBasket productBasket,StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID id) {
         storageService.getProductById(id)
                 .orElseThrow(() -> new NoSuchProductException("Товар с id " + id + " не найден"));
        productBasket.add(id);
    }

    public UserBasket getUserBasket() {
        return new UserBasket(
                productBasket.getProducts().entrySet().stream()
                        .map(entry -> new BasketItem(
                                storageService.getProductById(entry.getKey())
                                        .orElseThrow(() -> new IllegalStateException(
                                                "Товар в корзине отсутствует в хранилище: " + entry.getKey())),
                                entry.getValue()
                        ))
                        .collect(Collectors.toList())
        );
    }



    }


