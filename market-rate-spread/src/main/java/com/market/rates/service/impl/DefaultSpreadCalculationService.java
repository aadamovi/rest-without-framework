package com.market.rates.service.impl;

import com.market.rates.dto.Rate;
import com.market.rates.dto.UserRatesResponse;
import com.market.rates.service.SpreadCalculationService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.market.rates.config.WebConfig.RATES_SERVICE;
import static com.market.rates.config.WebConfig.USER_REPOSITORY;

public class DefaultSpreadCalculationService implements SpreadCalculationService {
    private static final List<String> CURRENCIES = List.of("HKD", "USD", "MYR", "SGD");

    @Override
    public UserRatesResponse calculate(String userId, String baseCurrency) {
        final Map<String, Double> baseRates = RATES_SERVICE.getRates(baseCurrency);
        final double spreadMultiplier = USER_REPOSITORY.getUserProfile(userId).getPricingTier().getSpreadMultiplier();

        final List<Rate> currencySpreads = CURRENCIES.stream()
                .map(currency -> {
                    double marketRate = baseRates.get(currency);
                    double spread = marketRate * spreadMultiplier;
                    return new Rate.Builder()
                            .withCurrency(currency)
                            .withMarket(marketRate)
                            .withBid(marketRate - spread)
                            .withAsk(marketRate + spread)
                            .build();
                })
                .collect(Collectors.toList());

        return new UserRatesResponse.Builder()
                .withBase(baseCurrency)
                .withRates(currencySpreads)
                .build();
    }
}
