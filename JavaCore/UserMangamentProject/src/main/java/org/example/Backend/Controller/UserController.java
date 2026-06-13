package org.example.Backend.Controller;

import org.example.Backend.Repository.IUserRepository;
import org.example.Backend.Repository.Impl.UserRepositoryImpl;
import org.example.Backend.Service.IUserService;
import org.example.Backend.Service.UserServiceImpl.UserServiceImpl;
import org.example.Entity.User;

import java.util.List;

public class UserController {
    private IUserService userService = new UserServiceImpl();

    public List<User> getUser() {
        return userService.getUser();
    }

    public User findUserByID(int ID) {
        return userService.findUserByID(ID);
    }

    public boolean deleteUserByID(int ID) {
        return userService.deleteUserByID(ID);
    }

    public User loginUser(String email, String password) {
        return userService.loginUser(email, password);
    }

    public boolean createEmployee(String fullName, String email) {
        return userService.createEmployee(fullName, email);
    }
}