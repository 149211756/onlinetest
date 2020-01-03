package com.hbgc.onlinetestdemo.controller;

import com.hbgc.onlinetestdemo.domian.Content;
import com.hbgc.onlinetestdemo.json.Json;
import com.hbgc.onlinetestdemo.service.MyContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("content")
public class MyContentController {

    @Resource
    private MyContentService myContentService;

    @GetMapping("/")
    public Map<String,Object> queryAllCatalog(String pid){
        List<Content> contentList;
//        System.out.println(pid);

        try {
            contentList=myContentService.findAllByPid(pid);
//            for (Content i:contentList){
////                System.out.println(i.getCname());
////            }
            return Json.success(contentList,"查询板块资料成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("查询版块资料失败");
        }
    }





}
