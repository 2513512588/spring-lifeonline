package com.lifeonline.servicelive.client;

import com.lifeonline.commonutils.bean.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author HHY
 */
@Component
@FeignClient(name = "service-oss")
public interface OssClient {

    /**
     * 阿里云oss
     * @param list 多图
     * @return R
     * */
    @PostMapping(value = "/upload/v1",headers = "content-type=multipart/form-data")
    R upload(@RequestParam(value = "file") List<MultipartFile> list);

    @PostMapping(value = "/upload/v2")
    public R upload(@RequestParam(value = "url") String [] url) throws Exception;

}
