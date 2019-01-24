package com.jiaxiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiaxiao.entity.Notice;
import com.jiaxiao.entity.User;
import com.jiaxiao.service.NoticeService;
import com.jiaxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/list",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public String findNotice(){
        List<Notice> list = noticeService.findAllNotice();
      /*  Object obj = new Object();
        String objJson = JSONObject.toJSONString(obj);*/
        String listJson = JSONObject.toJSONString(list);
        return listJson;
    }



}
