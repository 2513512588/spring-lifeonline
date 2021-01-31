package com.lifeonline.servicelive.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lifeonline.commonutils.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author HHY
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("all_classify")
public class Classify extends BaseEntity implements Serializable {

    @TableField("subject")
    private String subject;
    @TableField("description")
    private String description;


}
