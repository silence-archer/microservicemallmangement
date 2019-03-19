/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SwaggerConfiguration
 * Author:   silence
 * Date:     2019/3/14 10:02
 * Description: Swagger-ui可视化接口测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.silence.springcloud.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Swagger-ui可视化接口测试〉
 *
 * @author silence
 * @create 2019/3/14
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    //定义API接口映射路径
    public static final String DEFAULT_INCLUDE_PATTERN = "/user/.*";
    private final Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);

    @Bean
    public Docket swaggerSpringfoxDocket(){
        logger.debug("Starting Swagger");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //用于生成对应API接口文档的描述信息，可省略

        ApiInfo apiInfo = new ApiInfo("用户管理API接口测试文档","描述","版本","termsOfServiceUrl",new Contact("aaa","ccc","ccc"),"","");
        //paths()方法用于匹配映射microservice-userservice项目中的以“/user/”开头的接口方法
        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).genericModelSubstitutes(ResponseEntity.class)
                .forCodeGeneration(true).genericModelSubstitutes(ResponseEntity.class).directModelSubstitute(java.time.LocalDate.class,String.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class,Date.class)
                //匹配路径生成对应的接口文档
                .select().paths(regex(DEFAULT_INCLUDE_PATTERN))
                .build();
        stopWatch.stop();
        logger.debug("Started Swagger in {}ms",stopWatch.getTotalTimeMillis());
        return docket;
    }
}