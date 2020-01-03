package com.hbgc.onlinetestdemo.controller;

import com.hbgc.onlinetestdemo.domian.Score;
import com.hbgc.onlinetestdemo.json.Json;
import com.hbgc.onlinetestdemo.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    @PostMapping("save")
    public Map<String, Object> registerUser(@RequestBody Score score) {

        System.out.println(score.getMyscorce());


        try {
            scoreService.saveScore(score);
            return Json.success( "savescoreSuccess");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("savescoreFailure");
        }
    }

    @GetMapping("queryscore")
    public Map<String, Object> queryScore(String school,String snumber) {
        List<Score> scores = scoreService.querryScore(school, snumber);
        try {
            return Json.success( scores,"querySuccess");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("queryFailure");
        }
    }

}
