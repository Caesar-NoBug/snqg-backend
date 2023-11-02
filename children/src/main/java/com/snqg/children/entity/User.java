package com.snqg.children.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId
    private String wechatId;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private Integer role;

    /**
     * 
     */
    private Integer gender;

    /**
     * 
     */
    private String avatar;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Integer age;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}