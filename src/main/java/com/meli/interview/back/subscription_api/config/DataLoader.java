package com.meli.interview.back.subscription_api.config;

import com.meli.interview.back.subscription_api.entity.Role;
import com.meli.interview.back.subscription_api.entity.Subscription;
import com.meli.interview.back.subscription_api.entity.User;
import com.meli.interview.back.subscription_api.repository.RoleDAO;
import com.meli.interview.back.subscription_api.repository.SubscriptionDAO;
import com.meli.interview.back.subscription_api.repository.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

import static com.meli.interview.back.subscription_api.enums.Roles.*;

@Configuration
public class DataLoader {

//    @Bean
//    public CommandLineRunner initDatabase(UserDAO userRepository, RoleDAO roleRepository, SubscriptionDAO subscriptionRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            //Insert roles
//            Role admin = Role.builder().name(ADMIN).build();
//            Role user = Role.builder().name(USER).build();
//            roleRepository.saveAll(List.of(admin,user));
//
//            // Insert users
//            User user1 = User.create("Avelino Figueira", "avelino.figueira", passwordEncoder.encode("password1"), Set.of(admin, user));
//            User user2 = User.create("Mariana López", "mariana.lopez", passwordEncoder.encode("password2"), Set.of(admin));
//            User user3 = User.create("Carlos Pérez", "carlos.perez", passwordEncoder.encode("password3"), Set.of(user));
//            User user4 = User.create("Luisa Fernández", "luisa.fernandez", passwordEncoder.encode("password4"), Set.of(user));
//            User user5 = User.create("Jorge Martínez", "jorge.martinez", passwordEncoder.encode("password5"), Set.of(user));
//
//            user2.setFriends(Set.of(user1, user3));
//            user3.setFriends(Set.of(user1));
//            userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
//
//
//            // Insert subscriptions
//            subscriptionRepository.saveAll(List.of(
//                    Subscription.build("netflix", user1),
//                    Subscription.build("spotify", user1),
//                    Subscription.build("disney", user2),
//                    Subscription.build("hbo max", user3),
//                    Subscription.build("disney", user4),
//                    Subscription.build("spotify", user5)));
//        };
//    }
}
