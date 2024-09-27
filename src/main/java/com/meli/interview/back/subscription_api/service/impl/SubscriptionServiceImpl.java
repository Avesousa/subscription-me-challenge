package com.meli.interview.back.subscription_api.service.impl;

import com.meli.interview.back.subscription_api.dto.SubscriptionCostDTO;
import com.meli.interview.back.subscription_api.dto.SubscriptionDTO;
import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.entity.Subscription;
import com.meli.interview.back.subscription_api.entity.User;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.mapper.SubscriptionMapper;
import com.meli.interview.back.subscription_api.service.SubscriptionService;
import com.meli.interview.back.subscription_api.repository.SubscriptionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionDAO subscriptionDAO;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionDTO get(Long id) {
        Subscription subscription = subscriptionDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found"));
        return subscriptionMapper.toDTO(subscription);
    }

    @Override
    public List<SubscriptionDTO> getAll(UserDTO user) {
        return subscriptionMapper.toDTO(subscriptionDAO.findByUserId(user.getId()));
    }

    @Override
    public SubscriptionDTO addSubscription(String partner, User user) {
        Subscription entity = Subscription.build(partner, user);
        return subscriptionMapper.toDTO(subscriptionDAO.save(entity));
    }

    @Override
    public void removeSubscription(Long id) {
        subscriptionDAO.deleteById(id);
    }

    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario que esté logueado
     * se encuentre en su lista de amigos
     * @return costo total de la suscripciones del user
     * @throws UserNotLoggedInException si no hay un usuario logueado
     */
    @Override
    public SubscriptionCostDTO getUserSubscriptionsCost(UserDTO user, UserDTO loggedUser) {
        ArrayList<SubscriptionDTO> subscriptionList = new ArrayList<>();
        if(user.isFriend(loggedUser)) {
            subscriptionList.addAll(user.getSubscriptions());
        }
        return SubscriptionCostDTO.builder()
                .subscriptions(subscriptionList)
                .total((float) subscriptionList.stream().mapToDouble(SubscriptionDTO::getPrice).sum())
                .build();
    }
}
