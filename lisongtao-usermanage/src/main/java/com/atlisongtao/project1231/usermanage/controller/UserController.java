package com.atlisongtao.project1231.usermanage.controller;

import com.atlisongtao.project1231.bean.UserInfo;
import com.atlisongtao.project1231.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    //此代码块用于查询数据库user_infor的所有数据
    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }
}
