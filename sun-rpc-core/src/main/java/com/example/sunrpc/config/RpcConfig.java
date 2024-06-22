package com.example.sunrpc.config;

import com.example.sunrpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * @author sunpx
 */

@Data
public class RpcConfig {

    /**
     * mock,开启mock后即可调用模拟mock服务。
     */
    private Boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

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

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();


}
