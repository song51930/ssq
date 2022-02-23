package com.wstro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_d_ssq")
public class SsqBonusEntity implements Serializable {

    /**
     * 第几期
     */
    @TableId(type = IdType.INPUT)
    private int id; //第几期

    /**
     * 红球号码第一个
     */
    @TableField
    private String one;
    /**
     * 红球号码第二个
     */
    @TableField
    private String two;
    /**
     * 红球号码第三个
     */
    @TableField
    private String three;

    /**
     * 红球号码第四个
     */
    @TableField
    private String four;

    /**
     * 红球第五个
     */
    @TableField
    private String five;

    /**
     * 红球第六个
     */
    @TableField
    private String six;

    /**
     * 蓝球
     */
    @TableField
    private String seven;

    /**
     * 奖金池金额
     */
    @TableField
    private String bonusPool;

    /**
     * 一等奖奖金
     */
    @TableField
    private String oneBonus;

    /**
     * 一等奖注数
     */
    @TableField
    private int oneNotes;

    /**
     * 二等奖奖金
     */
    @TableField
    private String twoBonus;

    /**
     * 二等奖注数
     */
    @TableField
    private int twoNotes;

    /**
     * 总投注金额
     */
    @TableField
    private String totalBonus;

    /**
     * 开奖时间
     */
    @TableField
    private Date openBounsDate;


    @TableField
    private Date createTime;
}
