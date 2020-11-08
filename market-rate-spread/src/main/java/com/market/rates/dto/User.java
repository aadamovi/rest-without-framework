package com.market.rates.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.market.rates.domain.PricingTier;

import java.util.Objects;

@JsonDeserialize(builder = User.Builder.class)
public class User {
    String userId;
    String email;
    PricingTier pricingTier;

    private User() {
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public PricingTier getPricingTier() {
        return pricingTier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(email, user.email) &&
                pricingTier == user.pricingTier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, pricingTier);
    }

    public static final class Builder {
        String userId;
        String email;
        PricingTier pricingTier;

        public Builder() {
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPricingTier(PricingTier pricingTier) {
            this.pricingTier = pricingTier;
            return this;
        }

        public User build() {
            User user = new User();
            user.userId = this.userId;
            user.email = this.email;
            user.pricingTier = this.pricingTier;
            return user;
        }
    }
}
