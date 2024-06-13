package com.example.consumer;

import com.example.common.model.User;
import com.example.common.service.UserService;

// 消费者的服务调用的实现
public class EasyConsumerExample {

    public static void main(String[] args) {
        UserService userService = user -> {
            User user1 = new User();
            user1.setName("sunpx");
            return user1;
        };

        User user = new User();
        user.setName("sunpx");

        User newUser = userService.getUser(user);

        if (newUser == null) System.out.println("获取到的用户为空");
        else System.out.println("获取到的用户为：" + newUser.getName());
    }
}
