/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   silence
 * Date:     2019/3/12 15:53
 * Description: 用户管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.silence.springcloud.controller;

import com.silence.springcloud.mapper.UserMapper;
import com.silence.springcloud.model.Order;
import com.silence.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户管理〉
 *
 * @author silence
 * @create 2019/3/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    @Value("${ORDERSERVICEURL}")
    private String ORDERSERVICEURL;

    @GetMapping(path = "/findOrders/{username}")
    public List<Order> getOrderByUsername(@PathVariable("username") String username){
        User user = userMapper.selectByUsername(username);
        //RestTemplate的exchange()方法用于远程调用其他RESTFUL接口方法，并返回指定的对象集合。
        // 其方法的四个参数分别表示请求地址、请求方式、请求参数实体以及返回结果对象
        ResponseEntity<List<Order>> responseEntity = restTemplate.
                exchange(ORDERSERVICEURL + "/order/findOrders/"+user.getId(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
        });
        List<Order> orderList = responseEntity.getBody();
        return orderList;
    }

}