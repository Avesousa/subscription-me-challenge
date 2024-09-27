package com.meli.interview.back.subscription_api.mapper;

import com.meli.interview.back.subscription_api.dto.SubscriptionDTO;
import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.dto.UserUpdateDTO;
import com.meli.interview.back.subscription_api.entity.Subscription;
import com.meli.interview.back.subscription_api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class, RoleMapper.class})
public interface SubscriptionMapper extends EntityMapper<SubscriptionDTO, Subscription>{
    default Subscription fromId(Long id) {
        if (id == null) {
            return null;
        }
        Subscription subscription = new Subscription();
        subscription.setId(id);
        return subscription;
    }
}
