package com.market.rates.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PricingTierTest {

    @Test
    public void shouldReturnCorrectPricingTierFromAbbr() {
        assertEquals(PricingTier.valueOf("A"), PricingTier.A);
        assertEquals(PricingTier.valueOf("B"), PricingTier.B);
        assertEquals(PricingTier.valueOf("C"), PricingTier.C);
    }
}