package com.lifeonline.servicelive.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lifeonline.servicelive.model.Classify;
import com.lifeonline.servicelive.model.ClassifyRelated;

public interface ClassifyService extends IService<Classify> {

    Boolean insertDiaryClassify(ClassifyRelated classifyRelated);

}
