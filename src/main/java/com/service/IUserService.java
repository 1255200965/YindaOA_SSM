package com.service;

/**
 * Created by ma on 2016/10/13.
 */

import java.util.List;

import com.model.User;

public interface IUserService {
    List<User> findAllUser();
}