package com.market.rates.handler;

import com.sun.net.httpserver.HttpServer;
import com.market.rates.config.TestConfig;
import com.market.rates.dto.UserRatesResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.market.rates.config.WebConfig.HTTP_CLIENT;
import static org.junit.Assert.*;

public class RatesHandlerTest {

    @Before
    public void setUp() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8003), 0);

        RatesHandler ratesHandler = new RatesHandler();
        server.createContext("/rates/latest", ratesHandler);

        server.setExecutor(null); // creates a default executor
        server.start();

        System.out.println("--------------");
        System.out.println("Server started");
        System.out.println("--------------");
    }

    @Test
    public void shouldGetRates() throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8003/rates/latest?userId=default"))
                .build();
        final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        final UserRatesResponse userRatesResponse = TestConfig.MAPPER.readValue(response.body(), UserRatesResponse.class);
        assertEquals(userRatesResponse.getBase(), "USD");
    }
}