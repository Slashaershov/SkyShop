package org.skypro.skyshop.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.UUID;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.services.BasketService;
import org.skypro.skyshop.services.SearchService;
import org.skypro.skyshop.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShopController {

  private final StorageService storageService;
  private final SearchService searchService;
  private final BasketService basketService;

  public ShopController(StorageService storageService, SearchService searchService,
      BasketService basketService) {
    this.storageService = storageService;
    this.searchService = searchService;
    this.basketService = basketService;
  }

  @GetMapping("/products")
  public Collection<Product> getAllProducts() {
    return storageService.getProducts();
  }

  @GetMapping("/basket/{id}")
  public String addProduct(@PathVariable("id") UUID id) {
    basketService.add(id);
    return "Продукт успешно добавлен";
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
