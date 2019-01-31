package com.jiaxiao.dao;

import com.jiaxiao.entity.User;

import java.util.List;

public interface UserDao {

    List<User> selectUsers();

    int checkUser(User user);
    int registerUser(User user);
    int checkPwd(String password);
    int updatePwd(String password);
}
