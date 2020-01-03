package com.hbgc.onlinetestdemo.service;

import com.hbgc.onlinetestdemo.domian.Users;
import com.hbgc.onlinetestdemo.repository.UsersRepositroy;

public interface UsersService extends BaseService<Users,Integer, UsersRepositroy> {

public Users login(String snumber, String password,String school);

public Users registre(Users user);
}
