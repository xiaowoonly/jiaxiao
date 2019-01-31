package com.jiaxiao.controller;

import com.jiaxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }


    @ResponseBody
    @GetMapping("/updatePwd")
    public int checkPwd( @RequestParam(name = "oldPwd")
                                 String oldPwd,
                         @RequestParam(name = "newPwd")
                                 String newPwd){
        int status = userService.checkPwd(oldPwd);
        if(status==0) {
            return 0;
        }
        userService.updatePwd(newPwd);
        return 1;
    }

}
