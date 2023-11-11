package com.snqg.desire.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 愿望表
 * @TableName desire
 */
@TableName(value ="desire")
@Data
public class Desire implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 儿童id
     */
    private String childId;

    /**
     * 愿望标题
     */
    private String title;

    /**
     * 愿望描述
     */
    private String desc;

    /**
     * 愿望进度（布尔型。false为未完成；true为已完成）
     */
    private int progress;

    /**
     * 感谢的具体内容
     */
    private String thanks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}