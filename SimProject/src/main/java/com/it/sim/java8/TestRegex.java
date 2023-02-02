package com.it.sim.java8;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
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
        MatchResult ms;
        while (match.find()) {
            ms = match.toMatchResult();
            System.out.print("匹配对象的组结果：");
            for (int i = 0; i < ms.groupCount(); i++) {
                System.out.printf("\n\t第%s组的结果是:%s", i + 1, ms.group(i + 1));
            }
            System.out.print("\n匹配的整个结果:");
            System.out.println(ms.group());
        }
    }
}
