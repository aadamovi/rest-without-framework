package com.market.rates.handler;

import com.sun.net.httpserver.HttpServer;
import com.market.rates.config.TestConfig;
import com.market.rates.domain.PricingTier;
import com.market.rates.dto.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.market.rates.config.WebConfig.HTTP_CLIENT;
import static org.junit.Assert.assertEquals;

public class UserHandlerTest {
    @Before
    public void setUp() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8002), 0);

        UserHandler userHandler = new UserHandler();
        server.createContext("/user/profile/userId", userHandler);

        server.setExecutor(null); // creates a default executor
        server.start();

        System.out.println("--------------");
        System.out.println("Server started");
        System.out.println("--------------");
    }

    @Test
    public void shouldGetUser() throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8002/user/profile/userId?userId=default"))
                .build();
        final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        final User user = TestConfig.MAPPER.readValue(response.body(), User.class);

        assertEquals(user.getUserId(), "default");
        assertEquals(user.getPricingTier(), PricingTier.A);
        assertEquals(user.getEmail(), "email@email.com");
    }

}