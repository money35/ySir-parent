package com.money.pojo;

import lombok.Data;

@Data
public class Video {
    private Integer id;
    private String title;
    private String detail;
    private Integer time;
    private Integer speakerId;
    private String courseId;
    private String videoUrl;
    private String imageUrl;
    private Integer playNum;
    private Speaker speaker;
    private Course course;

}
