package com.market.rates.repository;

import com.market.rates.dto.User;
import org.junit.Test;

import static com.market.rates.domain.PricingTier.A;
import static org.junit.Assert.assertEquals;

public class InMemoryUserRepositoryTest {
    private final UserRepository userRepository = new InMemoryUserRepository();

    @Test
    public void shouldReturnUserProfile() {
        final User user = userRepository.getUserProfile("default");
        assertEquals(user, new User.Builder().withUserId("default").withEmail("email@email.com").withPricingTier(A).build());
    }
}