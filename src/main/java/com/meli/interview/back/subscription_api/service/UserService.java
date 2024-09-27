package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.dto.SubscriptionCostDTO;
import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.dto.UserUpdateDTO;

import javax.persistence.EntityNotFoundException;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    UserDTO find(UUID id);
    UserDTO findUsername(String username);
    UserDTO addSubscription(String partner, UUID userId);
    UserDTO create(UserDTO dto);
    UserDTO update(UserUpdateDTO dto);
    void delete(UUID id);
    SubscriptionCostDTO getSubscriptionCost(UUID userId);
}
