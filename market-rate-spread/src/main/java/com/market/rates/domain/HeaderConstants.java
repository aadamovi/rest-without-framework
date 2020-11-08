package com.market.rates.domain;

public enum HeaderConstants {
    CONTENT_TYPE("Content-type", "application/json");

    private final String tag;
    private final String value;

    HeaderConstants(String tag, String value) {
        this.tag = tag;
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public String getValue() {
        return value;
    }
}
