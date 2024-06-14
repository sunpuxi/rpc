package com.example.sunrpc;

import com.example.sunrpc.config.ConfigUtils;
import com.example.sunrpc.config.RpcConfig;
import com.example.sunrpc.constant.RpcConstant;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sunpx
 * Rpc 启动类
 */
@Slf4j
public class RpcApplication {
    // rpc 配置
    public static volatile RpcConfig rpcConfig;

    /**
     * 支持自定义参数进行初始化
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig){
        rpcConfig = newRpcConfig;
        log.info("rpc config init : config:{}",rpcConfig);
    }

    /**
     * 初始化
     */
    public static void init(){
        RpcConfig newRpcConfig;

        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            newRpcConfig = new RpcConfig();
        }

        init(newRpcConfig);
    }

    /**
     * 获取配置
     * 单例模式获取
     * @return
     */
    public static RpcConfig getRpcConfig(){
        if (rpcConfig == null){
            synchronized (RpcApplication.class){
                if (rpcConfig == null){
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
