package model.services;


import com.sun.source.tree.Tree;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import model.article.Article;
import model.product.DiscontedProduct;
import model.product.FixPriceProduct;
import model.product.Product;
import model.product.SimpleProduct;
import model.search.Searchable;
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

  public Map<UUID, Article> getArticles() {
    return articles;
  }

  public Map<UUID, Product> getProducts() {
    return products;
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

