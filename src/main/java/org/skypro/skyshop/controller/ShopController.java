package org.skypro.skyshop.controller;

import java.util.Collection;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ShopController {

  @Autowired
  private StorageService storageService;// = new StorageService();

  @GetMapping("/products")
  public Collection<Product> getAllProducts(){
    return storageService.getProducts().values();
  }

  @GetMapping("/articles")
  public Collection<Article> getAllArticles(){
    return storageService.getArticles().values();
  }

}
