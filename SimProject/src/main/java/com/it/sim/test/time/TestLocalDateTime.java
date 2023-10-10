package com.it.sim.test.time;

import com.it.sim.config.TimeConf;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Date LocalDateTime 相互转换
 * 时间类结构:
 * @see Date 日期时间, toInstant, parse, DateFormat, 时间戳
 * @see TemporalAccessor
 * @see     Temporal
 * @see         Instant     瞬时时间, from atZone atOffset, 加减, 比较, adjustInto
 * @see         ZonedDateTime from of parse toInstant toLocalDateTime 加减, 比较
 * @see         LocalDate
 * @see         LocalDateTime  from of at toLocalDate parse, 加减, 比较; 通过at转ZonedDateTime转Instant转Date
 * @see         OffsetDateTime   from of  parse toInstant toLocalDateTime 加减, 比较
 * @see     Month
 * @see     MonthDay
 * @see ZoneId 时区id, 本质TimeZone??
 * @see Duration 计算时间加减, time包
 * @see TemporalUnit
 * @see     ChronoUnit 年月日 时分秒 毫秒  周 半年 季度, 本质是 Duration
 * @see TimeUnit 时间相关, util包
 * @see TimeZone 时区
 * @see DateFormat 格式化; text包
 * @see Locale 本地化
 * @see Calendar
 *
 * Temporal: 时间的,世俗的
 * Chrono: 编年史的,记事
 */
public class TestLocalDateTime {
    public static final String dateYmd = "2022-01-01";
    public static final String dateYmdHms = "2022-01-01 10:10:10";

    public static final LocalDate localDate = LocalDate.parse(dateYmd, TimeConf.FMT_YMD);
    public static final LocalDateTime localDateTime = LocalDateTime.parse(dateYmdHms, TimeConf.FMT_YMD_HMS);

    public static final Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

    /**
     * 默认格式化方式: DateTimeFormatter.ISO_LOCAL_DATE, DateTimeFormatter.ISO_LOCAL_DATE_TIME
     * <br/>
     * Date,LocalDate,LocalDateTime 都有默认格式化方式, 查看 toString, parse
     */
    @Test
    public void testSerializable() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime parse = LocalDateTime.parse(now.toString());

        System.out.println(now);
        System.out.println(parse);


        Date now1 = new Date();
        Date parse1 = new Date(Date.parse(now1.toString()));

