package org.skypro.skyshop.model.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void shouldReturnEmptyResultWhenStorageIsEmpty() {
        when(storageService.getAllSearchables())
                .thenReturn(Collections.emptyList());

        Collection<SearchResult> results = searchService.search("test");

        assertThat(results).isEmpty();
    }

    @Test
    void shouldReturnEmptyResultWhenNoMatchesFound() {
        Searchable product = new SimpleProduct("Жакет", 17000);

        when(storageService.getAllSearchables())
                .thenReturn(List.of(product));

        Collection<SearchResult> results = searchService.search("Куртка");

        assertThat(results).isEmpty();
    }

    @Test
    void shouldReturnResultWhenMatchExists() {
        Searchable product = new SimpleProduct("TestProduct", 1000);

        when(storageService.getAllSearchables())
                .thenReturn(List.of(product));

        Collection<SearchResult> results = searchService.search("Test");

        assertThat(results).hasSize(1);
    }
}
