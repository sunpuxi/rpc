package com.example.common.service;

import com.example.common.model.User;

// 用户服务的支持
public interface UserService {

    /**
     * 返回用户信息
     * @param user
     * @return
     */
    User getUser(User user);
}
