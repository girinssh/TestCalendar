package com.example.testcalander;

import java.util.Calendar;
import java.time.*;

abstract class Schedule {
    static Calendar calendar;

    protected String title;
    protected String explain;

    protected String timeZone;
    protected ZonedDateTime startTime;
    protected ZonedDateTime endTime;

    Schedule(){}
    Schedule(String title, String explain, String timeZone, ZonedDateTime startTime, ZonedDateTime endTime ){
        this.calendar = Calendar.getInstance();
        this.title = title;
        this.explain = explain;
        this.timeZone = timeZone;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle(){return this.title;}
    public String getExplain(){return this.explain;}

    public String getTimeZone(){return this.timeZone;}
    public ZonedDateTime getStartTime(){return this.startTime;}
    public ZonedDateTime getEndTime(){return this.endTime;}

    public void setTitle(String title){ this.title = title;}
    public void setExplain(String explain){this.explain = explain;}

    public void setTimeZone(String timeZone){this.timeZone = timeZone;}
    public void setStartTime(ZonedDateTime startTime){this.startTime = startTime;}
    public void setEndTime(ZonedDateTime endTime){this.endTime = endTime;}
}

class Plan extends Schedule{
    public boolean isSetStartAlarm;
    public boolean isSetEndAlarm;

    private ZonedDateTime startAlarm;
    private ZonedDateTime endAlarm;

    public boolean isSetDDay;

    public ZonedDateTime getStartAlarm(){ return startAlarm; }
    public ZonedDateTime getEndAlarm(){ return endAlarm; }

}

class Todo extends Schedule{
    private boolean isSetStartAlarm;
    private boolean isSetEndAlarm;

    public boolean isSetDDay;

    private boolean isChecked;

    public void toggleCheckBox(){
        if(this.isChecked)
            this.isChecked = false;
        else
            this.isChecked = true;
    }
}

class Project extends Schedule{

}