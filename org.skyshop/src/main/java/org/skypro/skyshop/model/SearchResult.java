package org.skypro.skyshop.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.skypro.skyshop.model.search.Searchable;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id,String name,String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }
    public static SearchResult fromSearchable(Searchable s) {
        String idStr = s.getId().toString();
        String name = "";
        String  contentType = "";

        if (s instanceof org.skypro.skyshop.model.product.Product p) {
            name = p.getName();
            contentType = "product";
        } else if (s instanceof org.skypro.skyshop.model.article.Article a) {
            name = a.getTitle();
            contentType = a.getContentType();
        }

        return new SearchResult(idStr,name,contentType);
    }
    public String getId() { return id; }
    public String getName() { return name;  }
    public String getContentType() { return contentType; }
    }

