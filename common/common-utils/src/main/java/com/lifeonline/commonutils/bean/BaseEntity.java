package com.lifeonline.commonutils.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {


    @TableId(type = IdType.ID_WORKER)
    @TableField("id")
    private Long id;
    @TableField("gmt_create")
    private Date createTime;
//    @TableField("gmt_modified")
//    private Date modified;
////    @TableField("version")
////    private String version;
//    @TableField("is_deleted")
//    private Boolean deleted;


    @JsonSerialize(using= ToStringSerializer.class)
    public Long getId() {
        return id;
    }
}
