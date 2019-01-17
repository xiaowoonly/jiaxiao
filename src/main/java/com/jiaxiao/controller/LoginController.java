package com.jiaxiao.controller;

import com.jiaxiao.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/check",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    public int LoginCheck(@RequestBody User user){
        System.out.println("121212121212"+user.getUsername());
        String userName =user.getUsername();
        String password =user.getPassword();
        if(userName.equals("123456")&&password.equals("123456")){
            System.out.println("登录成功");
            return 0;
        }
        System.out.println("登录失败");
        return 1;
    }

}
