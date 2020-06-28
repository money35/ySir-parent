package com.money.dao;

import com.money.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    //获取所有的课程信息
    List<Course> findAllCourse();
}
