package com.example.provider;

import com.example.sunrpc.RpcApplication;
import com.example.sunrpc.registery.LocalRegistry;
import com.example.sunrpc.server.HttpServer;
import com.example.sunrpc.server.VertxHttpServer;

/**
 * 服务提供
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();
        // 本地注册
        LocalRegistry.register(UserServiceImpl.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
