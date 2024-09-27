package com.meli.interview.back.subscription_api.controller;

import com.meli.interview.back.subscription_api.dto.UserDTO;
import com.meli.interview.back.subscription_api.dto.UserUpdateDTO;
import com.meli.interview.back.subscription_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.find(id));
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestParam String name, @RequestParam String lastName) {
        return ResponseEntity.ok(userService.findUsername(username));
    }


    @PutMapping
    @Secured("ADMIN")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        return ResponseEntity.ok(userService.update(userUpdateDTO));
    }

    @DeleteMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/subscribe")
    @Secured("ADMIN")
    public ResponseEntity<UserDTO> addSubscription(@PathVariable UUID id, @RequestParam String partner) {
        return ResponseEntity.ok(userService.addSubscription(partner, id));
    }

}
