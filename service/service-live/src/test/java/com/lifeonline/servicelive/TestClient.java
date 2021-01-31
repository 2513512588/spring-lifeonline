package com.lifeonline.servicelive;

import com.lifeonline.commonutils.bean.R;
import com.lifeonline.servicelive.client.OssClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestClient {

    @Autowired
    private OssClient ossClient;

    @Test
    public void uploadPhoto() throws Exception {
        R r = ossClient.upload(new String[]{"http://tiebapic.baidu.com/forum/pic/item/b31bb051f81986187cd376cc5ded2e738ad4e6e6.jpg"});
        log.debug("r = {}" , r);
    }


}
