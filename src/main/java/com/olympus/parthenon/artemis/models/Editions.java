package com.olympus.parthenon.artemis.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("editions")
public class Editions {
    @Id
    private String id;

    private String title;

    @Field(value = "number_of_pages")
    private int numberOfPages;

    private String subtitle;

    @Field(value = "publish_date")
    private String publishDate;

    public Editions() {}

    public Editions(String title, int numberOfPages, String subtitle, String publishDate) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.subtitle = subtitle;
        this.publishDate = publishDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
