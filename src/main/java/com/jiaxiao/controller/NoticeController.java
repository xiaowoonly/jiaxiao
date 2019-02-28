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

/**
 * 公告
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询所有公告
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public String findNotice(){
        List<Notice> list = noticeService.findAllNotice();
      /*  Object obj = new Object();
        String objJson = JSONObject.toJSONString(obj);*/
        String listJson = JSONObject.toJSONString(list);
        return listJson;
    }

    /**
     * 根据单个id查所发公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/getNotice",method = RequestMethod.POST )
    @ResponseBody
    public String getNoticeByName(@RequestBody Notice notice){
        List<Notice> str = noticeService.getNoticeByName(notice);
        String listJson = JSONObject.toJSONString(str);

        return listJson;
    }

    /**
     * 修改页面
     * @param notice
     * @return
     */
    @RequestMapping(value = "/goUpdateNoticePage",method = RequestMethod.POST )
    @ResponseBody
    public String goNoticePage(@RequestBody Notice notice){
        String str = noticeService.getNoticeById(notice);
        String json = JSONObject.toJSONString(str);

        return json;
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/updateNotice",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public Object updateNotice(@RequestBody Notice notice){
        noticeService.updateNotice(notice);
        return "1";
    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public Object addNotice(@RequestBody Notice notice){
        noticeService.addNotice(notice);
        return "1";
    }

    /**
     * 删除公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/deleteNotice",method = RequestMethod.POST,consumes="application/json;charset=UTF-8" )
    @ResponseBody
    public Object deleteNotice(@RequestBody Notice notice){
        noticeService.deleteNotice(notice);
        return "1";
    }


}
