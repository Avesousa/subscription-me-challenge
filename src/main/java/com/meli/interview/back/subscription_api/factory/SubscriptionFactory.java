package com.meli.interview.back.subscription_api.factory;

import com.meli.interview.back.subscription_api.strategy.*;

public class SubscriptionFactory {

    //    private static final Map<String, Float> PARTNER_PRICE;
    //    static {
    //        PARTNER_PRICE = new HashMap<>();
    //        PARTNER_PRICE.put("disney", 100f);
    //    }
    //
    //    public static float getPrice(String partner){
    //        return PARTNER_PRICE.getOrDefault(partner, 0f);
    //    }

    public static PriceStrategy getStrategy(String partner) {
        return switch (partner.toLowerCase()) {
            case "disney" -> new DisneyPriceStrategy();
            case "netflix" -> new NetflixPriceStrategy();
            case "spotify" -> new SpotifyPriceStrategy();
            default -> new DefaultPriceStrategy();
        };
    }

}
