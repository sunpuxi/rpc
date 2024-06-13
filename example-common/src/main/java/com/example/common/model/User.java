package com.example.common.model;

import java.io.Serializable;

// 对象需要实现序列化接口，为后续的网络传输时的序列化提供支持。
public class User implements Serializable {
    private  String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
