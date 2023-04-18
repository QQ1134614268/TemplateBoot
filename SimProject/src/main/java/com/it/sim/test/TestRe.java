package com.it.sim.test;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRe {

    @Test
    public void test1() {
        String txt = "大家好,我叫张三,英文名称:tom cat,我来自CHINA,今年12岁,手机号是:18812341234";
        Pattern pattern = Pattern.compile("^(.*?)([a-z]+\\s[a-z]+)(.*?)([A-Z]+)(.*?)(\\d+)(.*?)(\\d+)");
        Matcher m = pattern.matcher(txt);
        if (m.matches()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
        }
    }

}
