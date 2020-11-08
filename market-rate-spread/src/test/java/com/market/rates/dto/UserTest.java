package com.market.rates.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.market.rates.domain.PricingTier;
import org.junit.Test;

import static com.market.rates.config.TestConfig.MAPPER;
import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldSerialize() throws JsonProcessingException {
        String actualJson = MAPPER.writeValueAsString(user());
        assertEquals(json(), actualJson);
    }

    @Test
    public void shouldDeserialize() throws JsonProcessingException {
        User actualUser = MAPPER.readValue(json(), User.class);
        assertEquals(user(), actualUser);
    }

    private String json() {
        return "{\"userId\":\"test\",\"email\":\"test@email.com\",\"pricingTier\":\"A\"}";
    }

    private User user() {
        return new User.Builder()
                .withUserId("test")
                .withEmail("test@email.com")
                .withPricingTier(PricingTier.A)
                .build();
    }
}