package controller;

import java.util.Collection;
import model.article.Article;
import model.product.Product;
import model.services.StorageService;
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
