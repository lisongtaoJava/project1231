package com.atlisongtao.project1231.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atlisongtao.project1231.bean.BaseAttrInfo;
import com.atlisongtao.project1231.bean.BaseCatalog1;
import com.atlisongtao.project1231.bean.BaseCatalog2;
import com.atlisongtao.project1231.bean.BaseCatalog3;
import com.atlisongtao.project1231.service.ManageService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


//渲染层
/*
如果启动服务并通过浏览器访问，其实是访问不到的，index.html放到templates只是一个模板，
这时就必须经过controller层进行渲染，才可以被访问到。
 */
@Controller
public class ManageController {
    @Reference
    private ManageService manageService;

    @RequestMapping("index")
    public String index() {
        //表示返回的试图名称
        return "index";
    }

    @RequestMapping("attrlistPage")
    public String getAttrlistPage() {
        //spring boot 默认与thymeleaf天然整合
        return "attrlistPage";
    }

    /*
    @RequestParam
    GET和POST请求传的参数会自动转换赋值到@RequestParam 所注解的变量上
    @RequestParam（org.springframework.web.bind.annotation.RequestParam）
    用于将指定的请求参数赋值给方法中的形参。
    */

    /*
    获得一级分类
     */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1() {
        return manageService.getCatalog1();
    }

    /*
    获得二级分类
     */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        return manageService.getCatalog2(catalog1Id);
    }

    /*
    三级分类
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        return manageService.getCatalog3(catalog2Id);
    }

    /*
    获得属性列表
     */
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<BaseAttrInfo> attrInfoList(String catalog3Id) {

        return manageService.getAttrList(catalog3Id);
    }


    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
        return "success";
    }

}
