/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderApplication
 * Author:   silence
 * Date:     2019/3/12 11:51
 * Description: 订单微服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.silence.springcloud;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈订单微服务〉
 *
 * @author silence
 * @create 2019/3/12
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
//启动断路器
@EnableCircuitBreaker
@MapperScan("com.silence.springcloud.mapper")
public class OrderApplication {
    public static void main(String[] args){
        SpringApplication.run(OrderApplication.class, args);
    }
}