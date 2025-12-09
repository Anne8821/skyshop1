package org.skypro.skyshop.model.service;

import org.springframework.stereotype.Service;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String pattern) {
        return storageService.getAllSearchables().stream()
                .filter(s -> s.matches(pattern))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}