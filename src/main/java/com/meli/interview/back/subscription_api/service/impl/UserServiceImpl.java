package com.meli.interview.back.subscription_api.service.impl;

import com.meli.interview.back.subscription_api.dto.SubscriptionCostDTO;
import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.dto.UserUpdateDTO;
import com.meli.interview.back.subscription_api.entity.User;
import com.meli.interview.back.subscription_api.mapper.UserMapper;
import com.meli.interview.back.subscription_api.repository.UserDAO;
import com.meli.interview.back.subscription_api.service.SubscriptionService;
import com.meli.interview.back.subscription_api.service.UserService;
import com.meli.interview.back.subscription_api.session.UserSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDAO userDao;
    private UserMapper userMapper;
    private UserSession userSession;
    private SubscriptionService subscriptionService;
    @Override
    public UserDTO find(UUID id) {
        return userMapper.toDTO(userDao.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    @Override
    public UserDTO findUsername(String username) {
        User user = userDao.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO addSubscription(String partner, UUID userId) {
        User user = userDao.findById(userId).orElseThrow(()-> new EntityNotFoundException("User not found"));
        subscriptionService.addSubscription(partner, user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toDTO(userDao.save(user));
    }

    @Override
    public UserDTO update(UserUpdateDTO dto) {
        User user = userDao.findById(dto.getId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        userMapper.entityFromDTO(dto, user);
        return userMapper.toDTO(userDao.save(user));
    }

    @Override
    public void delete(UUID id) {
        userDao.deleteById(id);
    }

    @Override
    public SubscriptionCostDTO getSubscriptionCost(UUID userId) {
        UserDTO userCurrent = userSession.getLoggedUser();
        UserDTO user = find(userId);
        return subscriptionService.getUserSubscriptionsCost(user, userCurrent);
    }
}
