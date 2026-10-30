package org.skypro.skyshop.service;

import org.skypro.skyshop.model.SearchResult;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final  StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }
    public List <SearchResult>search(String pattern) {
        if (pattern == null || pattern.isBlank())
            return List.of();


        return storageService.getAllSearchable().stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(pattern))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }

}
