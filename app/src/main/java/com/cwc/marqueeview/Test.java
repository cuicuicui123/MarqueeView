package com.cwc.marqueeview;

import com.alibaba.fastjson.JSON;

/**
 * @author Cuiweicong 2017/9/19
 */

public class Test {
    public static void main(String[] args){
        String json = "{\"data\":null,\"errorCode\":0,\"message\":null,\"success\":false}";
        Data data = JSON.parseObject(json, Data.class);
        System.out.println(String.valueOf(data));
    }
}
