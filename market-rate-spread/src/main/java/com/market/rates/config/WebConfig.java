package com.market.rates.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.rates.repository.InMemoryUserRepository;
import com.market.rates.repository.UserRepository;
import com.market.rates.service.RatesService;
import com.market.rates.service.SpreadCalculationService;
import com.market.rates.service.impl.DefaultSpreadCalculationService;
import com.market.rates.service.impl.ExchangeRatesService;

import java.net.http.HttpClient;

public class WebConfig {
    public static final int SERVER_PORT = 8000;
    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    public static final UserRepository USER_REPOSITORY = new InMemoryUserRepository();
    public static final RatesService RATES_SERVICE = new ExchangeRatesService();
    public static final SpreadCalculationService SPREAD_CALCULATION_SERVICE = new DefaultSpreadCalculationService();

    private WebConfig() {
    }
}
