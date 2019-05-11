package com.atlisongtao.project1231.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atlisongtao.project1231.bean.SpuInfo;
import com.atlisongtao.project1231.service.ManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class SpuManageController {
    @Reference
    private ManageService manageService;

    @RequestMapping("spuListPage")
    public String spuListPage() {
        return "spuListPage";
    }

    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> spuList(String catalog3Id) {
        //声明spuInfo对象
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return manageService.getSpuInfoList(spuInfo);
    }

}
