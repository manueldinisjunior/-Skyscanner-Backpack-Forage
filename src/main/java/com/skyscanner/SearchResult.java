package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty
    private String city;
    @JsonProperty
    private String kind;
    @JsonProperty
    private String title;

    public SearchResult() {}

    public SearchResult(String city, String kind, String title) {
        this.city= city;
        this.kind = kind;
        this.title = title;
    }

    public String getCity() {
        return this.city;
    }

    public String getKind() {
        return this.kind;
    }

    public String getTitle() {
        return this.title;
    }
}
