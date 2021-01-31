package com.lifeonline.servicelive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lifeonline.servicelive.model.Classify;
import com.lifeonline.servicelive.model.ClassifyRelated;
import org.springframework.stereotype.Repository;


/**
 * @author HHY
 */


@Repository
public interface ClassifyMapper extends BaseMapper<Classify> {

    /**
     * 添加日记、话题关系
     * @param classifyRelated 话题关系对象
     * @return Integer
     * */
    Integer insertDiaryClassify(ClassifyRelated classifyRelated);

}
