package com.money.dao;

import com.money.pojo.Condition;
import com.money.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoDao {
    //获取所有的video数据
    List<Video> findAllVideo();

    //添加数据video数据
//    Integer addVideo(Video video);

    //根据id获取相应的video的信息
    Video findVideoByid(Integer id);

    //根据id修改相应的video信息
    Integer updateVideo(Video video);

    //添加video
    Integer addVideo(Video video);

    //根据id删除相应的video信息
    Integer deleteVideo(Integer id);

    //根据条件进行查询
    List<Video> findVideoByCondition(Condition condition);
}
