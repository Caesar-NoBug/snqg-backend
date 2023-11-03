package com.snqg.children.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息表
 * @TableName user
 */
@TableName(value ="user")
@Data
@EqualsAndHashCode
public class User implements Serializable {
    /**
     * 微信id
     */
    @TableId
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色(0:管理员，1：儿童，2：志愿者，3：捐助者)
     */
    private Integer role;

    /**
     * 性别（1：男，2：女）
     */
    private Integer gender;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * 地址
     */
    private String address;

    /**
     * 生日
     */
    private LocalDateTime birth;

    /**
     * 积分
     */
    private Integer point;

    /**
     * 上一次信息更改时间
     */
    private LocalDateTime updateBy;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}