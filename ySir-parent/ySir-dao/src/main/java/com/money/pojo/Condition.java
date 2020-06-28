package com.money.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
    private String title;
    private Integer speakerId;
    private Integer courseId;
}
