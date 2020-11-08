package com.market.rates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;
import java.util.Objects;

@JsonDeserialize(builder = ExchangeRatesResponse.Builder.class)
public class ExchangeRatesResponse {
    Map<String, Double> rates;
    String base;
    String date;

    private ExchangeRatesResponse() {
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRatesResponse that = (ExchangeRatesResponse) o;
        return Objects.equals(rates, that.rates) &&
                Objects.equals(base, that.base) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates, base, date);
    }

    public static final class Builder {
        Map<String, Double> rates;
        String base;
        String date;

        private Builder() {
        }

        public static Builder anExchangeRatesResponse() {
            return new Builder();
        }

        public Builder withRates(Map<String, Double> rates) {
            this.rates = rates;
            return this;
        }

        public Builder withBase(String base) {
            this.base = base;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public ExchangeRatesResponse build() {
            ExchangeRatesResponse exchangeRatesResponse = new ExchangeRatesResponse();
            exchangeRatesResponse.base = this.base;
            exchangeRatesResponse.rates = this.rates;
            exchangeRatesResponse.date = this.date;
            return exchangeRatesResponse;
        }
    }
}
