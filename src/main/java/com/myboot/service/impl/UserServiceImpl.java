package com.myboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.myboot.bean.User;
import com.myboot.mapper.UserMapper;
import com.myboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by a on 2017/11/24.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String name) {
        PageHelper.startPage(1,1);
        return userMapper.findUserByName(name);
    }
}
