package com.xzk.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by XiaoZK on 2016/8/29.
 */
public class demo {
    public int randomNumber(int max){
        return new Random().nextInt(max);
    }
    public static void main(String[] args) {
        demo demo = new demo();
        System.out.println(demo.randomNumber(20));
        Map<String, Map<String, Integer>> mapMap = new HashMap<String, Map<String, Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1",1);
        map.put("2",2);
        mapMap.put("1", map);
        System.out.println(mapMap.get("1").get("2"));
    }
}
