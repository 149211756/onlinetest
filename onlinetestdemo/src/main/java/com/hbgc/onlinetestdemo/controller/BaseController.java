package com.hbgc.onlinetestdemo.controller;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class BaseController  {

    @Resource
    protected RedisTemplate redisTemplate;
}
