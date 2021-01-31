package com.lifeonline.oss.config;

import com.lifeonline.oss.utils.AliOssProperties;
import com.lifeonline.oss.utils.QiniuOssProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author HHY
 */
@Configuration
@EnableConfigurationProperties({QiniuOssProperties.class, AliOssProperties.class})
public class PropertiesConfig {}
