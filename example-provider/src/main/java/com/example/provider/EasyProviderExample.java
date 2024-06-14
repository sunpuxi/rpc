package com.example.provider;

import com.example.sunrpc.server.HttpServer;
import com.example.sunrpc.server.VertxHttpServer;
import com.example.sunrpc.registery.LocalRegistry;

// 简易服务提供者的实现
// 调用 RPC 框架
public class EasyProviderExample {
    public static void main(String[] args) {

        // 注册服务
        LocalRegistry.register(UserServiceImpl.class.getName(),UserServiceImpl.class);
        // 启动HTTP服务器
        HttpServer httpServer = new VertxHttpServer();
        // 添加服务
        httpServer.doStart(8080);
    }
}
