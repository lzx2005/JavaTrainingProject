package com.lzx2005.training.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Created by Lizhengxian on 2017/3/27.
 */
public class MapDemo1 {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a","b");
        map.forEach((s, s2) -> System.out.println(s+"-"+s2));

        ArrayList arrayList = new ArrayList();
    }
}
