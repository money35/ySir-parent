package com.money.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.money.dao.SpeakerDao;
import com.money.pojo.Speaker;
import com.money.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerDao speakerDao;
    @Override
  public PageInfo findAllSpeakerByPage(Integer pageNum,Integer pageSize) {
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Speaker> allSpeaker = speakerDao.findAllSpeaker();
        PageInfo pageInfo = new PageInfo(allSpeaker);
        return pageInfo ;
    }

    @Override
    public List<Speaker> findAllSpeaker() {
        return speakerDao.findAllSpeaker();
    }

    @Override
    public Integer addSpeaker(Speaker speaker) {

        return speakerDao.addSpeaker(speaker);
    }

    @Override
    public Integer updateSpeaker(Speaker speaker) {
        Integer row = speakerDao.updateSpeaker(speaker);
        return row;
    }

    @Override
    public Speaker findSpeakerById(Integer id) {
        Speaker speaker = speakerDao.findSpeakerById(id);
        return speaker;
    }

    @Override
    public Integer delSpeakerById(Integer id) {
        Integer row = speakerDao.delSpeakerById(id);
        return row;
    }
}
