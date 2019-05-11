package com.atlisongtao.project1231.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserAddress implements Serializable {
    //模块用来查询地区

    @Id
    //所在城市id
    @Column
    private String id;
    @Column
    private String userAddress;
    //收件人id编号
    @Column
    private String userId;
    //收货人
    @Column
    private String consignee;
    //收获人电话号码
    @Column
    private String phoneNum;
    //是默认的
    @Column
    private String isDefault;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
