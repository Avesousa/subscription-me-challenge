package com.meli.interview.back.subscription_api.entity;

import com.meli.interview.back.subscription_api.factory.SubscriptionFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String partner;

    @Column
    private Float price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public float getPrice() {
        if(Objects.isNull(this.price)) {
            this.price = SubscriptionFactory.getStrategy(this.partner).getPrice();
        }
        return this.price;
    }

    public static Subscription build(String partner, User user) {
        return Subscription.builder()
                .partner(partner)
                .user(user)
                .price(SubscriptionFactory.getStrategy(partner).getPrice())
                .build();
    }
}
