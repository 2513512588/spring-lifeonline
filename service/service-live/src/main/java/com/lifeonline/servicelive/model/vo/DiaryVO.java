package com.lifeonline.servicelive.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.lifeonline.servicelive.model.Classify;
import com.lifeonline.servicelive.model.Photo;
import lombok.Data;

import java.util.List;

/**
 * @author HHY
 */
@Data
public class DiaryVO {

    @TableField("userId")
    private Long userId;
    @TableField(value = "nickname")
    private String nickname;
    @TableField("avatar")
    private String avatar;

    @TableField("title")
    private String title;
    @TableField("detail")
    private String detail;
    @TableField(exist = false)
    private List<Photo> photos;

    @TableField("likeQuantity")
    private Long likeQuantity;
    @TableField("commentQuantity")
    private Long commentQuantity;
    @TableField("repostQuantity")
    private Long repostQuantity;

    @TableField(exist = false)
    private List<Classify> classifies;

}
