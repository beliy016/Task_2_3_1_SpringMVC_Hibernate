package com.belov.spring.mvc_hibernate.service;

import com.belov.spring.mvc_hibernate.dao.UsersDAO;
import com.belov.spring.mvc_hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        usersDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        if (getUser(user.getId()) != null) {
            usersDAO.updateUser(user);
        }
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return usersDAO.getUser(id);
    }

    @Override
    public void removeUser(int id) {
        User user = getUser(id);
        if (user != null) {
            usersDAO.removeUser(user);
        }
    }
}
