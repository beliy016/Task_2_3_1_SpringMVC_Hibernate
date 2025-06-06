package com.belov.spring.mvc_hibernate.dao;

import com.belov.spring.mvc_hibernate.entity.User;
import java.util.List;

public interface UsersDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void updateUser(User user);

    public User getUser(int id);

    public void removeUser(User user);
}
