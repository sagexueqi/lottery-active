package com.connie7.entity;

import java.util.Date;

public class UserTakeinEntity {
    private Long id;

    private Long userId;

    private String takeinDate;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTakeinDate() {
        return takeinDate;
    }

    public void setTakeinDate(String takeinDate) {
        this.takeinDate = takeinDate == null ? null : takeinDate.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}