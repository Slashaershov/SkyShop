package org.skypro.skyshop.model.search;

import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class SearchResult {

  private final String id;
  private final String name;
  private final String contentType;

  public SearchResult(String id, String name, String contentType) {
    this.id = id;
    this.name = name;
    this.contentType = contentType;
  }

  public static SearchResult fromSearchable(Searchable searchable) {
    return new SearchResult(searchable.getId().toString(), searchable.getName(),
        searchable.getType());
  }

  public String getName(){
    return toString();
  }

  @Override
  public String toString() {
    return "SearchResult{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", contentType='" + contentType + '\'' +
        '}';
  }
}
