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
    fillProduct(products);
    this.articles = new HashMap<>();
    fillArticles(articles);
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

  private void fillProduct(Map<UUID, Product> products) {
    UUID uuid = UUID.randomUUID();
    products.put(uuid, new SimpleProduct("t-short blue", 120, uuid));
    uuid = UUID.randomUUID();
    products.put(uuid, new SimpleProduct("t-short red", 130, uuid));
    uuid = UUID.randomUUID();
    products.put(uuid, new FixPriceProduct("soks red Big", uuid));
    uuid = UUID.randomUUID();
    products.put(uuid, new FixPriceProduct("soks red Small", uuid));
    uuid = UUID.randomUUID();
    products.put(uuid, new DiscontedProduct("gredy red shorts  ", 100, 20, uuid));
    uuid = UUID.randomUUID();
    products.put(uuid, new DiscontedProduct("redy for life red shorts ", 200, 15, uuid));
  }

  private void fillArticles(Map<UUID, Article> articles) {
    UUID uuid = UUID.randomUUID();
    articles.put(uuid, new Article("shorts life", "some text", uuid));
    uuid = UUID.randomUUID();
    articles.put(uuid, new Article("soks red life", "some text red", uuid));
  }
}

