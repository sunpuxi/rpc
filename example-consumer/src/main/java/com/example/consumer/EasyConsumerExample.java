package com.example.consumer;

import com.example.common.model.User;
import com.example.common.service.UserService;
import com.example.sunrpc.procxy.ServiceProxyFactory;

// 消费者的服务调用的实现
public class EasyConsumerExample {

    public static void main(String[] args) {

        // 此处可通过静态或者动态代理的方式获取到
        UserService userService = new UserServiceProxy();

        User user = new User();
        user.setName("sunpx");

        User newUser = userService.getUser(user);

        if (newUser == null) System.out.println("获取到的用户为空");
        else System.out.println("获取到的用户为：" + newUser.getName());
    }
}
