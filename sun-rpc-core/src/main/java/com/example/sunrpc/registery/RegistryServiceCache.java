package com.example.sunrpc.registery;

import com.example.sunrpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * 注册中心服务本地缓存 （ 真实场景中，服务方的变化频率其实并没有那么频繁，所以可以利用缓存来优化调用过程）
 */
public class RegistryServiceCache {

    /**
     * 服务缓存
     */
    List<ServiceMetaInfo> serviceCache;

    /**
     * 写缓存
     *
     * @param newServiceCache
     * @return
     */
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        this.serviceCache = newServiceCache;
    }

    /**
     * 读缓存
     *
     * @return
     */
    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }

    /**
     * 清空缓存
     */
    void clearCache() {
        this.serviceCache = null;
    }
}