package com.dkreth.shorty.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shorty test data")
public class Record {

    @Id
    private String id;
    private String shortId;
    private String longUrl;

    public Record(String shortId, String longUrl) {
        this.shortId = shortId;
        this.longUrl = longUrl;
    }

    public String getShortId() {
        return shortId;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
