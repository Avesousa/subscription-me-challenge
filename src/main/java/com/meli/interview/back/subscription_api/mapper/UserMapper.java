package com.meli.interview.back.subscription_api.mapper;

import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.dto.UserUpdateDTO;
import com.meli.interview.back.subscription_api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {SubscriptionMapper.class, RoleMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User> {


//    @Mapping(target = "subscriptionsId", source = "subscriptions.id")
//    @Mapping(target = "rolesId", source = "roles.id")
//    UserDTO toDTO(User user);
//
//    @Mapping(source = "subscriptionsId", target = "subscriptions.id")
//    @Mapping(source = "rolesId", target = "roles.id")
//    User toEntity(UserDTO dto);

    void entityFromDTO(UserUpdateDTO dto, @MappingTarget User entity);

    default User fromId(UUID id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}

