package com.example.consumer;

import com.example.sunrpc.config.ConfigUtils;
import com.example.sunrpc.config.RpcConfig;

/**
 * @author sunpx
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 从配置文件中读取信息
        RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class,"rpc");
        System.out.println(rpcConfig);
    }


}
