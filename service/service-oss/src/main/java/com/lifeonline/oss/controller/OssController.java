package com.lifeonline.oss.controller;

import com.lifeonline.commonutils.bean.R;
import com.lifeonline.oss.service.OssService;
import com.lifeonline.oss.utils.QiniuOssProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.*;


/**
 * @author HHY
 */
@Api(tags = "文件上传控制器")
@RestController
@CrossOrigin
public class OssController {

    private OssService ossService;

    private QiniuOssProperties properties;

    @Autowired
    public void setProperties(QiniuOssProperties properties) {
        this.properties = properties;
    }

    @Qualifier("aliOssServiceImpl")
    @Autowired
    public void setOssService(OssService ossService) {
        this.ossService = ossService;
    }

    @Deprecated
    @ApiOperation("获取文件上传token")
    @PostMapping("/auth/upload")
    public R upload(){
        return R.ok().data("token",ossService.upload()).data("host", properties.getHost());
    }

    @ApiOperation("MultipartFile上传文件接口")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/upload/v1",headers = "content-type=multipart/form-data")
    public R upload(@RequestParam(value = "file") List<MultipartFile> list) throws Exception {
        Map<String,Object> map = new HashMap<>(list.size());
        List<String> list1 = new ArrayList<>();
        for (MultipartFile  file : list) {
             list1.add(ossService.upload(new ByteArrayInputStream(file.getBytes()), Objects.requireNonNull(file.getContentType())));
        }
        map.put("url",list1);
        return R.ok().data(map);
    }

    @ApiOperation("url上传文件接口")
    @PostMapping(value = "/upload/v2")
    public R upload(@RequestParam(value = "url") String [] url) throws Exception {
        Map<String,Object> map = new HashMap<>(url.length);
        List<String> list1 = new ArrayList<>();
        for (String file : url) {
            list1.add(ossService.upload(new URL(file).openStream(), "image/*"));
        }
        map.put("url",list1);
        return R.ok().data(map);
    }




}
