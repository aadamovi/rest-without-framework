package com.market.rates.domain;

public enum ResponseCode {
    OK(200),
    METHOD_NOT_ALLOWED(405);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
