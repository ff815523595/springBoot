package com.myboot.service;

import com.myboot.bean.User;

/**
 * Created by a on 2017/11/24.
 */
public interface IUserService {

    User findUserByName(String name);
}
