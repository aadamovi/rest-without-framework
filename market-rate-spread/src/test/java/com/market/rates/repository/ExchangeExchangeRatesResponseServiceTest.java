package com.market.rates.repository;

import org.junit.Test;
import com.market.rates.service.RatesService;
import com.market.rates.service.impl.ExchangeRatesService;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExchangeExchangeRatesResponseServiceTest {

    @Test
    public void shouldInitRates() {
        final RatesService ratesRepository = new ExchangeRatesService();
        final Map<String, Double> rates = ratesRepository.getRates("SGD");
        assertNotNull(rates);
        assertTrue(rates.size() > 0);
    }
}