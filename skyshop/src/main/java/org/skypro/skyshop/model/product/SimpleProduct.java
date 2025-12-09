package org.skypro.skyshop.product;

import org.skypro.skyshop.model.Product;

public class SimpleProduct extends Product {

    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительной");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getContactType() {
        return "";
    }

    @Override
    public String toString() {
        return getName() + ": " + price;
    }
}
