package com.hbgc.onlinetestdemo.repository;

import com.hbgc.onlinetestdemo.domian.Questions;

import java.util.List;

public interface QuestionsRepository extends BaseRepository <Questions,Integer>{
    List<Questions> findAllByType(String type);
}
