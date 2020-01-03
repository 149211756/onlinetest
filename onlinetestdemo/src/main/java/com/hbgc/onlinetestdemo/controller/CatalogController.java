package com.hbgc.onlinetestdemo.controller;

import com.hbgc.onlinetestdemo.domian.Catalog;
import com.hbgc.onlinetestdemo.json.Json;
import com.hbgc.onlinetestdemo.service.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("catalog")



public class CatalogController extends BaseController {
    @Resource
    private CatalogService catalogService;


    @GetMapping("/")
    public Map<String,Object> queryAllCatalog(){
        List<Catalog> catalogList;

        try {
            catalogList=catalogService.findAll();
            return Json.success(catalogList,"查询板块资料成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("查询版块资料失败");
        }
    }







}
