package com.atlisongtao.project1231.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atlisongtao.project1231.bean.UserAddress;
import com.atlisongtao.project1231.bean.UserInfo;
import com.atlisongtao.project1231.service.UserInfoService;
import com.atlisongtao.project1231.usermanage.mapper.UserAddressMapper;
import com.atlisongtao.project1231.usermanage.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserInfoService {
    //调用mapper层
    @Autowired
    private UserInfoMapper userInfoMapper;
    //引用mapper
    @Autowired
    private UserAddressMapper userAddressMapper;



    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> findUserAddressByUserId(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return userAddressMapper.select(userAddress);
    }
}
