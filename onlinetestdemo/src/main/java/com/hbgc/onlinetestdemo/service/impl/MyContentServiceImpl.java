package com.hbgc.onlinetestdemo.service.impl;

import com.hbgc.onlinetestdemo.domian.Content;
import com.hbgc.onlinetestdemo.repository.MyContentRepository;
import com.hbgc.onlinetestdemo.service.MyContentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyContentServiceImpl extends BaseServiceImpl<Content,Integer, MyContentRepository>implements MyContentService {


    @Override
    public List<Content> findAllByPid(String pid) {
        return super.dao.findAllByPid(pid);
    }

    @Override
    public Content findByCname(String cname) {
        return super.dao.findByCname(cname);
    }
}
