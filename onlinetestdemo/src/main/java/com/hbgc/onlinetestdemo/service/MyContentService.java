package com.hbgc.onlinetestdemo.service;

import com.hbgc.onlinetestdemo.domian.Content;
import com.hbgc.onlinetestdemo.repository.MyContentRepository;

import java.util.List;

public interface MyContentService extends BaseService<Content,Integer, MyContentRepository> {


    List<Content> findAllByPid(String pid);

    Content findByCname(String cname);

}
