package org.cwc.userservice.service.impl;

import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cwc.userservice.exception.UserNotFoundException;
import org.cwc.userservice.model.User;
import org.cwc.userservice.payload.UserRequest;
import org.cwc.userservice.payload.UserResponse;
import org.cwc.userservice.repository.UserRepository;
import org.cwc.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
    private  static final String TOPIC = "user-product-interactions";

    @Override
    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .build();
        User userSaved = userRepository.save(user);
        return userSaved;
    }

    @Override
    public UserResponse getUser(int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapToUserResponse(user);
    }



    @Override
    public User updateUser(UserRequest userRequest, int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        User userUpdated = this.userRepository.save(user);
        return userUpdated;
    }

    @Override
    public void deleteUser(int userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userList = this.userRepository.findAll();
        return userList.stream().map((user)->mapToUserResponse(user)).collect(Collectors.toList());
    }

    @Override
    public void sendProductInteractionMessage(String userId, String productId, String action) {
        String message = userId + " " + productId + " " + action;
        kafkaTemplate.send(TOPIC, message);
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .userId(String.valueOf(user.getUserId()))
                .build();
    }

}
