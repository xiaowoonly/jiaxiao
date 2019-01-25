package com.jiaxiao.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiaxiao.entity.TimeTables;
import com.jiaxiao.service.TimeTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/TimeTables")
public class TimeTablesController {

    @Autowired
    private TimeTablesService timeTablesService;

    @RequestMapping(value = "/get",method = RequestMethod.POST )
    @ResponseBody
    public String getTimeTables(@RequestBody TimeTables timeTables){
        String str = timeTablesService.getCourse(timeTables);
        String listJson = JSONObject.toJSONString(str);

        return listJson;
    }


}
