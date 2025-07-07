package org.skypro.skyshop.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscontedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

  private final Map<UUID, Product> products;
  private final Map<UUID, Article> articles;

  public StorageService() {
    this.products = new HashMap<>();
    fillProduct();
    this.articles = new HashMap<>();
    fillArticles();
  }

  public Collection<Article> getArticles() {
    return articles.values();
  }

  public Collection<Product> getProducts() {
    return products.values();
  }

  public Collection<Searchable> getAllSearchables() {
    Collection<Searchable> res = new ArrayList<>();
    res.addAll(getArticles());
    res.addAll(getProducts());
    return res;
  }

  private void fillProduct() {
    putProduct(new SimpleProduct("t-short blue", 120));
    putProduct(new SimpleProduct("t-short red", 130));
    putProduct(new FixPriceProduct("soks red Big"));
    putProduct(new FixPriceProduct("soks red Small"));
    putProduct(new DiscontedProduct("gredy red shorts  ", 100, 20));
    putProduct(new DiscontedProduct("redy for life red shorts ", 200, 15));
  }

  private void putProduct(Product newProduct) {
    products.put(newProduct.getId(), newProduct);
  }

  private void fillArticles() {
    putArticle(new Article("shorts life", "some text"));
    putArticle(new Article("soks red life", "some text red"));
  }

  private void putArticle(Article newArticle) {
    articles.put(newArticle.getId(), newArticle);
  }
}

