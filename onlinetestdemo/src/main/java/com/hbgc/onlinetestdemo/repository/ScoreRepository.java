package com.hbgc.onlinetestdemo.repository;

import com.hbgc.onlinetestdemo.domian.Score;

import java.util.List;

public interface ScoreRepository extends BaseRepository <Score,Integer> {


    List<Score> findAllBySchoolAndSnumber(String school,String snumber );

}
