package model.article;

import java.util.Objects;
import java.util.UUID;
import model.search.Searchable;
import org.springframework.stereotype.Component;

public class Article implements Searchable {

  private final UUID id;
  private String name;
  private String text;

  public Article(String name, String text, UUID id) {
    this.name = name;
    this.text = text;
    this.id = id;
  }

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String toString() {
    return name + "/n" + text;
  }

  @Override
  public String searchTerm() {
    return name + ". " + text;
  }

  @Override
  public String getType() {
    return "ARTICLE";
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return Objects.equals(name, article.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}

