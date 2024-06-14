package com.example.sunrpc.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import io.netty.util.internal.StringUtil;

/**
 * 配置工具类
 */
public class ConfigUtils {

    public static  <T>  T loadConfig(Class<T> tClass,String prefix){
        return loadConfig(tClass,prefix,"");
    }

    public static  <T>  T loadConfig(Class<T> tClass,String prefix,String environment){
        StringBuilder configFileBuilder = new StringBuilder("application");
        // 如果配置了环境，则添加环境前缀
        if (StrUtil.isNotBlank(environment)) configFileBuilder.append("-").append(environment);
        configFileBuilder.append(".properties");
        Props props = new Props(configFileBuilder.toString());

        // 如果配置了前缀，则添加前缀
        return props.toBean(tClass,prefix);
    }
}
