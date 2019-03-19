/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZuulApplication
 * Author:   silence
 * Date:     2019/3/12 11:33
 * Description: 其他微服务项目的API网关实现其他微服务接口的动态代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.silence.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * 〈一句话功能简述〉<br> 
 * 〈其他微服务项目的API网关实现其他微服务接口的动态代理〉
 *
 * @author silence
 * @create 2019/3/12
 * @since 1.0.0
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class, args);
    }
}