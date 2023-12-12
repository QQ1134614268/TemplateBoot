package com.it.boot.util;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    static char UNDERLINE = '_';

    /**
     * 判断一个集合是否为null或者没有元素
     *
     */
    public static <T> boolean isCollectionEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断字符串是否为空
     *
     */
    public static boolean isNull(String str) {
        return str == null || str.length() == 0 || str.equals(" ") || str.equals("null") || str.trim().length() == 0;
    }

    /**
     * 是否整形类型
     *
     */
    public static boolean isInteger(Object data) {
        if (data == null || "".equals(data))
            return false;
        String reg = "[\\d]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(data.toString());
        return Integer.MAX_VALUE >= Double.parseDouble(data.toString()) && m.matches();
    }

    /**
     * 功能：判断字符串是否为数字
     *
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    /**
     * 判断字符串是否为long类型
     *
     */
    public static long parseLong(Object obj) {
        if (obj == null || obj.equals("")) {
            return 0;
        }
        try {
            if (!obj.toString().contains(".")) {
                return Long.parseLong(obj.toString());
            }
            return (long) Double.parseDouble((obj.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 按顺序加入元素(插入排序)
     *
     * @param o    (实现Comparable接口)
     */
    @SuppressWarnings("unchecked")
    public static <T> void addOrderList(List<T> list, T o, boolean isDesc) {
        for (int i = 0; i < list.size(); i++) {
            if (isDesc) {
                if (((Comparable<T>) o).compareTo(list.get(i)) > 0) {
                    list.add(i, o);
                    return;
                }
            } else {
                if (((Comparable<T>) o).compareTo(list.get(i)) < 0) {
                    list.add(i, o);
                    return;
                }
            }
        }
        list.add(o);
    }

    /**
     * 返回字符串长度
     *
     */
    public static int stringLength(String value) {
        int valueLength = 0;
        String chinese = "[Α-￥]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    /**
     * 转换字节
     *
     */
    public static String formatFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString;
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 是否包装类型
     *
     */
    public static boolean isWrappedType(Class<?> type1, Class<?> type2) {
        if (type1 == int.class && type2 == Integer.class)
            return true;
        else if (type2 == int.class && type1 == Integer.class)
            return true;
        else if (type1 == long.class && type2 == Long.class)
            return true;
        else if (type2 == long.class && type1 == Long.class)
            return true;
        else if (type1 == short.class && type2 == Short.class)
            return true;
        else if (type2 == short.class && type1 == Short.class)
            return true;
        else if (type2 == byte.class && type1 == Byte.class)
            return true;
        else if (type1 == byte.class && type2 == Byte.class)
            return true;
        else if (type2 == float.class && type1 == Float.class)
            return true;
        else if (type1 == float.class && type2 == Float.class)
            return true;
        else if (type2 == double.class && type1 == Double.class)
            return true;
        else if (type1 == double.class && type2 == Double.class)
            return true;
        else if (type2 == boolean.class && type1 == Boolean.class)
            return true;
        else return type1 == boolean.class && type2 == Boolean.class;
    }

    /**
     * "" 与 " " 与 null 返回 true
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * list 依 separator分隔开
     *
     * @return string
     */
    public static String listToString(List<?> list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o).append(separator);
        }
        return list.isEmpty() ? "" : sb.substring(0, sb.toString().length() - 1);
    }
    public final static String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 判断字符串是否为空白
     *
     * @param str 字符串
     * @return 判断字符串是否为空白
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    // 字符串,集合,数字
    public static boolean toBool(Object target) {
        if (target == null) {
            return false;
        }

        if (target instanceof String)
            return ((String) target).length() != 0;

        if (target instanceof Collection)
            return !((Collection<?>) target).isEmpty();

        if (target instanceof Number)
            return !target.equals(0);
        return true;
    }

    /**
     * 获取随机字符串
     */
    public static String randomText(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(codes.charAt(random.nextInt(codes.length())));
        }
        return sb.toString();
    }

    public static String toCamelCase(String name) {
        if (null == name) {
            return null;
        }
        if (name.contains(String.valueOf(UNDERLINE))) {
            final int length = name.length();
            final StringBuilder sb = new StringBuilder(length);
            boolean upperCase = false;
            for (int i = 0; i < length; i++) {
                char c = name.charAt(i);

                if (c == UNDERLINE) {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
            return sb.toString();
        } else {
            return name;
        }
    }

    public static String upperFirst(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
