package com.meli.interview.back.subscription_api.dto;

import com.meli.interview.back.subscription_api.entity.Subscription;
import com.meli.interview.back.subscription_api.entity.User;
import com.meli.interview.back.subscription_api.factory.SubscriptionFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {
    private Long id;
    private String partner;
    private Float price;
}
