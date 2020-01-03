package com.hbgc.onlinetestdemo.service.impl;

import com.hbgc.onlinetestdemo.domian.Score;
import com.hbgc.onlinetestdemo.repository.ScoreRepository;
import com.hbgc.onlinetestdemo.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl extends  BaseServiceImpl<Score,Integer, ScoreRepository> implements ScoreService {



    @Override
    public void saveScore(Score score) {
       super.save(score);
    }

    @Override
    public List<Score> querryScore(String school, String snmuber) {
        return super.dao.findAllBySchoolAndSnumber(school,snmuber);
    }

}
