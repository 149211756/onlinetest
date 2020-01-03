package com.hbgc.onlinetestdemo.service;

import com.hbgc.onlinetestdemo.domian.Questions;
import com.hbgc.onlinetestdemo.repository.QuestionsRepository;

import java.util.List;

public interface QuestionsService  extends BaseService<Questions,Integer, QuestionsRepository> {

    public List<Questions> findAllByType(String type);

    //判断考试答案是否正确
    public String QuerryAllAnswers(String answers ,String type);
}
