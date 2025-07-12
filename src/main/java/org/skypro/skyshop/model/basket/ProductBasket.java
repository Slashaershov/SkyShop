package org.skypro.skyshop.model.basket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.skypro.skyshop.model.product.Product;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class ProductBasket {

  private final Map<UUID, Integer> products;

  public ProductBasket() {
    products = new HashMap<>();
  }

  public void add(UUID id) {
    products.put(id, products.getOrDefault(id, 0) + 1);
  }

  public Map<UUID, Integer> get() {
    return Collections.unmodifiableMap(products);
  }
}
