package com.lifeonline.oss.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author HHY
 */
@Data
@ConfigurationProperties(prefix = "qiniu.oss")
public class QiniuOssProperties {


    private String accessKey;
    private String secretKey;
    private String bucket;
    private String host;


}
