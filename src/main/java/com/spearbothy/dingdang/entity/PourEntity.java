package com.spearbothy.dingdang.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: liuwenbo
 * @Date: 2018/10/9 15:14
 * @Description:心情实体类
 * @Version 1.0
 */
@Entity
@Table(name="t_pour")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class PourEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id
    private Long userId;//用户id
    private String content;//评论内容
    private String imageUrl;//渠道
    private Integer browseCount;//浏览次数
    private Integer praiseCount;//点赞次数
    private Date createTime;//创建时间
    private String status;//状态
}
