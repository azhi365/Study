package com.innstack.lime.shiro.chapter21.dao;

import com.innstack.lime.shiro.chapter21.entity.User;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface UserDao {

    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);

    User findOne(Long userId);

    List<User> findAll();

    User findByUsername(String username);

}
