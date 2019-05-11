package com.atlisongtao.project1231.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
//为什么要加序列化接口？ 
/*
因为dubbo的注册中心linux下的zookeeper，
 我们要把服务放到注册中心上，所谓的服务就是数据，
数据来源于数据库，数据库的数据封装到对象上，
 我们应该将对象的数据发布到注册中心上，
这个时候必然会有网络传输，必然实现序列化， 
如果使用用dubbo的注册中心zookeeper却不进行序列化，程序执行一定会失败。 
这就是为什么要使用Serializable的原因。 
 */
public class UserInfo implements Serializable{
    //实体类的属性名应该与数据库的字段名保持一致 @Id ，因为需要引用通用mapper的依赖。
    //@Id注解能够跟数据库的字段对应，并且能够自动封装
    @Id
    //用来标识实体类中属性与数据表中字段的对应关系
    @Column
    /*
    通过annotation来映射hibernate实体的,基于annotation的hibernate主键标识为@Id,
    其生成规则由@GeneratedValue设定的.这里的@id和@GeneratedValue都是JPA的标准用法,
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String loginName;
    @Column
    private String nickName;
    @Column
    private String passwd;
    @Column
    private String name;
    @Column
    private String phoneNum;
    @Column
    private String email;
    @Column
    private String headImg;
    @Column
    private String userLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
}
