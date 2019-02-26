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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public Object LoginCheck(@RequestBody User user){

        int status=0;

        String userName =user.getUsername();
        String password =user.getPassword();

        int count = userService.checkUser(user);

        if(count!=0){
            status=userService.checkUser(user);
        }

        if(status==1 || status==2){
            return status;
        }
        return "0";
    }



}
