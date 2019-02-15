package com.jiaxiao.controller;


import com.jiaxiao.entity.Student;
import com.jiaxiao.entity.User;
import com.jiaxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;


    /**
     * 登陆验证
     * @return
     */

    @RequestMapping(value = "/register",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public int register(@RequestBody User user){

        int type =user.getType();
        if(type==2){
            List<Student> list;
            list = userService.getStudentInfo(user.getStuno());

            if (null == list || list.size() ==0  ){
                return 2;  //不存在该学生
            }
        }else{
            user.setStuno("0");
        }

        List<User> li;

        li = userService.getPersonInfo(user);
        if (null == li || li.size() ==0  ){
            userService.registerUser(user);
            return 0;  //不存在该用户，可以注册
        }
        return 1;
    }
}
