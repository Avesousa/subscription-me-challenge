package com.meli.interview.back.subscription_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Subscription> subscriptions = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_friend",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<User> friends = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void setFriends(Set<User> users) {
        users.forEach(this::addFriend);
    }

    public void addFriend(User user) {
        if(Objects.isNull(this.friends)) this.friends = new HashSet<>();
        if(!this.friends.contains(user)) {
            this.friends.add(user);
            user.addFriend(this);
        }
    }

    public void addSubscription(Subscription trip) {
        subscriptions.add(trip);
    }

    @Override
    public boolean equals(Object otherUser) {
        if (this == otherUser) return true;
        if (otherUser == null || getClass() != otherUser.getClass()) return false;
        User user = (User) otherUser;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
