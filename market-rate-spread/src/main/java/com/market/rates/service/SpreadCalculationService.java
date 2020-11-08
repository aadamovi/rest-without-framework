package com.market.rates.service;

import com.market.rates.dto.UserRatesResponse;

public interface SpreadCalculationService {
    UserRatesResponse calculate(String userId, String baseCurrency);
}
