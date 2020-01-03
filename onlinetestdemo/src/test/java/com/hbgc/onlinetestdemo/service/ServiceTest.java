package com.hbgc.onlinetestdemo.service;

import com.hbgc.onlinetestdemo.domian.Content;
import com.hbgc.onlinetestdemo.domian.Questions;
import com.hbgc.onlinetestdemo.domian.Score;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Resource
    private MyContentService myContentService;
    @Resource
    private QuestionsService questionsService;

    @Resource
    private ScoreService scoreService;
    @Test
    public void mytest1(){
        List<Content> contentList;
        contentList=myContentService.findAllByPid("动力学基础试题");
        for (Content i:contentList){
            System.out.println(i.getCname());
        }
    }
    @Test
    public void mytest2(){
        Content content;
        content=myContentService.findByCname("CDMA2000基础试题1");
    }
    @Test
    public void mytest3(){
        List<Questions> questions;
        questions=questionsService.findAllByType("computertest1");
        for (Questions i:questions){
            System.out.println(i.getAnswer());
        }
    }

    @Test
    public void mytest4(){
        List<Score> list = scoreService.querryScore("河北工程大学", "160730223");
        System.out.println(list);
    }



}
