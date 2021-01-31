package com.lifeonline.servicelive.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lifeonline.servicelive.mapper.DiaryMapper;
import com.lifeonline.servicelive.model.Diary;
import com.lifeonline.servicelive.service.DiaryService;
import org.springframework.stereotype.Service;

/**
 * @author HHY
 */
@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements DiaryService {

}
