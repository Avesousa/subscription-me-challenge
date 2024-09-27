package com.meli.interview.back.subscription_api.service;

import com.meli.interview.back.subscription_api.dto.SubscriptionDTO;
import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.entity.Subscription;
import com.meli.interview.back.subscription_api.mapper.SubscriptionMapper;
import com.meli.interview.back.subscription_api.repository.SubscriptionDAO;
import com.meli.interview.back.subscription_api.service.impl.SubscriptionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
public class SubscriptionServiceImplTest {

    @Mock
    private SubscriptionDAO subscriptionDAO;

    @Mock
    private SubscriptionMapper subscriptionMapper;

    @InjectMocks
    private SubscriptionServiceImpl subscriptionService;

    @Test
    public void testGetSubscriptionById() {
        Long subscriptionId = 1L;
        Subscription subscription = new Subscription();
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();

        when(subscriptionDAO.findById(subscriptionId)).thenReturn(Optional.of(subscription));
        when(subscriptionMapper.toDTO(subscription)).thenReturn(subscriptionDTO);

        SubscriptionDTO result = subscriptionService.get(subscriptionId);
        assertNotNull(result);
    }

//    @Test
//    public void testAddSubscription() {
//        String partner = "TestPartner";
//        User userDTO = new User();
//        Subscription subscription = new Subscription();
//        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
//
//        when(subscriptionMapper.toEntity(any(SubscriptionDTO.class))).thenReturn(subscription);
//        when(subscriptionDAO.save(subscription)).thenReturn(subscription);
//        when(subscriptionMapper.toDTO(subscription)).thenReturn(subscriptionDTO);
//
//        SubscriptionDTO result = subscriptionService.addSubscription(partner, userDTO);
//        assertNotNull(result);
//    }

    @Test
    public void testGetAllSubscriptionsForUser() {
        UserDTO userDTO = new UserDTO();
        List<Subscription> subscriptions = new ArrayList<>();
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();

        when(subscriptionDAO.findByUserId(userDTO.getId())).thenReturn(subscriptions);
        when(subscriptionMapper.toDTO(subscriptions)).thenReturn(subscriptionDTOS);

        List<SubscriptionDTO> result = subscriptionService.getAll(userDTO);
        assertEquals(subscriptionDTOS, result);
    }
}
