package com.spearbothy.dingdang.service;

import com.spearbothy.dingdang.common.response.Result;
import com.spearbothy.dingdang.common.response.ResultCode;
import com.spearbothy.dingdang.controller.requestbean.InformationRequest;
import com.spearbothy.dingdang.dao.InformationRepository;
import com.spearbothy.dingdang.entity.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
     * @param request
     * @return
     */
    public InformationEntity saveInfo(InformationRequest request) {
        InformationEntity infoEntity = null;
        HttpServletRequest httpServletRequest=null;
        //新增
        if (request.getId() == null) {
            infoEntity = new InformationEntity();
            infoEntity.setTitle(request.getTitle());
            infoEntity.setUserId(request.getUserId());
            infoEntity.setContent(request.getContent());
            infoEntity.setType(request.getType());
            infoEntity.setCreateTime(new Date());
            infoEntity.setBrowseCount(null);
            infoEntity.setStatus(null);

            try {
                //文件上传
                //上传目录地址
                String uploadDir = httpServletRequest.getSession().getServletContext().getRealPath("/") + "upload/";
                //如果目录不存在,自动创建文件夹
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                //上传文件名
                MultipartFile imgFile = request.getImg();
                String filename = imgFile.getOriginalFilename();

                //文件后缀名
                String suffix = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));

                //数据库保存的文件名
                String imgUrl = "info/" + System.currentTimeMillis() + suffix;

                //服务器端保存的文件对象
                File file = new File(imgUrl);
                //将上传的文件写入到服务器端文件内
                imgFile.transferTo(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //编辑
            infoEntity = dao.getOne(request.getId());
            infoEntity.setTitle(request.getTitle());
            infoEntity.setUserId(request.getUserId());
            infoEntity.setContent(request.getContent());
            infoEntity.setType(request.getType());
            infoEntity.setCreateTime(new Date());
            infoEntity.setBrowseCount(null);
            infoEntity.setStatus(null);


            try {
                //文件上传
                //上传目录地址
                String uploadDir = httpServletRequest.getSession().getServletContext().getRealPath("/") + "upload/";
                //如果目录不存在,自动创建文件夹
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                //上传文件名
                MultipartFile imgFile = request.getImg();
                String filename = imgFile.getOriginalFilename();

                //文件后缀名
                String suffix = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));

                //数据库保存的文件名
                String imgUrl = "info/" + System.currentTimeMillis() + suffix;

                //服务器端保存的文件对象
                File file = new File(imgUrl);
                //将上传的文件写入到服务器端文件内
                imgFile.transferTo(file);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return dao.save(infoEntity);
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
