package org.skypro.skyshop.services;

import java.util.Collection;
import java.util.List;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SearchService {

  private final StorageService storageService;

  public SearchService(StorageService storageService) {
    this.storageService = storageService;
  }

  public Collection<SearchResult> search(String str) {
    return storageService.getAllSearchables().stream()
        .map(SearchResult::fromSearchable)
        .toList();
  }
}
