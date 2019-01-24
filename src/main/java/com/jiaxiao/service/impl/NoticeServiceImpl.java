package com.jiaxiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiaxiao.dao.NoticeDao;
import com.jiaxiao.dao.UserDao;
import com.jiaxiao.entity.Notice;
import com.jiaxiao.entity.User;
import com.jiaxiao.service.NoticeService;
import com.jiaxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    /**
     * 查询所有公告
     * @return
     */
    @Override
    public List<Notice> findAllNotice(){
        return noticeDao.findAllNotice();
    }
}
