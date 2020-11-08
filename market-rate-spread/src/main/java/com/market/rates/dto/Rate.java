package com.market.rates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(builder = Rate.Builder.class)
public class Rate {
    String currency;
    Double bid;
    Double market;
    Double ask;

    private Rate() {
    }

    public String getCurrency() {
        return currency;
    }

    public Double getBid() {
        return bid;
    }

    public Double getMarket() {
        return market;
    }

    public Double getAsk() {
        return ask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Objects.equals(currency, rate.currency) &&
                Objects.equals(bid, rate.bid) &&
                Objects.equals(market, rate.market) &&
                Objects.equals(ask, rate.ask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, bid, market, ask);
    }

    public static final class Builder {
        String currency;
        Double bid;
        Double market;
        Double ask;

        public Builder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder withBid(Double bid) {
            this.bid = bid;
            return this;
        }

        public Builder withMarket(Double market) {
            this.market = market;
            return this;
        }

        public Builder withAsk(Double ask) {
            this.ask = ask;
            return this;
        }

        public Rate build() {
            Rate rate = new Rate();
            rate.ask = this.ask;
            rate.bid = this.bid;
            rate.market = this.market;
            rate.currency = this.currency;
            return rate;
        }
    }
}
