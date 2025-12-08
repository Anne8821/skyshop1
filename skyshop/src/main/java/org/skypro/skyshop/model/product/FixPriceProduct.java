package org.skypro.skyshop.product;

import org.skypro.skyshop.model.Product;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 5000;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getContactType() {
        return "";
    }

    @Override
    public String toString() {
        return getName() + ": фиксированная цена " + FIXED_PRICE;
    }

}