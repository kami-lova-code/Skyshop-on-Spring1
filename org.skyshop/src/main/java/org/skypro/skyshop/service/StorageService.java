package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        loadTestData();
    }

    private void loadTestData() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();
        UUID id5 = UUID.randomUUID();

        products.put(id1, new SimpleProduct(id1, "Apple", 100.0, false));
        products.put(id2, new FixPriceProduct(id2, "Banana", 85.0, true));
        products.put(id3, new DiscountedProduct(id3, "Orange", 120.0, 0.2, true));

        articles.put(id4, new Article(id4, "How to shop", "Read this first", "guide"));
        articles.put(id5, new Article(id5, "How to Choose an Apple",
                "Apples are great. Choose red ones for sweetness.", "guide"));
    }


    public Collection<Product> getAllProducts() {
        return Collections.unmodifiableCollection(products.values());
    }

    public Collection<Article> getAllArticles() {
        return Collections.unmodifiableCollection(articles.values());
    }

    public Collection<Searchable> getAllSearchable() {
        List<Searchable> all = new ArrayList<>();
        all.addAll(products.values());
        all.addAll(articles.values());
        return Collections.unmodifiableList(all);
    }
}





