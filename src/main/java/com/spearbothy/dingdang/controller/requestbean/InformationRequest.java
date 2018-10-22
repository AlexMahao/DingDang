package com.spearbothy.dingdang.controller.requestbean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: JackWenbo
 * @Date: 2018/10/21 20:38
 * @Description:Info请求数据
 * @Version 1.0
 */
@Setter
@Getter
public class InformationRequest {
    private Long id;//id
    private String title;//标题
    private String type;//类型
    private String content;//内容
    private Integer browseCount;//浏览次数
    private Long userId;//用户id
    private Date createTime;//创建时间
    private String status;//状态
    private MultipartFile img;//图片
}
