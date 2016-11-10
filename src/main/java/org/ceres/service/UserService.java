package org.ceres.service;

import org.ceres.entity.User;

/**
 * Created by user on 09.11.2016.
 */
public interface UserService {
    User getUser(String login);
}
