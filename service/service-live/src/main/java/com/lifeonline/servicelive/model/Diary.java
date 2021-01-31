package com.lifeonline.servicelive.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("live_diary")
public class Diary extends BaseEntity implements Serializable {



    @TableField("title")
    private String title;
    @TableField("detail")
    private String detail;
    @TableField("user_id")
    private Long userId;
    @TableField("is_recommended")
    private Boolean recommended;
    @TableLogic
    @TableField("is_deleted")
    private Boolean deleted;
    @TableField("avatar")
    private String avatar;


}
