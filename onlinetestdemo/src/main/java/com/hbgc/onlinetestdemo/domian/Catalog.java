package com.hbgc.onlinetestdemo.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//题库目录
public class Catalog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @Column(length = 50)
    private String id;//目录内容对应的id
    @Column(length = 50)
    private String cname;//目录名称
    @Column(length = 50)
    private String pid;//父类编号


}
