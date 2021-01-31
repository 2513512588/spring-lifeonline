package com.lifeonline.servicelive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lifeonline.servicelive.model.Diary;
import com.lifeonline.servicelive.model.vo.DiaryVO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author HHY
 */
@Repository
public interface DiaryMapper extends BaseMapper<Diary> {

    /**
     * 查询首页数据
     * */
    List<DiaryVO> findAllDetail();

}
