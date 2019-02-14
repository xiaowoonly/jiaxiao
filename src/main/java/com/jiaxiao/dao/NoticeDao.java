package com.jiaxiao.dao;

import com.jiaxiao.entity.Notice;
import com.jiaxiao.entity.User;

import java.util.List;

public interface NoticeDao {

    List<Notice> findAllNotice();

    List<Notice> getNoticeByName(Notice notice);

    String getNoticeById(Notice notice);

    void updateNotice(Notice notice);

    void addNotice(Notice notice);

    void deleteNotice(Notice notice);
}
