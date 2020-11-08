package com.market.rates.handler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParametersUtilityTest {

    @Test
    public void shouldSplitUserIdParameter() {
        String userId = ParametersUtility.getUserIdParameter("userId=abc");
        assertEquals(userId, "abc");
    }

    @Test
    public void shouldReturnEmptyStringNoUserId() {
        String userId = ParametersUtility.getUserIdParameter("test=test");
        assertEquals(userId, "");
    }
}