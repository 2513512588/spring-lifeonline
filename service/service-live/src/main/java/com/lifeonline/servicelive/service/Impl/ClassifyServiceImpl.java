package com.lifeonline.servicelive.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lifeonline.servicelive.mapper.ClassifyMapper;
import com.lifeonline.servicelive.model.Classify;
import com.lifeonline.servicelive.model.ClassifyRelated;
import com.lifeonline.servicelive.service.ClassifyService;
import org.springframework.stereotype.Service;

/**
 * @author HHY
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {



    @Override
    public Boolean insertDiaryClassify(ClassifyRelated classifyRelated) {
        return baseMapper.insertDiaryClassify(classifyRelated) != 0;
    }
}
