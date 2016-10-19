package com.service.impl;

/**
 * Created by ma on 2016/10/13.
 */

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import com.dao.IUserDao;
import com.model.User;
import com.service.IUserService;

import javax.annotation.Resource;


@Transactional
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    public IUserDao userMapper;

    public List<User> findAllUser() {
        // TODO Auto-generated method stub
        List<User> findAllUser = userMapper.findAllUser();
        return findAllUser;
    }

}
