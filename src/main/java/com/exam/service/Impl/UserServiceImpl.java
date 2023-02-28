package com.exam.service.Impl;

import com.exam.exception.UserFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //Getting All Users
    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User user1 = this.userRepository.findByUsername(user.getUsername());
        if (user1 != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException("User is Already Present !!");
        } else {
            //create user
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            user1 = this.userRepository.save(user);

        }
        return user1;
    }

    //Getting User By Username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    //Delete User By Id
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
