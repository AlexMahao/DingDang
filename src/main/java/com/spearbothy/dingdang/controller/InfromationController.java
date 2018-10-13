package com.spearbothy.dingdang.controller;

import com.spearbothy.dingdang.common.response.Result;
import com.spearbothy.dingdang.common.response.ResultCode;
import com.spearbothy.dingdang.dao.InformationRepository;
import com.spearbothy.dingdang.entity.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Auther: liuwenbo
 * @Date: 2018/10/10 14:50
 * @Description:信息Controller
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/info",name="信息")
public class InfromationController {

    @Autowired
    private InformationRepository dao;

    @RequestMapping(value="getAllInfos",name="获取所有信息")
    @ResponseBody
    public Result<List<InformationEntity>> getAllInfos(){
        Result<List<InformationEntity>> result=new  Result<List<InformationEntity>>();
        List<InformationEntity> list=dao.findAll();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }

    @RequestMapping(value="saveInfo",name="保存信息")
    @ResponseBody
    public InformationEntity saveInfo(InformationEntity entity){
        InformationEntity infoEntity=null;
        //新增
        if (entity.getId()==null){
            infoEntity=new InformationEntity();
            infoEntity.setTitle(entity.getTitle());
            infoEntity.setUserId(entity.getUserId());
            infoEntity.setContent(entity.getContent());
            infoEntity.setType(entity.getType());
            infoEntity.setCreateTime(new Date());
            infoEntity.setBrowseCount(null);
            infoEntity.setStatus(null);
        }else {
            //编辑
            infoEntity.setTitle(entity.getTitle());
            infoEntity.setUserId(entity.getUserId());
            infoEntity.setContent(entity.getContent());
            infoEntity.setType(entity.getType());
            infoEntity.setCreateTime(new Date());
            infoEntity.setBrowseCount(null);
            infoEntity.setStatus(null);
        }
        return dao.save(entity);
    }

    @RequestMapping(value="delInfo",name="删除信息")
    @ResponseBody
    public void delInfo(InformationEntity entity){
        if (entity.getId()!=null){
            dao.delete(entity);
        }
    }
}
