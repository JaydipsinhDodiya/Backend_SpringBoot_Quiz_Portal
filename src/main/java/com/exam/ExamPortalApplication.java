package com.exam;

import com.exam.exception.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ExamPortalApplication.class, args);
    }

    //Print Direct Database
    @Override
    public void run(String... args) throws Exception {
        try {

            System.out.println("Starting Code....");

            //create user
            User user = new User();
            user.setFirstname("Jaydip");
            user.setLastname("Dodiya");
            user.setPhone("7096622522");
            user.setUsername("Jd");
            //user.setPassword("ABC");
            user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
            user.setEmail("Jd@gmail.com");
            user.setProfile("default.png");

            //create role
            Role role = new Role();

            role.setRole("Admin");

            //create user_role set
            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setRole(role);
            userRole.setUser(user);

            userRoleSet.add(userRole);

            User user1 = this.userService.createUser(user, userRoleSet);
            System.out.println(user1.getUsername());

        }catch (UserFoundException e){
            e.printStackTrace();
        }
    }
}
