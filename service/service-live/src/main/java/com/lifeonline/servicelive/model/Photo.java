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
@TableName("oss_photo")
public class Photo extends BaseEntity implements Serializable {


    @TableField("url")
    private String url;
    @TableField("related_id")
    private Long relatedId;
    @TableField("related_type")
    private Short type;



}
