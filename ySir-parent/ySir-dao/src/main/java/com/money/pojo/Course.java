package com.money.pojo;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String courseTitle;
    private String courseDesc;
    private Integer subjectId;
}
