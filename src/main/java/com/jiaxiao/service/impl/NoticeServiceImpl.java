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

    /**
     * 根据名字查公告
     * @param notice
     * @return
     */
    @Override
    public List<Notice> getNoticeByName(Notice notice){
        return noticeDao.getNoticeByName (notice);
    }

    /**
     * 根据id查公告
     * @param notice
     * @return
     */
    @Override
    public String getNoticeById(Notice notice){
        return noticeDao.getNoticeById (notice);
    }

    /**
     * 修改公告
     * @param notice
     */
    public void updateNotice (Notice notice){
        noticeDao.updateNotice (notice);
    }

    /**
     * 添加公告
     * @param notice
     */
    public void addNotice (Notice notice){
        noticeDao.addNotice (notice);
    }

    /**
     * 删除公告
     * @param notice
     */
    public void deleteNotice (Notice notice){
        noticeDao.deleteNotice (notice);
    }
}
