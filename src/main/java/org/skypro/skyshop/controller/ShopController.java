package org.skypro.skyshop.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.services.SearchService;
import org.skypro.skyshop.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

  @Autowired
  private StorageService storageService;
  @Autowired
  private SearchService searchService;

  @JsonIgnore
  @GetMapping("/products")
  public Collection<Product> getAllProducts() {
    return storageService.getProducts();
  }

  @GetMapping("/articles")
  public Collection<Article> getAllArticles() {
    return storageService.getArticles();
  }

  @GetMapping("/search")
  public Collection<SearchResult> searchMatсhes(@RequestParam String pattern) {
    return searchService.search(pattern);
  }
}
