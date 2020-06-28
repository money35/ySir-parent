package com.money.service.impl;

import com.money.dao.CourseDao;
import com.money.pojo.Course;
import com.money.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findAllCourse() {

        return courseDao.findAllCourse();
    }
}
