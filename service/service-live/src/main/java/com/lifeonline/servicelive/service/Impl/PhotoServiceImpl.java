package com.lifeonline.servicelive.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lifeonline.servicelive.mapper.PhotoMapper;
import com.lifeonline.servicelive.model.Photo;
import com.lifeonline.servicelive.service.PhotoService;
import org.springframework.stereotype.Service;

/**
 * @author HHY
 */
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper,Photo> implements PhotoService {


    @Override
    public Boolean insert(Photo photo) {
        return baseMapper.insert(photo) != 0;
    }
}
