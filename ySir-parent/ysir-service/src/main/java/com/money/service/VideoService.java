package com.money.service;

import com.github.pagehelper.PageInfo;
import com.money.pojo.Condition;
import com.money.pojo.Video;

import java.util.List;

public interface VideoService {
    //分页
    PageInfo findAllVideoByPage(Integer pageNum, Integer pageSize);

    //根据id获取相应的video的信息
    Video findVideoByid(Integer id);

    //根据id修改相应的video信息
    Integer updateVideo(Video video);

    //添加video
    Integer addVideo(Video video);

    //根据id删除相应的video信息
    Integer deleteVideo(Integer id);

    //根据条件进行查询
   PageInfo findVideoByCondition(Integer pageNum, Integer pageSize,Condition condition);

}
