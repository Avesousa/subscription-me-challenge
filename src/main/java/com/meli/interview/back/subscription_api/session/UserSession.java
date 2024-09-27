package com.meli.interview.back.subscription_api.session;

import com.meli.interview.back.subscription_api.dto.UserDTO;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@Scope(value= "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {
    private UserDTO loggedUser;
}
