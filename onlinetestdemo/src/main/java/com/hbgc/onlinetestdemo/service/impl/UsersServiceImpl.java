package com.hbgc.onlinetestdemo.service.impl;

import com.hbgc.onlinetestdemo.domian.Users;
import com.hbgc.onlinetestdemo.repository.UsersRepositroy;
import com.hbgc.onlinetestdemo.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends  BaseServiceImpl<Users,Integer, UsersRepositroy> implements UsersService {


    @Override
    public Users login(String snmuber, String password,String school) {
        return super.dao.findBySnumberAndPasswordAndSchool(snmuber,password,school);
    }

    @Override
    public Users registre(Users user) {
        super.save(user);
        return login(user.getSnumber(),user.getPassword(),user.getSchool());
    }


}
