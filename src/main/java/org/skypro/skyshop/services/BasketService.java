package org.skypro.skyshop.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

  private final StorageService storageService;
  private final ProductBasket productBasket;

  public BasketService(StorageService storageService) {
    this.storageService = storageService;
    this.productBasket = new ProductBasket();
  }

  public void add(UUID id) {
    Optional<Product> opt = storageService.getProductById(id);
    if (opt.isEmpty()) {
      throw new NoSuchProductException();
    } else {
      productBasket.add(id);
    }
  }

  public UserBasket getUserBasket() {
    Map<UUID, Integer> basketById = productBasket.getAll();
    List<BasketItem> basketItems = basketById.keySet().stream()
        .map(id -> getProductById(id, basketById))
        .toList();
    return new UserBasket(basketItems);
  }

  private BasketItem getProductById(UUID id, Map<UUID, Integer> basketById) {
    Product product = storageService.getProductById(id)
        .orElseThrow(NoSuchProductException::new);
    return new BasketItem(product, basketById.get(id));
  }
}
