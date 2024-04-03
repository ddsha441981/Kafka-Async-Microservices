package org.cwc.userservice.service;

import org.cwc.userservice.model.User;
import org.cwc.userservice.payload.UserRequest;
import org.cwc.userservice.payload.UserResponse;

import java.util.List;

public interface UserService {

    public User createUser(UserRequest userRequest);
    public UserResponse getUser(int userId);
    public User updateUser(UserRequest userRequest,int userId);
    public void deleteUser(int userId);
    public List<UserResponse> getAllUsers();

    //sendProductInteractionMessage
    public void sendProductInteractionMessage(String userId, String productId, String action);


}
