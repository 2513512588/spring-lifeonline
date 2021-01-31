package com.lifeonline.commonutils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HHY
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket webApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                  .groupName("webApi")
                  .apiInfo(new ApiInfoBuilder()
                                .title("lifeonline")
                                .description("lifeonline在线api文档")
                                .version("1.0")
                                .build()
                  );
    }


}
