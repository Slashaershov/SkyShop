package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public class BasketItem {

  private final Product product;
  private final int count;

  public BasketItem(Product product, int count) {
    this.count = count;
    this.product = product;
  }

  public int getPrice() {
    return product.getPrice();
  }

  public int getCount() {
    return count;
  }
}
