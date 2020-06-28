package com.money.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.money.dao.VideoDao;
import com.money.pojo.Condition;
import com.money.pojo.Video;
import com.money.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public PageInfo findAllVideoByPage(Integer pageNum, Integer pageSize) {
        //pageHelper分页操作
        PageHelper.startPage(pageNum,pageSize);
        List<Video> allVideo = videoDao.findAllVideo();
        PageInfo pageInfo = new PageInfo(allVideo);
        return pageInfo;
    }

    @Override
    public Video findVideoByid(Integer id) {
        Video video = videoDao.findVideoByid(id);
        return video;
    }

    @Override
    public Integer updateVideo(Video video) {
        return videoDao.updateVideo(video);
    }

    @Override
    public Integer addVideo(Video video) {
        return videoDao.addVideo(video);
    }

    @Override
    public Integer deleteVideo(Integer id) {
        return videoDao.deleteVideo(id);
    }

    @Override
    public PageInfo findVideoByCondition(Integer pageNum, Integer pageSize,Condition condition) {
        //pageHelper分页操作
        PageHelper.startPage(pageNum,pageSize);
        List<Video> videoList = videoDao.findVideoByCondition(condition);
        PageInfo pageInfo = new PageInfo(videoList);
        return pageInfo ;
    }

}
