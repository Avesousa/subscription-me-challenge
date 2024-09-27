package com.meli.interview.back.subscription_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;

    private String name;
    private String username;
    @JsonIgnore
    private String password;
    @Builder.Default
    private Set<SubscriptionDTO> subscriptions = new HashSet<>();
    @Builder.Default
    private Set<UserDTO> friends = new HashSet<>();
    @Builder.Default
    private Set<RoleDTO> roles = new HashSet<>();

    public boolean isFriend(UserDTO dto) {
        return this.friends.contains(dto);
    }

    @Override
    public boolean equals(Object otherUser) {
        if (this == otherUser) return true;
        if (otherUser == null || getClass() != otherUser.getClass()) return false;
        UserDTO user = (UserDTO) otherUser;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
