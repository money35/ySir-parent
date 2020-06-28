package com.money.service;

import com.money.pojo.Course;

import java.util.List;

public interface CourseService {
    //获取所有的课程信息
    List<Course> findAllCourse();
}
