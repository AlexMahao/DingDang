package com.spearbothy.dingdang.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: liuwenbo
 * @Date: 2018/10/8 17:46
 * @Description:用户实体类
 * @Version 1.0
 */
@Entity
@Table(name="t_user")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id
    private Long userId;//用户id
    private String nickName;//用户昵称
    private String sex;//性别
    private String headImageUrl;//头像
    private String userFrom;//用户来源
    private String openId;//微信授权登录id
    private String token;//授权token
    private Date createTime;//创建时间
    private Date lastLoginTime;//最后登录时间
    private String status;//状态
}
