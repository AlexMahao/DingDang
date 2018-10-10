package com.spearbothy.dingdang.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: liuwenbo
 * @Date: 2018/10/9 14:51
 * @Description:评论实体类
 * @Version 1.0
 */
@Entity
@Table(name="t_comment")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class CommentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id
    private Long userd;//用户id
    private String content;//评论内容
    private String channel;//渠道
    private String channelId;//渠道id
    private Date createTime;//创建时间
    private Integer praiseCount;//点赞数
    private String status;//状态
}
