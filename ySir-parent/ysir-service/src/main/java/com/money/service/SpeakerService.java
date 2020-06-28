package com.money.service;

import com.github.pagehelper.PageInfo;
import com.money.pojo.Speaker;

import java.util.List;

public interface SpeakerService {
    //分页获取所有主讲人的信息
    PageInfo findAllSpeakerByPage(Integer pageNum,Integer pageSize);

    //获取所有主讲人的信息
    List<Speaker> findAllSpeaker();

    //添加主讲人
    Integer addSpeaker(Speaker speaker);

    //修改主讲人的信息
    Integer updateSpeaker(Speaker speaker);

    //根据ID查询对应的主讲人信息
    Speaker findSpeakerById(Integer id);

    //根据id删除相应的主讲人信息
    Integer delSpeakerById(Integer id);
}
