package com.example.consumer;

import com.example.common.model.User;
import com.example.common.service.UserService;
import com.example.sunrpc.procxy.ServiceProxyFactory;

/**
 * @author sunpx
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("sunpx");

        // 调用
        User newUser = userService.getUser(user);
        if(newUser!=null) System.out.println(newUser);
        else System.out.println("null");

        short number = userService.getNumber();
        System.out.println(number);
    }


}
