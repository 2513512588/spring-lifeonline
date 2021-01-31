package com.lifeonline.servicelive;

import com.lifeonline.servicelive.mapper.DiaryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapper {

    @Autowired
    private DiaryMapper diaryMapper;

    @Test
    public void testDiaryVoMapper(){
        log.debug("diaryList = {}", diaryMapper.findAllDetail());
    }

}
