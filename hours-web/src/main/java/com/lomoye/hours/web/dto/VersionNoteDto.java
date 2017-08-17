package com.lomoye.hours.web.dto;


import java.util.List;

/**
 * Created by lomoye on 2017/8/17.
 * 版本记录dto
 */
public class VersionNoteDto {
    private String day;//上线时间 2011-01-23

    private List<String> contents;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }
}
