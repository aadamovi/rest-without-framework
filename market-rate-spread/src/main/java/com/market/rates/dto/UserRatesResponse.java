package com.market.rates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = UserRatesResponse.Builder.class)
public class UserRatesResponse {
    List<Rate> rates;
    String base;

    private UserRatesResponse() {
    }

    public List<Rate> getRates() {
        return rates;
    }

    public String getBase() {
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRatesResponse that = (UserRatesResponse) o;
        return Objects.equals(rates, that.rates) &&
                Objects.equals(base, that.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates, base);
    }

    public static final class Builder {
        List<Rate> rates;
        String base;

        public Builder withRates(List<Rate> rates) {
            this.rates = rates;
            return this;
        }

        public Builder withBase(String base) {
            this.base = base;
            return this;
        }

        public UserRatesResponse build() {
            UserRatesResponse userRatesResponse = new UserRatesResponse();
            userRatesResponse.base = this.base;
            userRatesResponse.rates = this.rates;
            return userRatesResponse;
        }
    }
}
