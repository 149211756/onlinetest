package com.hbgc.onlinetestdemo.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//目录对应的题库内容
public class Content extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    private String type;//题型
    @Column(length = 50)
    private String cname;//内容的名字
    @Column(length = 50)
    private String pid;//父类继承的id

}
