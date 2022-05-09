package com.olympus.parthenon.artemis.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("editions")
@NoArgsConstructor
public class Editions {
    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String title;

    @Field(value = "number_of_pages")
    @Getter
    @Setter
    private int numberOfPages;

    @Getter
    @Setter
    private String subtitle;

    @Field(value = "publish_date")
    @Getter
    @Setter
    private String publishDate;

    public Editions(String title, int numberOfPages, String subtitle, String publishDate) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.subtitle = subtitle;
        this.publishDate = publishDate;
    }
}
