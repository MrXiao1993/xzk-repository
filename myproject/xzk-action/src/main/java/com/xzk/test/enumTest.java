package com.xzk.test;

import com.xzk.enums.Country;
import org.junit.Test;

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

}
