package com.jiaxiao.service;

import com.github.pagehelper.PageInfo;
import com.jiaxiao.entity.Notice;
import com.jiaxiao.entity.User;

import java.util.List;

public interface NoticeService {

    List<Notice> findAllNotice();
}
