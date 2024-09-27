package com.meli.interview.back.subscription_api.strategy;

public class SpotifyPriceStrategy implements PriceStrategy{
    @Override
    public float getPrice() {
        return 50f;
    }
}
