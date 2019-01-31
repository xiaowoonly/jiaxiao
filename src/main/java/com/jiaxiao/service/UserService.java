package com.jiaxiao.service;

import com.github.pagehelper.PageInfo;
import com.jiaxiao.entity.Student;
import com.jiaxiao.entity.User;

import java.util.List;

public interface UserService {

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    int checkUser (User user);
    int registerUser (User user);
    int updatePwd( User user);
    List<User> getStuNo(User user);
    List<Student> getStudentInfo(String stuNo);
}
