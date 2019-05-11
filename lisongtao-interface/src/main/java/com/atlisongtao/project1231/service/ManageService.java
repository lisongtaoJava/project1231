package com.atlisongtao.project1231.service;

import com.atlisongtao.project1231.bean.*;

import java.util.List;
import java.util.Map;

public interface ManageService {
    //查询一级分类
    List<BaseCatalog1> getCatalog1();

    //根据一级分类查询二级分类
    List<BaseCatalog2> getCatalog2(String catalog1Id);

    //根据二级分类查询三级分类
    List<BaseCatalog3> getCatalog3(String catalog2Id);

    //根据三级分类Id查询平台属性列表
    List<BaseAttrInfo> getAttrList(String catalog3Id);

    //大保存平台属性,平台属性值
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    // 根据平台属性Id 查询平台属性对象
    BaseAttrInfo getAttrInfo(String attrId);

    // 根据三级分类Id查询商品列表 catalog3Id,id,spuName
    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);

}
