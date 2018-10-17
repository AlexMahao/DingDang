package com.spearbothy.dingdang.service;

import com.spearbothy.dingdang.common.response.Result;
import com.spearbothy.dingdang.common.response.ResultCode;
import com.spearbothy.dingdang.dao.InformationRepository;
import com.spearbothy.dingdang.entity.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: JackWenbo
 * @Date: 2018/10/17 17:35
 * @Description:
 * @Version 1.0
 */
@Service
public class InformationService {

    @Autowired
    private InformationRepository dao;

    /**
     * 获取所有发布信息
     * @return
     */
    public Result<List<InformationEntity>> getAllInfos(){
        Result<List<InformationEntity>> result=new  Result<List<InformationEntity>>();
        List<InformationEntity> list=dao.findAll();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }

    /**
     * 保存/修改发布信息
     * @param entity
     * @return
     */
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

    /**
     * 删除发布信息
     * @param entity
     */
    public void delInfoById(InformationEntity entity){
        if (entity.getId()!=null){
            dao.delete(entity);
        }
    }

    /**
     * 根据类型获取信息
     * @param type
     * @return
     */
    public Result<List<InformationEntity>> getInfosByType(int type){
        Result<List<InformationEntity>> result=new  Result<List<InformationEntity>>();
        List<InformationEntity> list=dao.getInfosByType(type);
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }
}
