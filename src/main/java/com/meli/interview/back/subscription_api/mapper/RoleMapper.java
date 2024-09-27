package com.meli.interview.back.subscription_api.mapper;

import com.meli.interview.back.subscription_api.dto.RoleDTO;
import com.meli.interview.back.subscription_api.dto.SubscriptionDTO;
import com.meli.interview.back.subscription_api.entity.Role;
import com.meli.interview.back.subscription_api.entity.Subscription;
import com.meli.interview.back.subscription_api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {SubscriptionMapper.class, UserMapper.class})
public interface RoleMapper extends EntityMapper<RoleDTO, Role>{
    default Role fromId(Long id) {
        if (id == null) {
            return null;
        }
        Role role = new Role();
        role.setId(id);
        return role;
    }
}
