package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    //Get All Users
    public List<User> getAllUsers();

    //Create User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //Get User by Username
    public User getUser(String username);

    //Delete User By Id
    public void deleteUser(Long userId);
}
