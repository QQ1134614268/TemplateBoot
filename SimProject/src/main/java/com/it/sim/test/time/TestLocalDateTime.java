package com.it.sim.test.time;

import com.it.sim.config.TimeConf;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class TestLocalDateTime {
    public static final String str0 = "2022-12-01";
    public static final String str = "2022-12-01 00:00:00";

    public static final LocalDate localDate = LocalDate.parse(str0, TimeConf.Fmt_YYYY_MM_DD);
    public static final LocalDateTime localDateTime = LocalDateTime.parse(str, TimeConf.Fmt_YYYY_MM_DD_HH_MM_SS);


    @Test
    public void testDateParse() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(TimeConf.YYYY_MM_DD);
        SimpleDateFormat sdf2 = new SimpleDateFormat(TimeConf.YYYY_MM_DD_HH_MM_SS);

        System.out.println(sdf.parse(str0));
        System.out.println(sdf.parse(str));

        // System.out.println(sdf2.parse(str0)); // java.text.ParseException: Unparseable date: "2022-12-01"
        System.out.println(sdf2.parse(str));

    }

    @Test
    public void testLocalDateParse() throws ParseException {
        System.out.println(LocalDate.parse(str0, DateTimeFormatter.ofPattern(TimeConf.YYYY_MM_DD)));

        // DateTimeParseException: Text '2022-12-01' could not be parsed at index 10
        // System.out.println(LocalDate.parse(str0, DateTimeFormatter.ofPattern(TimeConf.DATE_TIME_FORMAT)));

        //DateTimeParseException: Text '2022-12-01 00:00:00' could not be parsed, unparsed text found at index 10
        // System.out.println(LocalDate.parse(str, DateTimeFormatter.ofPattern(TimeConf.DATE_FORMAT)));

        System.out.println(LocalDate.parse(str, DateTimeFormatter.ofPattern(TimeConf.YYYY_MM_DD_HH_MM_SS)));

    }

    @Test
    public void testLocalDateTimeParse() throws ParseException {

        // System.out.println(LocalDateTime.parse(str0, DateTimeFormatter.ofPattern(TimeConf.DATE_FORMAT)));

        // java.time.format.DateTimeParseException:Text '2022-12-01' could not be parsed at index 10
        // System.out.println(LocalDateTime.parse(str0, DateTimeFormatter.ofPattern(TimeConf.DATE_TIME_FORMAT)));


        // java.time.format.DateTimeParseException: Text '2022-12-01 00:00:00' could not be parsed, unparsed text found at index 10
        // System.out.println(LocalDateTime.parse(str, DateTimeFormatter.ofPattern(TimeConf.DATE_FORMAT)));

        System.out.println(LocalDateTime.parse(str, DateTimeFormatter.ofPattern(TimeConf.YYYY_MM_DD_HH_MM_SS)));

    }

    @Test
    public void testFrom() {
        // 时间转换都是使用 utc时间
        // ZonedDateTime
        ZoneId zoneId = ZoneId.systemDefault();

        //  转 Date;  Date.from()
        Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
        System.out.println(date);
        Instant instant = date.toInstant();
        System.out.println(instant);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        // 转 Date; localDate -> ZonedDateTime -> Instant-> Date
        System.out.println(Date.from(localDate.atStartOfDay(zoneId).toInstant()));

        // 转 LocalDateTime
        System.out.println(LocalDateTime.ofInstant(instant, zoneId));
        System.out.println(LocalDateTime.from(localDateTime));
        // java.time.DateTimeException: Unable to obtain LocalDateTime from TemporalAccessor: 2022-11-30T16:00:00Z of type java.time.Instant
        // System.out.println(LocalDateTime.from(date.toInstant()));
        System.out.println(LocalDateTime.from(zonedDateTime));
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

    @Test
    public void getBetweenMonth() {
        String start = "2020-03-01";
        String end = "2020-02-01";
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        long distance = ChronoUnit.MONTHS.between(startDate, endDate);
        Stream.iterate(startDate, d -> d.plusMonths(1)).limit(distance + 1).forEach(f -> {
            list.add(f.toString());
        });
        list.forEach(System.out::println);
    }
}