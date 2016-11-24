package com.xzk.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by XiaoZK on 2016/8/16.
 */
public class enumTest {
    @Test
    public void enumtest() {
        long sum = 0;
        for (long j = 0; j < Integer.MAX_VALUE; j++) {
            sum = j;
        }
        System.out.println(sum);
    }

    @Test
    public void dateConverter() throws UnsupportedEncodingException {
        String str = "我AB汗DEF";//我ABCD
//        String str = "asdfghjkl";
        int index = 5;

        char c;
//        String origin = new String(str.getBytes(), "GB2312");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            c = str.charAt(i);
            sb.append(c);
            if (String.valueOf(c).getBytes().length > 1) {
                --index;
            }
        }
        String s = str.substring(0, index);
//        System.out.println(sb.toString());
        System.out.println(s);


    }

    @Test
    public void String() {
        String s1 = "我是中国人";
        String s2 = "imchinese";
        String s3 = "im中国人A";
        System.out.println(s1 + ":" + new String(s1).length());
        System.out.println(s2 + ":" + new String(s2).length());
        System.out.println(s3 + ":" + new String(s3).length());
        System.out.println((s1.getBytes().length == s1.length()) ? "我是中国人 无汉字" : "我是中国人 有汉字" + s1.getBytes().length);
        System.out.println((s2.getBytes().length == s2.length()) ? "imchinese 无汉字" : "imchinese 有汉字" + s2.getBytes().length);
        System.out.println((s3.getBytes().length == s3.length()) ? "im中国人 无汉字" : "im中国人 有汉字" + s3.getBytes().length);
    }
}
