package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    UUID getId();
    String getName();
    int getPrice();
    boolean isSpecial();
    String getContentType();
    String getSearchTerm();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }

    default boolean matches(String query) {
        if (query == null) return false;
        return getStringRepresentation().toLowerCase().contains(query.toLowerCase());
    }

}