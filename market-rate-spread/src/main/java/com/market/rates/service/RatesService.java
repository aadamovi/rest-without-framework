package com.market.rates.service;

import java.util.Map;

public interface RatesService {
    Map<String, Double> getRates(String baseCurrency);
}
