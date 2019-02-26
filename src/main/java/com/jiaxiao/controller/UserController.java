package com.jiaxiao.controller;

import com.alibaba.fastjson.JSONObject;
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
        List<User> li = userService.getPersonInfo(user);   //获取个人信息
        List<Student>list  = userService.getStudentInfo(li.get(0).getStuno());  //获取学生信息
        list.get(0).setParentName(li.get(0).getRealname());
        list.get(0).setParentPhone(li.get(0).getUsername());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/teacherInfo",method = RequestMethod.POST )
    public List<User> getTeacherInfo(@RequestBody User user){
        List<User> li = userService.getPersonInfo(user);   //获取个人信息
        return li;
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


    /**
     * 查询所有好友信息
     * @return
     */
    @RequestMapping(value = "/getFriend",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public String getFriend(@RequestBody User user){
        List<User> str = userService.getFriend(user);
        String listJson = JSONObject.toJSONString(str);

        return listJson;
    }


}
