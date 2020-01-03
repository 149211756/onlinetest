package com.hbgc.onlinetestdemo.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//总题库
public class Questions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;//题型（用于页面跳转）
    private String headline;//问题类型（汉字）

    private int number;//问题序号

    private String title;//问题描述

    private String contentA;//A~F选项
    private String contentB;//A~F选项
    private String contentC;//A~F选项
    private String contentD;//A~F选项
    private String contentE;//A~F选项
    private String contentF;//A~F选项


    private String answer;//问题的答案


}
