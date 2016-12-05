package com.yet.spring.core.beans;

import  java.util.Date;
import  java.text.DateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    int id ;
    String msg;
    Date date;
    DateFormat df;
    EventType eventType;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
        id = AUTO_ID.getAndIncrement();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Event{" +
                "id=" + id +
                ", msg=" + msg +
                ", df=" + df .format(date)+
                '}';
    }

    public java.lang.String getMsg() {
        return msg;
    }

    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }


}
