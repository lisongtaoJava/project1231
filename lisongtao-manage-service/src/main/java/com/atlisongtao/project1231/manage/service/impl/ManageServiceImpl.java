package com.atlisongtao.project1231.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atlisongtao.project1231.bean.*;
import com.atlisongtao.project1231.manage.mapper.*;
import com.atlisongtao.project1231.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;
    @Autowired
    private SpuInfoMapper spuInfoMapper;


    //查询一级分类重写的方法
    @Override
    public List<BaseCatalog1> getCatalog1() {
        List<BaseCatalog1> baseCatalog1List = baseCatalog1Mapper.selectAll();
        return baseCatalog1List;
    }

    //根据一级分类查询二级分类重写的方法
    /*
    这里new BaseCatalog2();是因为二级分类是通过一级分类选则商品才触发二级分类，
    一级分类只是引出商品总称，
    而触发二级分类后二级分类作为一个独立的商品选项它的选择不会影响一级分类，
    如果这里不new BaseCatalog2这会导致二级分类和一级分类为绑定关系这种绑定为静态绑定也就是死绑定，
    这里的new BaseCatalog2指的是二级分类作为一个新对象既不影响一级分类又能触发三级分类商品选项，
    这里不单单是显示商品，而是搜索并选择商品。
    二级分类调用三级分类原理也是如此。
    */
    //错误点
    @Override
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    //根据二级分类查询三级分类重写方法
    @Override
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        // List<BaseCatalog3> baseCatalog3List = baseCatalog3Mapper.select(baseCatalog3);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    //根据三级分类Id查询平台属性列表重写方法
    @Override
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        // List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.select(baseAttrInfo);
        return baseAttrInfoMapper.select(baseAttrInfo);
    }


    //大保存实现
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //添加，又编辑{baseAttrInfo.id}操作""{BaseAttrInfo}
        if (baseAttrInfo.getId() == null || baseAttrInfo.getId().length() == 0) {
            //将主键设置为null
            if (baseAttrInfo.getId().length() == 0) {
                baseAttrInfo.setId(null);
            }
            //插入baseAttrInfo
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        } else {
            //通过主键选择更新
            baseAttrInfoMapper.updateByPrimaryKeySelective(baseAttrInfo);
        }
        //操作baseAttrValue插入前，如果有相应的数据，则删除，反之则作修改的事情！
        //delete from baseAttrValue where attrId = baseAttrInfo.id;
        //创建属性值对象
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValue);
        //插入数据
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        //错误点
        if (attrValueList != null && attrValueList.size() > 0) {
            for (BaseAttrValue attrValue : attrValueList) {
                if (attrValue.getId().length() == 0) {
                    attrValue.setId(null);
                }
                //添加attrId值
                attrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(attrValue);
            }
        }
    }

    @Override
    public BaseAttrInfo getAttrInfo(String attrId) {
        //通过主键查找id
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        //查询平台属性集合
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(baseAttrInfo.getId());
        List<BaseAttrValue> baseAttrValueList = baseAttrValueMapper.select(baseAttrValue);
        baseAttrInfo.setAttrValueList(baseAttrValueList);
        return baseAttrInfo;
    }

    @Override
    public List<SpuInfo> getSpuInfoList(SpuInfo spuInfo) {

        return spuInfoMapper.select(spuInfo);
    }

}
