package org.cwc.userservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cwc.userservice.model.ProductInteractionRequest;
import org.cwc.userservice.model.User;
import org.cwc.userservice.payload.UserRequest;
import org.cwc.userservice.payload.UserResponse;
import org.cwc.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User userResponse = userService.createUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest, @PathVariable("userId") int userId) {
        User updatedUser = userService.updateUser(userRequest,userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") int userId) {
        UserResponse user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/userList")
    public ResponseEntity<List<UserResponse>> getUserList() {
        List<UserResponse> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{userId}/product-interaction")
    public void sendProductInteractionMessage(@PathVariable Long userId, @RequestBody ProductInteractionRequest request) {
        userService.sendProductInteractionMessage(userId.toString(), request.getProductId(), request.getAction());
    }

}
