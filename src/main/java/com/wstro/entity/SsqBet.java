package com.wstro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_d_ssq_bet")
public class SsqBet implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField
    private int stage;

    @TableField
    private String one;

    @TableField
    private String two;

    @TableField
    private String three;

    @TableField
    private String four;

    @TableField
    private String five;

    @TableField
    private String six;

    @TableField
    private String seven;

    @TableField
    private Integer state;

    @TableField
    private Integer award;

    @TableField
    private Integer winMoney;

    @TableField
    private Date createTime;

    @TableField
    private Date updateTime;

    @TableField
    private Long createBy;
}
