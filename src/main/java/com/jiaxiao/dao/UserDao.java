package com.jiaxiao.dao;

import com.jiaxiao.entity.User;

import java.util.List;

public interface UserDao {

    List<User> selectUsers();
}
