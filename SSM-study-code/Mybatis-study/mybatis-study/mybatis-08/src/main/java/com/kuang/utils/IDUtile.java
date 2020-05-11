package com.kuang.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")    //抑制警告
public class IDUtile {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void Test(){
        System.out.println(IDUtile.getId());

    }
}