        System.out.println(now1);
        System.out.println(parse1);

    }

    @Test
    public void testObj2Str() {
        String str = date.toString();
        String str1 = localDate.toString();
        String str2 = localDateTime.toString();
        String str3 = LocalDateTime.now().toString();

        System.out.println(str); // Sat Jan 01 10:10:10 CST 2022
        System.out.println(str1); // 2022-01-01
        System.out.println(str2); // 2022-01-01T10:10:10
        System.out.println(str3); // 带毫秒
    }

    /**
     * 字符串转对象
     * Date: 类似正则匹配, 多余的字符舍弃
     * LocalDate, LocalDateTime: 完全匹配??
     */
    @Test
    public void testStr2Obj() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(TimeConf.YMD);
        SimpleDateFormat sdf2 = new SimpleDateFormat(TimeConf.YMD_HMS);

        // 1. 转 Date
        System.out.println(sdf.parse(dateYmd));
        System.out.println(sdf.parse(dateYmdHms));

        // System.out.println(sdf2.parse(str0)); // java.text.ParseException: Unparseable date: "2022-12-01"
        System.out.println(sdf2.parse(dateYmdHms));

        // 2. 转 LocalDate
        System.out.println(LocalDate.parse(dateYmd, DateTimeFormatter.ofPattern(TimeConf.YMD)));
        System.out.println(LocalDate.parse(dateYmdHms, DateTimeFormatter.ofPattern(TimeConf.YMD_HMS)));
        // System.out.println(LocalDate.parse(dateYmdHms, DateTimeFormatter.ofPattern(TimeConf.YYYY_MM_DD)));
        // System.out.println(LocalDate.parse(dateYmd, DateTimeFormatter.ofPattern(TimeConf.DATE_TIME_FORMAT)));

        // 3. 转 LocalDateTime
        System.out.println(LocalDateTime.parse(dateYmdHms, DateTimeFormatter.ofPattern(TimeConf.YMD_HMS)));
        // System.out.println(LocalDateTime.parse(dateYmd, DateTimeFormatter.ofPattern(TimeConf.YYYY_MM_DD)));
        // System.out.println(LocalDateTime.parse(dateYmdHms, DateTimeFormatter.ofPattern(TimeConf.YYYY_MM_DD)));

    }


    /**
     * Locale 影响??
     */
    @Test
    public void testLocale() {
        DateTimeFormatter fmtYmdHms = DateTimeFormatter.ofPattern(TimeConf.YMD_HMS);
        DateTimeFormatter fmtCn = DateTimeFormatter.ofPattern(TimeConf.YMD_HMS, Locale.CHINA);
        DateTimeFormatter fmtEn = DateTimeFormatter.ofPattern(TimeConf.YMD_HMS, Locale.ENGLISH);

        System.out.println(localDateTime.format(fmtYmdHms));
        System.out.println(localDateTime.format(fmtCn));
        System.out.println(localDateTime.format(fmtEn));
    }


    @Test
    public void testConvert() {
        // 时间转换都是使用 utc时间
        // ZonedDateTime
        ZoneId zoneId = ZoneId.systemDefault();

        //  转 Date;  Date.from(), toInstant
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
        Instant instant = date.toInstant();
        System.out.println(instant);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        // 转 Date; localDate -> ZonedDateTime -> Instant-> Date
        System.out.println(Date.from(localDate.atStartOfDay(zoneId).toInstant()));

        // 转 LocalDateTime; ofInstant, from
        System.out.println(date.toInstant().atZone(zoneId).toLocalDateTime());
        System.out.println(LocalDateTime.ofInstant(instant, zoneId));
        System.out.println(LocalDateTime.ofInstant(date.toInstant(), zoneId));
        System.out.println(LocalDateTime.from(zonedDateTime)); // 不支持Instant, 支持 LocalDateTime ZonedDateTime OffsetDateTime
        // java.time.DateTimeException: Unable to obtain LocalDateTime from TemporalAccessor: 2022-11-30T16:00:00Z of type java.time.Instant
        // System.out.println(LocalDateTime.from(date.toInstant()));

        // // java.time.DateTimeException: Unable to obtain LocalDateTime from TemporalAccessor: 2022-11-30T16:00:00Z of type java.time.Instant
        // System.out.println(LocalDateTime.from(date.toInstant().atZone(zoneId).toInstant()));


        // 转 LocalDate
        System.out.println(LocalDate.from(localDateTime));
        // System.out.println(LocalDate.from(date.toInstant()));
        System.out.println(LocalDate.from(zonedDateTime));
        // System.out.println(LocalDate.from(date.toInstant().atZone(zoneId).toInstant()));
        System.out.println(date.toInstant().atZone(zoneId).toLocalDate());
        System.out.println(LocalDateTime.ofInstant(instant, zoneId).toLocalDate());

        // Instant.now()

        // LocalDateTime.ofInstant()
        // LocalDateTime.of()
        // LocalDateTime.parse()
        // LocalDateTime.now()

    }

    /**
     * 获取时间段内的月份, 多用于统计,时间填充
     */
    @Test
    public void getBetweenMonth() {
        String start = "2020-03-01";
        String end = "2020-02-01";
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        long distance = ChronoUnit.MONTHS.between(startDate, endDate);
        List<LocalDate> ret = Stream.iterate(startDate, x -> x.plusMonths(1))
                .limit(distance + 1)
                .collect(Collectors.toList());
        ret.forEach(System.out::println);
    }
}