package com.belov.spring.mvc_hibernate.service;

import com.belov.spring.mvc_hibernate.entity.User;
import java.util.List;

public interface UsersService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void removeUser(User user);

}
