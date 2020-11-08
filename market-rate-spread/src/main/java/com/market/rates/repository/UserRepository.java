package com.market.rates.repository;

import com.market.rates.dto.User;

public interface UserRepository {
    User getUserProfile(String userId);
}
