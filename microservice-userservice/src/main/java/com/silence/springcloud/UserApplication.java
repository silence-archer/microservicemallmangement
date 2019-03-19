/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserApplication
 * Author:   silence
 * Date:     2019/3/12 15:48
 * Description: 用户管理微服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.silence.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户管理微服务〉
 *
 * @author silence
 * @create 2019/3/12
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.silence.springcloud.mapper")
public class UserApplication {
    public static void main(String[] args){
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    //实现负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}