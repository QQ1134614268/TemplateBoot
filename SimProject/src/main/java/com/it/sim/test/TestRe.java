package com.it.sim.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class TestRe {
    // @ApiImplicitParam\((?!.*dataType) 匹配@ApiImplicitParam( 不包含dataType
    // @ApiImplicitParam\((?!.*dataType).*value
    // ^@ApiImplicitParam\((?!.*dataType).*value
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

    @Test
    public void test2() {
        // 匹配出3个字符的字符串
        String str = "abc 124  fs     sf sf sf  sf s dee ad a f s f sa a' lf ;'l";
        Pattern pt = Pattern.compile("\\b\\w{3}\\b");
        Matcher match = pt.matcher(str);
        while (match.find()) {
            System.out.println(match.group());
        }
        // 匹配出邮箱地址
        String str2 = "dada da da   dasK[COM DADA@DAD.CN =03J0IS ADHAJ@565@ADA.COM.CN shuqi@162.com ";
        Pattern pet2 = Pattern.compile("\\b\\w+@\\w+(\\.\\w{2,4})+\\b");
        Matcher match2 = pet2.matcher(str2);
        while (match2.find()) {
            System.out.println(match2.group());
        }

        //2222
        String sr = "dada ada   ad adr3 fas daf fas  234 adda";
        // 包含两个匹配组，一个是三个字符，一个是匹配四个字符
        Pattern pet = Pattern.compile("\\b(\\w{3}) *(\\w{4})\\b");
        match = pet.matcher(sr);
        int countAll = match.groupCount();// 2
        while (match.find()) {
            System.out.print("匹配组结果：");
            for (int i = 0; i < countAll; i++) {
                System.out.printf("\n\t第%s组的结果是:%s", i + 1, match.group(i + 1));
            }
            System.out.print("\n匹配的整个结果:");
            System.out.println(match.group());
        }

        // 3
        sr = "dada ada adr3 fas daf fas 234 adda";
        pet = Pattern.compile("\\b(\\w{3}) *(\\w{4})\\b");
        match = pet.matcher(sr);
        while (match.find()) {
            MatchResult ms = match.toMatchResult();
            System.out.print("匹配对象的组结果：");
            for (int i = 0; i < ms.groupCount(); i++) {
                System.out.printf("\n\t第%s组的结果是:%s", i + 1, ms.group(i + 1));
            }
            System.out.print("\n匹配的整个结果:");
            System.out.println(ms.group());
        }
    }

    @Test
    public void test3() {
        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市|.*?京|.*?海|.*?津)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<country>[^(区|市|县|旗|岛)]+区|.*?市|.*?县|.*?旗|.*?岛)?(?<town>[^区]+区|.+市|.+镇)?(?<village>.*)";
        Pattern pet = Pattern.compile(regex);
        List<String> args = Arrays.asList("广东省深圳市南山区", "新疆维吾尔自治区喀什地区塔什库尔干塔吉克自治县");
        for (String sr : args) {
            Matcher match = pet.matcher(sr);
            while (match.find()) {
                String province = match.group("province");
                String city = match.group("city");
                String country = match.group("country");
                String town = match.group("town");
                String village = match.group("village");

                log.info("{}, {}, {}, {}, {}", province, city, country, town, village);
            }
        }

    }
}
