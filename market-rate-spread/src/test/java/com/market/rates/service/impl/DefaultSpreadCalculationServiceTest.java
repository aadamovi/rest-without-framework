package com.market.rates.service.impl;

import com.market.rates.dto.UserRatesResponse;
import org.junit.Test;
import com.market.rates.service.SpreadCalculationService;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultSpreadCalculationServiceTest {
    private static final List<String> CURRENCIES = List.of("HKD", "USD", "MYR", "SGD");

    @Test
    public void shouldCalculateSpread() {
        SpreadCalculationService spreadCalculationService = new DefaultSpreadCalculationService();
        final String baseCurrency = "USD";
        UserRatesResponse response = spreadCalculationService.calculate("default", baseCurrency);
        assertEquals(response.getBase(), baseCurrency);

        response.getRates().forEach(rate -> {
            assertTrue(CURRENCIES.contains(rate.getCurrency()));
            assertNotNull(rate.getMarket());
            assertNotNull(rate.getAsk());
            assertNotNull(rate.getBid());
        });
    }

}