package com.jiaxiao.dao;

import com.jiaxiao.entity.Student;
import com.jiaxiao.entity.User;

import java.util.List;

public interface UserDao {

    List<User> selectUsers();

    int checkUser(User user);
    int registerUser(User user);
    int updatePwd(User user);

    int getUserType(User user);
    List<User> getPersonInfo(User user);
    List<Student>getStudentInfo(String stuNo);

    int updatePersonInfo(User user);
}
