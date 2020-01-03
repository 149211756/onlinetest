package com.hbgc.onlinetestdemo.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Score extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String school;//学校
    @Column(length = 50)
    private String snumber;//学号
    @Column(length = 50)
    private String cname;//科目
    @Column(length = 50)
    private String myscorce;//分数



}
