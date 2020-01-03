package com.hbgc.onlinetestdemo.controller;

import cn.hutool.json.JSON;
import com.hbgc.onlinetestdemo.domian.Questions;
import com.hbgc.onlinetestdemo.json.Json;
import com.hbgc.onlinetestdemo.service.QuestionsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Console;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("questions")
public class QuestionsController {

    @Resource
    private QuestionsService questionsService;


    @GetMapping("/")
    public Map<String, Object> queryAllCatalog(String type) {
        List<Questions> questionsList;
//        System.out.println(type);

        try {
            questionsList = questionsService.findAllByType(type);
            return Json.success(questionsList, "查询板块资料成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("查询版块资料失败");
        }
    }


    @GetMapping("/answers")
    public Map<String, Object> queryAllAnswers(String answers, String type) {

       String scorces = questionsService.QuerryAllAnswers(answers, type);
        System.out.println(scorces);


        try {
            return Json.success(scorces,"查询板块资料成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("查询版块资料失败");
        }
    }


}
