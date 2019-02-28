package com.jiaxiao.entity;

import java.util.Date;

public class Notice {

    private String id;
    private String title;
    private Date created;
    private String publish_name;
    private String realname;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public Date getCreated () {
        return created;
    }

    public void setCreated (Date created) {
        this.created = created;
    }

    public String getPublish_name () {
        return publish_name;
    }

    public void setPublish_name (String publish_name) {
        this.publish_name = publish_name;
    }

    public String getRealname () {
        return realname;
    }

    public void setRealname (String realname) {
        this.realname = realname;
    }
}
