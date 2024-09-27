package com.meli.interview.back.subscription_api.strategy;

public class DisneyPriceStrategy implements PriceStrategy{
    @Override
    public float getPrice() {
        return 100f;
    }
}
