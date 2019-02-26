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



    /**
     * 更新密码
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST )
    public int checkPwd(@RequestBody User user){

         userService.updatePwd(user);
         return 0;
    }


    /**
     * 查询个人信息和学生信息
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/studentInfo",method = RequestMethod.POST )
    public List<Student> getStudentInfo(@RequestBody User user){

        int type =user.getType();

        List<Student>list =null;

        List<User> li = userService.getPersonInfo(user);   //获取个人信息

        if (type==2){
            list= userService.getStudentInfo(li.get(0).getStuno());  //获取学生信息
        }

        list.get(0).setParentName(li.get(0).getRealname());
        list.get(0).setParentPhone(li.get(0).getUsername());
       return list;
    }

    @ResponseBody
    @RequestMapping(value = "/updateinfo",method = RequestMethod.POST )
    public int updateinfo(@RequestBody Student student){
        //更新个人信息
        User user = new User();
        user.setRealname(student.getParentName());
        user.setUsername(student.getParentPhone());
        userService.updatePersonInfo(user);
        return 1;
    }
}
