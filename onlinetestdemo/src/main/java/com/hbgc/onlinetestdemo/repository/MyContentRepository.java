package com.hbgc.onlinetestdemo.repository;

import com.hbgc.onlinetestdemo.domian.Content;

import java.util.List;



public interface MyContentRepository extends BaseRepository <Content,Integer>   {

    List<Content> findAllByPid(String pid);

    Content findByCname(String cname);





}
