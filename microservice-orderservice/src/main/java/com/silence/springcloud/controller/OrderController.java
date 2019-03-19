/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderController
 * Author:   silence
 * Date:     2019/3/12 15:04
 * Description: 订单Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.silence.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.silence.springcloud.mapper.OrderMapper;
import com.silence.springcloud.mapper.UserMapper;
import com.silence.springcloud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈订单Controller〉
 *
 * @author silence
 * @create 2019/3/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping(path = "/findOrders/{userId}")
    //加容错处理后不能打断点，打断点会超时导致进入异常处理
    @HystrixCommand(fallbackMethod = "findOrderfallback")
    public List<Order> findOrder(@PathVariable("userId") Integer userId){
        Order order = orderMapper.selectByPrimaryKey(userId);
        List<Order> orderList = orderMapper.selectAll();
        orderList.add(order);
        return orderList;
    }

    public List<Order> findOrderfallback(Integer userId){
        List<Order> orderList = new ArrayList<>();
        return orderList;
    }
}