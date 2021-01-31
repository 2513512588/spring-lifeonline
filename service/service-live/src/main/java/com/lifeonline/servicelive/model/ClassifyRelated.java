package com.lifeonline.servicelive.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.lifeonline.commonutils.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author HHY
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ClassifyRelated extends BaseEntity implements Serializable {


    @TableField("classifyId")
    private Long classifyId;
    @TableField("relatedId")
    private Long relatedId;
    @TableField("relatedType")
    private Short relatedType;

}
