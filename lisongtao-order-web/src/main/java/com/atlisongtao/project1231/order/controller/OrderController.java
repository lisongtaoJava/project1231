package com.atlisongtao.project1231.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atlisongtao.project1231.bean.UserAddress;
import com.atlisongtao.project1231.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController  {
    //调用方法
    //@Autowired  。

    /*
    @Reference和@Autowired区别：
    之前通常用@Autowired，大致就是从本地spring容器引入对象。
    只不过@Autowired是通过byType自动注入，而@Reference默认按照byName自动注入。
    @Reference是dubbo的注解，@Resource是spring的注解
    @Reference也是注入的一种，@Reference一般注入是分布式的远程服务对象，需要配置dubbo使用。

    总体来说：@Reference注入是分布式中的远程服务对象，
    @Resource和@Autowired注入的是本地spring容器中的对象。
     */
    @Reference
    private UserInfoService userInfoService;

    @RequestMapping("trade")
    @ResponseBody
    public List<UserAddress> trade(String userId){
      return userInfoService.findUserAddressByUserId(userId);
  }

}
