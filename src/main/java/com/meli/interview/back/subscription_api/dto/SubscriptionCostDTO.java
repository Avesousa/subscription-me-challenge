package com.meli.interview.back.subscription_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionCostDTO {
    private List<SubscriptionDTO> subscriptions;
    private Float total;
}
