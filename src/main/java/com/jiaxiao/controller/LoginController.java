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

    /**
     * 登陆校验
     */
    @RequestMapping(value = "/check",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public Object LoginCheck(@RequestBody User user){

        int status=0;

        String userName =user.getUsername();
        String password =user.getPassword();

        int count = userService.checkUser(user);  //判断账号是否存在 0为不存在

        if(count!=0){
            status=userService.getUserType(user);  //获取账号类型  1老师 2家长
        }

        if(status==1 || status==2){
            return status;
        }
        return "0";
    }



}
