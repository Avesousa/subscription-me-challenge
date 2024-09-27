package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.dto.SubscriptionDTO;
import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.entity.Subscription;
import com.meli.interview.back.subscription_api.entity.User;
import com.meli.interview.back.subscription_api.mapper.SubscriptionMapper;
import com.meli.interview.back.subscription_api.mapper.UserMapper;
import com.meli.interview.back.subscription_api.repository.SubscriptionDAO;
import com.meli.interview.back.subscription_api.repository.UserDAO;
import com.meli.interview.back.subscription_api.service.impl.SubscriptionServiceImpl;
import com.meli.interview.back.subscription_api.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserDAO userDao;

    @Mock
    private UserMapper userMapper;

    @Mock
    private SubscriptionService subscriptionService;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testFindUserById() {
        UUID userId = UUID.randomUUID();
        UserDTO userDTO = getAnUserDTO(userId);

        when(userDao.findById(userId)).thenReturn(Optional.of(new User()));
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        UserDTO result = userService.find(userId);
        assertEquals(userId, result.getId());
    }

    @Test
    public void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        User user = new User();

        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        when(userDao.save(any(User.class))).thenReturn(user);
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO);

        UserDTO result = userService.create(userDTO);
        assertNotNull(result);
    }

    @Test
    public void testAddSubscription() {
        UUID userId = UUID.randomUUID();
        User user = getAnUser(userId);

        when(userDao.findById(userId)).thenReturn(Optional.of(new User()));
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);

        userService.addSubscription("partnerTest", userId);

        verify(subscriptionService, times(1)).addSubscription("partnerTest", user);
    }

    private User getAnUser(UUID id) {
        return User.builder()
                .id(id)
                .username("test1")
                .build();
    }

    private UserDTO getAnUserDTO(UUID id) {
        return UserDTO.builder()
                .id(id)
                .username("test1")
                .build();
    }
}

