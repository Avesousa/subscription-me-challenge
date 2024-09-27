package com.meli.interview.back.subscription_api.strategy;

public class NetflixPriceStrategy implements PriceStrategy{
    @Override
    public float getPrice() {
        return 200f;
    }
}
