package com.jiaxiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiaxiao.dao.UserDao;
import com.jiaxiao.entity.Student;
import com.jiaxiao.entity.User;
import com.jiaxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> user = userDao.selectUsers();
        PageInfo result = new PageInfo(user);
        return result;
    }

    @Override
    public int checkUser(User user){
        return userDao.checkUser(user);
    }

    @Override
    public int registerUser(User user){
        return userDao.registerUser(user);
    }

    @Override
    public int updatePwd( User user){
        return  userDao.updatePwd(user);
    }

    @Override
    public  List<User> getPersonInfo(User user){
        return  userDao.getPersonInfo(user);
    }
    @Override
    public List<Student>getStudentInfo(String stuNo){return userDao.getStudentInfo(stuNo);}
    @Override
    public  int updatePersonInfo(User user){
        return  userDao.updatePersonInfo(user);
        }

     @Override
     public int updateStuInfo(Student student){
        return userDao.updateStuInfo(student);
     }

    /**
     * 查好友
     * @param user
     * @return
     */
    @Override
    public  List<User> getFriend(User user){
        return  userDao.getFriend(user);
    }

}
