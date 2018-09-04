package com.ladyishenlong.rapp.test;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<String> getTestData(){

        List<String> datas=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datas.add("测试数据："+i);
        }

        return datas;
    }

}
