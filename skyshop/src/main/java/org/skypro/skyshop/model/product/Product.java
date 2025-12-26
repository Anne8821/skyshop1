package org.skypro.skyshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public abstract class Product implements Searchable {

    private final UUID id;
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

  //  @Override
 //   public String getStringRepresentation() {
 //       return getName() + " - PRODUCT";
 //   }

    public abstract int getPrice();
    public abstract boolean isSpecial();
 //   public abstract String getContactType();
}

