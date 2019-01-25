package com.jiaxiao.service.impl;

import com.jiaxiao.dao.TimeTablesDao;
import com.jiaxiao.entity.TimeTables;
import com.jiaxiao.service.TimeTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "timetablesservice")
public class TimeTablesServiceImpl implements TimeTablesService {

    @Autowired
    TimeTablesDao timeTablesDao;

    @Override
    public  String  getCourse(TimeTables timeTables){
        return timeTablesDao.getCourse(timeTables);
    }
}
