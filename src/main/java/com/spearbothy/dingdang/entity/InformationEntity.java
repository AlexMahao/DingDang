package com.spearbothy.dingdang.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: liuwenbo
 * @Date: 2018/10/9 15:07
 * @Description:信息实体类
 * @Version 1.0
 */
@Entity
@Table(name="t_information")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class InformationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id
    private String title;//标题
    private String type;//类型
    private String content;//内容
    private Integer browseCount;//浏览次数
    private Long userId;//用户id
    private Date createTime;//创建时间
    private String status;//状态
    private String imgUrl;//图片
}
