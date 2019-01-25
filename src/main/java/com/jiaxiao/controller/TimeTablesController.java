package com.jiaxiao.controller;


import com.jiaxiao.entity.TimeTables;
import com.jiaxiao.service.TimeTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/TimeTables")
public class TimeTablesController {

    @Autowired
    private TimeTablesService timeTablesService;

    @RequestMapping(value = "/get",method = RequestMethod.POST )
    public String getTimeTables(@RequestBody TimeTables timeTables){
        String course ;
        course=timeTablesService.getCourse(timeTables);
        return course;
    }
}
