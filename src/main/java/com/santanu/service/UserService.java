package com.santanu.service;

import com.santanu.Exception.UserException;
import com.santanu.model.User;

import java.util.List;

public interface UserService {
    public User findUserProfileByJwt(String jwt) throws UserException;

    public User findUserByEmail(String email) throws UserException;

    public List<User> findAllUsers();

    public List<User> getPendingRestaurantOwner();

    void updatePassword(User user, String newPassword);

    void sendPasswordResetEmail(User user);
}