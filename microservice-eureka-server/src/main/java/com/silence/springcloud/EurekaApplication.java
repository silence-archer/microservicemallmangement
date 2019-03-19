/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EurekaApplication
 * Author:   silence
 * Date:     2019/3/12 11:13
 * Description: 注册中心，用于服务注册发现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.silence.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈注册中心，用于服务注册发现〉
 *
 * @author silence
 * @create 2019/3/12
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class, args);
    }
}