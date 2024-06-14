package com.example.sunrpc.serializer;

import java.io.IOException;

/**
 * 序列化器接口
 */
// RPC 框架负责对传递的对象进行序列化。
// Dubbo 作为一个 RPC 框架，序列化的方式是序列化为二进制。
public interface Serializer {

    /**
     * 序列化
     *
     * @param object
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     *
     * @param bytes
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}