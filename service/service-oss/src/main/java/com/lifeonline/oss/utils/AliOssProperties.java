package com.lifeonline.oss.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author HHY
 */
@Data
@ConfigurationProperties(prefix = "ali.oss")
public class AliOssProperties {


      private String endPoint;
      private String keyId;
      private String keySecret;
      private String bucketName;


}
