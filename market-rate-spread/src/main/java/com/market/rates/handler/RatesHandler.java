package com.market.rates.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

import static com.market.rates.config.WebConfig.MAPPER;
import static com.market.rates.config.WebConfig.SPREAD_CALCULATION_SERVICE;
import static com.market.rates.domain.HeaderConstants.CONTENT_TYPE;
import static com.market.rates.domain.ResponseCode.METHOD_NOT_ALLOWED;
import static com.market.rates.domain.ResponseCode.OK;

public class RatesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            exchange.getResponseHeaders().set(CONTENT_TYPE.getTag(), CONTENT_TYPE.getValue());
            exchange.sendResponseHeaders(OK.getCode(), 0);

            final String userId = ParametersUtility.getUserIdParameter(exchange.getRequestURI().getRawQuery());
            byte[] response = MAPPER.writeValueAsBytes(SPREAD_CALCULATION_SERVICE.calculate(userId, "USD"));

            OutputStream output = exchange.getResponseBody();
            output.write(response);
            output.flush();
        } else {
            exchange.sendResponseHeaders(METHOD_NOT_ALLOWED.getCode(), -1);
        }
        exchange.close();
    }
}
