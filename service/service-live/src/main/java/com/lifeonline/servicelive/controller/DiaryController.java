package com.lifeonline.servicelive.controller;

import com.lifeonline.commonutils.bean.R;
import com.lifeonline.servicelive.model.Diary;
import com.lifeonline.servicelive.service.DiaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author HHY
 */
@Api(tags = "日记接口")
@RestController
@CrossOrigin
public class DiaryController {


    private DiaryService diaryService;

    @Autowired
    public void setDiaryService(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/diary/create")
    public R createDiary(@RequestBody Diary diary){
        return R.auto(diaryService.save(diary));
    }


}
