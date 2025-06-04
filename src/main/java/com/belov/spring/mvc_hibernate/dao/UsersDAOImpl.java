package com.belov.spring.mvc_hibernate.dao;

import com.belov.spring.mvc_hibernate.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UsersDAOImpl implements UsersDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> list = entityManager.createQuery("FROM User", User.class).getResultList();
        return list;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void removeUser(User user) {
        entityManager.remove(entityManager.merge(user));
    }
}
