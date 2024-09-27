package com.meli.interview.back.subscription_api.controller;

import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.dto.UserUpdateDTO;
import com.meli.interview.back.subscription_api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserDTO userDTO;
    private UUID userId;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userId = UUID.randomUUID();
        userDTO = new UserDTO();
        userDTO.setId(userId);
        userDTO.setUsername("testUser");
    }

    @Test
    public void testCreateUser() {
        when(userService.create(any(UserDTO.class))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.createUser(userDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userDTO, response.getBody());
    }

    @Test
    public void testGetUserById() {
        when(userService.find(userId)).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.getUser(userId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userDTO, response.getBody());
    }

    @Test
    public void testUpdateUser() {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        when(userService.update(any(UserUpdateDTO.class))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.updateUser(userUpdateDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userDTO, response.getBody());
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userService).delete(userId);

        ResponseEntity<Void> response = userController.deleteUser(userId);

        assertEquals(204, response.getStatusCodeValue());
        Mockito.verify(userService, times(1)).delete(userId);
    }

    @Test
    public void testAddSubscription() {
        when(userService.addSubscription(anyString(), any(UUID.class))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.addSubscription(userId, "testPartner");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userDTO, response.getBody());
    }
}
