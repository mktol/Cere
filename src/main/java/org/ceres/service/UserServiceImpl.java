package org.ceres.service;

import org.ceres.entity.User;

/**
 * Created by user on 09.11.2016.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }
}
