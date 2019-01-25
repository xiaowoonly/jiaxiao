package com.jiaxiao.service;

import com.github.pagehelper.PageInfo;
import com.jiaxiao.entity.User;

public interface UserService {

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    int checkUser (User user);
    int registerUser (User user);
}
