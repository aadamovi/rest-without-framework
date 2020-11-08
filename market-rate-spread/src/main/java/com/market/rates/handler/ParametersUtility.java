package com.market.rates.handler;

import java.util.List;

public class ParametersUtility {

    public static String getUserIdParameter(String queryParams) {
        if (queryParams.contains("userId")) {
            List<String> allParameters = List.of(queryParams.split("="));
            int index = allParameters.indexOf("userId");
            return allParameters.get(index + 1);
        }
        return "";
    }
}
