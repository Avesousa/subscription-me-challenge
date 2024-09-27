package com.meli.interview.back.subscription_api.repository;

import com.meli.interview.back.subscription_api.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubscriptionDAO extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findById(Long id);
    List<Subscription> findByUserId(UUID id);
}
