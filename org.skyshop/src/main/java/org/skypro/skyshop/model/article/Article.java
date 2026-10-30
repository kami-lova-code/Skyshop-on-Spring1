package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String title;
    private final String content;
    private final String contentType;

    public Article(UUID id,String title,String content,String contentType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.contentType = contentType;
    }

    public UUID getId() {
        return id;
    }

    public  String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @JsonIgnore
    public String getContentType() {
        return contentType;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getTitle() + " " + getContent();
    }

}
