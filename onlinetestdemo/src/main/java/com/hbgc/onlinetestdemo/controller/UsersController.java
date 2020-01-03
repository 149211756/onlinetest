package com.hbgc.onlinetestdemo.controller;

import com.hbgc.onlinetestdemo.domian.Users;
import com.hbgc.onlinetestdemo.json.Json;
import com.hbgc.onlinetestdemo.service.UsersService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController {

    @Resource
    private UsersService usersService;



    @ApiOperation(value = "用户登录借口",notes = "URL传入用户名和密码执行用户登录")
    @GetMapping("login")
    public Map<String,Object> login(String snmuber, String password,String school){
        Users loginUser=null;

        try {
            loginUser = usersService.login(snmuber, password,school);
            if(loginUser!=null){
                return Json.success(loginUser, "loginSuccess");
            }
            return Json.fail("loginFailure");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("loginFailure");
        }
    }

    @PostMapping("register")
    public Map<String,Object> registerUser(@RequestBody Users user){
        Users registreUser=null;
        try {
            registreUser = usersService.registre(user);
            if(registreUser!=null){
                return Json.success(registreUser,"registreUserSuccess");
            }
            return Json.fail("registreUserFailure");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("registreUserFailure");
        }
    }
}
