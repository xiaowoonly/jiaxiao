package com.jiaxiao.controller;

import com.jiaxiao.entity.Student;
import com.jiaxiao.entity.User;
import com.jiaxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST )
    public int checkPwd(@RequestBody User user){

         userService.updatePwd(user);
         return 0;
    }

    @ResponseBody
    @RequestMapping(value = "/studentInfo",method = RequestMethod.POST )
    public List<Student> getStudentInfo(@RequestBody User user){

       List<User> li = userService.getStuNo(user);
       List<Student>list = userService.getStudentInfo(li.get(0).getStuno());
       list.get(0).setParentName(li.get(0).getName());
       list.get(0).setParentGender(li.get(0).getGender());
       list.get(0).setParentPhone(li.get(0).getUsername());
       return list;
    }

}
