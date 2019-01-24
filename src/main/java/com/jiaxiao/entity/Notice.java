package com.jiaxiao.entity;

import java.util.Date;

public class Notice {

    private String noticeid;
    private String name;
    private Date created;
    private int type;

    public String getNoticeid () {
        return noticeid;
    }

    public void setNoticeid (String noticeid) {
        this.noticeid = noticeid;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Date getCreated () {
        return created;
    }

    public void setCreated (Date created) {
        this.created = created;
    }

    public int getType () {
        return type;
    }

    public void setType (int type) {
        this.type = type;
    }
}
