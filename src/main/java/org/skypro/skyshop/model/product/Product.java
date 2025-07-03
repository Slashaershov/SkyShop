package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;
import org.skypro.skyshop.model.search.Searchable;
import java.lang.String;

public abstract class Product implements Searchable {

  private final UUID id;
  private String name;

  public Product(String name, UUID id) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("name is null or empty");
    }
    this.name = name;
    this.id = id;
  }

  @Override
  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  abstract public int getPrice();

  public abstract boolean isSpecial();

  @Override
  public String toString() {
    return name;
  }

  @Override
  public String searchTerm() {
    return name;
  }

  @Override
  public String getType() {
    return "PRODUCT";
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}

