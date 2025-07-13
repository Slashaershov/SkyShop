package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {

  private final List<BasketItem> items;
  private final float total;

  public UserBasket(List<BasketItem> items) {
    this.items = items;
    total = items.stream()
        .mapToInt(item -> item.getCount() * item.getPrice())
        .sum();
  }
}
