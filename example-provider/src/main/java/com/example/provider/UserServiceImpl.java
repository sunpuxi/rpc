package com.example.provider;

import com.example.common.model.User;
import com.example.common.service.UserService;

/**
 *
 * 对引入的模块的 userservice 进行的实现
 * 注意，此处的 用户类也需要来自另一模块，而不是自己创建
 */
public class UserServiceImpl implements UserService {

    /**
     * 返回用户信息
     *
     * @param user
     * @return
     */
    @Override
    public User getUser(User user) {
        User user1 = new User();
        user1.setName(user.getName());
        return user1;
    }
}
