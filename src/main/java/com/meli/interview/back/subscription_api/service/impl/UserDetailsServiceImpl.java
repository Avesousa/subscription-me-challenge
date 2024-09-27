package com.meli.interview.back.subscription_api.service.impl;

import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.service.UserService;
import com.meli.interview.back.subscription_api.session.UserSession;
import org.springframework.security.core.userdetails.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final UserSession userSession;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDTO user = userService.findUsername(username);
        List<SimpleGrantedAuthority> roles = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name()))).toList();
        userSession.setLoggedUser(user);
        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
