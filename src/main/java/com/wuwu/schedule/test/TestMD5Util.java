package com.wuwu.schedule.test;

import com.wuwu.schedule.util.MD5Util;
import org.testng.annotations.Test;

public class TestMD5Util {
    @Test
    public void testMD5Util() {
        System.out.println(MD5Util.encrypt("wuwu"));
    }
}
