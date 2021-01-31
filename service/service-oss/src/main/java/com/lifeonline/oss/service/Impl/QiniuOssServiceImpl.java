package com.lifeonline.oss.service.Impl;

import com.lifeonline.oss.service.OssService;
import com.lifeonline.oss.utils.QiniuOssProperties;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Deprecated
@Service
public class QiniuOssServiceImpl implements OssService {

    @Autowired
    private QiniuOssProperties properties;

    @Override
    public String upload() {
        Auth auth = Auth.create(properties.getAccessKey(), properties.getSecretKey());
        return auth.uploadToken(properties.getBucket());
    }

    /**
     * @param data 文件字节数组
     * */
    @Override
    public String upload(@NonNull byte [] data , @NonNull String contentType) throws Exception {
        Configuration configuration = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(configuration);
        Auth auth = Auth.create(properties.getAccessKey(), properties.getSecretKey());
        String token = auth.uploadToken(properties.getBucket());
        Response response = uploadManager.put(data, UUID.randomUUID().toString().replace("-",""),token);
        return response.getInfo();
    }
}
