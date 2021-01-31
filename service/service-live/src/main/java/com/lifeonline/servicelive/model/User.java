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
@TableName("all_user")
public class User extends BaseEntity implements Serializable {


    @TableField(value = "username")
    private String username;
    @TableField("pwd")
    private String password;
    @TableField("nickname")
    private String nickname;


}
