package com.lifeonline.servicelive.controller;

import com.lifeonline.commonutils.bean.R;
import com.lifeonline.servicelive.model.Diary;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author HHY
 */
@Api(tags = "日记接口")
@RestController
@CrossOrigin
public class DiaryController {

    @PostMapping("/diary/create")
    public R createDiary(@RequestBody Diary diary){
        return R.ok();
    }


}
