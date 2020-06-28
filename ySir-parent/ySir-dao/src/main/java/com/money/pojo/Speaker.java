package com.money.pojo;

import lombok.Data;

@Data
public class Speaker {
    private Integer id;
    private String speakerName;//主讲人姓名
    private String speakerDesc;//主讲人简介
    private String speakerJob;//职位
    private String headImgUrl;
}
