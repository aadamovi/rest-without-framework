package com.market.rates.service.impl;

import com.market.rates.config.WebConfig;
import com.market.rates.dto.ExchangeRatesResponse;
import com.market.rates.service.RatesService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Map;

import static com.market.rates.config.WebConfig.HTTP_CLIENT;

public class ExchangeRatesService implements RatesService {
    private static final String EXCHANGE_URL = "https://api.exchangeratesapi.io/latest?base=";

    @Override
    public Map<String, Double> getRates(String baseCurrency) {
        try {
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(EXCHANGE_URL + baseCurrency))
                    .build();
            final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            final ExchangeRatesResponse exchangeRatesResponse = WebConfig.MAPPER.readValue(response.body(), ExchangeRatesResponse.class);
            return exchangeRatesResponse.getRates();
        } catch (IOException | InterruptedException e) {
            System.out.println("Couldn't get rates from exchange rates API");
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }
}
