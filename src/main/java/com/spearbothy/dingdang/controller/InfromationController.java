package com.spearbothy.dingdang.controller;

import com.spearbothy.dingdang.common.response.Result;
import com.spearbothy.dingdang.common.response.ResultCode;
import com.spearbothy.dingdang.dao.InformationRepository;
import com.spearbothy.dingdang.entity.InformationEntity;
import com.spearbothy.dingdang.service.InformationService;
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
    private InformationService service;

    @RequestMapping(value="getAllInfos",name="获取所有信息")
    @ResponseBody
    public Result<List<InformationEntity>> getAllInfos(){
       return service.getAllInfos();
    }

    @RequestMapping(value="getAllInfos",name="根据类型获取信息")
    @ResponseBody
    public Result<List<InformationEntity>> getInfosByType(int type){
          return service.getInfosByType(type);
    }

    @RequestMapping(value="saveInfo",name="保存信息")
    @ResponseBody
    public InformationEntity saveInfo(InformationEntity entity){
         return  service.saveInfo(entity);
    }

    @RequestMapping(value="delInfo",name="删除信息")
    @ResponseBody
    public void delInfoById(InformationEntity entity){
        this.service.delInfoById(entity);
    }
}
