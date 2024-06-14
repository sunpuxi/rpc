package com.example.sunrpc.config;

import lombok.Data;

/**
 * @author sunpx
 */

@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "sun-rpc";

    /**
     * 端口
     */
    private Integer serverPort = 8080;

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务端地址
     */
    private String serverHost = "localhost";


}
