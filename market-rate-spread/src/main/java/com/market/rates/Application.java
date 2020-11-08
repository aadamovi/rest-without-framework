package com.market.rates;

import com.sun.net.httpserver.HttpServer;
import com.market.rates.handler.RatesHandler;
import com.market.rates.handler.UserHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

import static com.market.rates.config.WebConfig.SERVER_PORT;

public class Application {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);

        UserHandler userHandler = new UserHandler();
        server.createContext("/user/profile/userId", userHandler);

        RatesHandler ratesHandler = new RatesHandler();
        server.createContext("/rates/latest", ratesHandler);

        server.setExecutor(null); // creates a default executor
        server.start();

        System.out.println("--------------");
        System.out.println("Server started");
        System.out.println("--------------");
    }
}
