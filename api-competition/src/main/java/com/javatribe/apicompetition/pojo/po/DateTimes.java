package com.javatribe.apicompetition.pojo.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DateTimes {

    private String name;

    @JSONField(format = "yyyy.MM.dd")
    private Date startTime;

    @JSONField(format = "yyyy.MM.dd")
    private Date endTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13*hashno+(name==null?0:name.hashCode());
        return hashno;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        final DateTimes temp = (DateTimes)obj;
        if(temp==this){
            return true;
        }else{
            return (this.name.equals(temp.name));
        }
    }
}
