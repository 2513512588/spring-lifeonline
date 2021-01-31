package com.lifeonline.servicelive.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lifeonline.servicelive.model.Photo;

public interface PhotoService extends IService<Photo> {

    Boolean insert(Photo photo);

}
