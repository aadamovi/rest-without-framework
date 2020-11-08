package com.market.rates.repository;

import com.market.rates.dto.User;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

import static com.market.rates.domain.PricingTier.*;

public class InMemoryUserRepository implements UserRepository {
    private static final Map<String, User> USERS = Map.ofEntries(
            new SimpleEntry<>("default", new User.Builder().withUserId("default").withEmail("email@email.com").withPricingTier(A).build()),
            new SimpleEntry<>("test", new User.Builder().withUserId("test").withEmail("email@email1.com").withPricingTier(B).build()),
            new SimpleEntry<>("prodUser", new User.Builder().withUserId("prodUser").withEmail("email@email2.com").withPricingTier(C).build()));

    @Override
    public User getUserProfile(String userId) {
        return USERS.getOrDefault(userId, null);
    }
}
