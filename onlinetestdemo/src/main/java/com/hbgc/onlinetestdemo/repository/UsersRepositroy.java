package com.hbgc.onlinetestdemo.repository;

import com.hbgc.onlinetestdemo.domian.Users;

public interface UsersRepositroy extends BaseRepository <Users,Integer> {

    Users findBySnumberAndPasswordAndSchool(String snumber,String password,String school);

}
