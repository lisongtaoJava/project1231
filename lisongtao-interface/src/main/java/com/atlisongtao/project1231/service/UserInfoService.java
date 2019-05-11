package com.atlisongtao.project1231.service;

import com.atlisongtao.project1231.bean.UserAddress;
import com.atlisongtao.project1231.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    //查询用户所有数据
    List<UserInfo> findAll();
    //查询用户Id，查询用户地址
    List<UserAddress> findUserAddressByUserId(String userId);

}
