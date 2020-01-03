package com.hbgc.onlinetestdemo.service;

import com.hbgc.onlinetestdemo.domian.Score;
import com.hbgc.onlinetestdemo.repository.ScoreRepository;

import java.util.List;

public interface ScoreService extends BaseService<Score,Integer, ScoreRepository> {
    public void saveScore(Score score);
    public List<Score> querryScore(String school, String snmuber);
}
