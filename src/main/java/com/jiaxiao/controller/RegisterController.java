package com.jiaxiao.controller;


import com.jiaxiao.entity.User;
import com.jiaxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        int status = userService.checkUser(user);
        if(0 != status){
            return 0;  //返回0表示用户不存在
        }
        userService.registerUser(user);
        return 1;
    }
}
