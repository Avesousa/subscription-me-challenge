package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.dto.SubscriptionCostDTO;
import com.meli.interview.back.subscription_api.dto.SubscriptionDTO;
import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.entity.User;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {
    SubscriptionDTO get(Long id);
    List<SubscriptionDTO> getAll(UserDTO user);
    SubscriptionDTO addSubscription(String partner, User user);
    void removeSubscription(Long id);
    SubscriptionCostDTO getUserSubscriptionsCost(UserDTO user, UserDTO loggedUser);
}
