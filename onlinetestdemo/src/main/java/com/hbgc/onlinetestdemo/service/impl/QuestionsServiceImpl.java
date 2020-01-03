package com.hbgc.onlinetestdemo.service.impl;

import com.hbgc.onlinetestdemo.domian.Questions;
import com.hbgc.onlinetestdemo.repository.QuestionsRepository;
import com.hbgc.onlinetestdemo.service.QuestionsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionsServiceImpl extends  BaseServiceImpl<Questions,Integer, QuestionsRepository> implements QuestionsService {

    @Override
    public List<Questions> findAllByType(String type) {
        return super.dao.findAllByType(type);
    }

    @Override
    public String QuerryAllAnswers(String answers,String type) {
        List<Questions> allByType = super.dao.findAllByType(type);
        int count=0;//分数
        //正确的答案
        List answer=new ArrayList();
        for (Questions a :allByType){
            answer.add(a.getAnswer());
        }
//        System.out.println(answer);
        String[] myanswer = (String[]) answer.toArray(new String[0]);
        String [] answersArr= answers.split(",");

        for (int i = 0; i < answersArr.length; i++) {
            if(myanswer[i].equals(answersArr[i])){
                count+=4;
            }

        }
        return ""+count;
    }
}
