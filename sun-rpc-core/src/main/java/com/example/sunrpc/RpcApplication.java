package com.example.sunrpc;

import com.example.sunrpc.config.ConfigUtils;
import com.example.sunrpc.config.RegistryConfig;
import com.example.sunrpc.config.RpcConfig;
import com.example.sunrpc.constant.RpcConstant;
import com.example.sunrpc.registery.Registry;
import com.example.sunrpc.registery.RegistryFactory;
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
     * 框架初始化，支持传入自定义配置
     * 当服务节点退出时，使用 JVM 的 ShutDownHook 进行服务的下线处理
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
        // 注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init, config = {}", registryConfig);

        // 创建并注册 Shutdown Hook，JVM 退出时执行操作
        Runtime.getRuntime().addShutdownHook(new Thread(registry::destroy));
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
