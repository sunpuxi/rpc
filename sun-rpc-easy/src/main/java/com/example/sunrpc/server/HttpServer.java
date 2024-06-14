package com.example.sunrpc.server;


/**
 *  HTTP 服务器接口
 */
public interface HttpServer {

    /**
     * 启动服务
     * @param port 监听的端口
     */
    void doStart(int port);
}
