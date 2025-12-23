package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.Product;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.springframework.stereotype.Service;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> productMap = new HashMap<>();
    private final Map<UUID, Article> articleMap = new HashMap<>();

    public StorageService() {
        initializeTestData();
    }

    private void initializeTestData() {
        Product p1 = new SimpleProduct("Макасины", 29990);
        Product p2 = new FixPriceProduct("Блуза");

        productMap.put(p1.getId(), p1);
        productMap.put(p2.getId(), p2);

        Article a1 = new Article(UUID.randomUUID(),
                "Статья о осенней обуви",
                "Обзоры новой коллекции");

     //   Article a2 = new Article(UUID.randomUUID(),
     //           "Кастомизация рубашек",
     //           "Украшения");

        articleMap.put(a1.id(), a1);
     //   articleMap.put(a2.id(), a2);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public Collection<Article> getAllArticles() {
        return articleMap.values();
    }

    public Collection<Searchable> getAllSearchables() {
        List<Searchable> result = new ArrayList<>();
        result.addAll(productMap.values());
        result.addAll(articleMap.values());
        return result;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productMap.get(id));
    }

}
