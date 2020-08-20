package com.dkreth.shorty.model;

public class Record {
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
