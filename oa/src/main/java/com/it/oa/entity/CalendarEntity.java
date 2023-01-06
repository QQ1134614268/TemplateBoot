package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@TableName(value = "calendar")
@Entity(name = "calendar")
@Table(appliesTo = "calendar", comment = "日历")
public class CalendarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @TableId(type = IdType.INPUT)
    @Column(unique = false, nullable = false, columnDefinition = "date COMMENT '日期'")
    private LocalDate date;
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '年'")
    private Integer year;
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '月'")
    private Integer month;
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '日'")
    private Integer day;
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '周'")
    private Integer week;
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '周'")
    private Integer weekYear;
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '季度'")
    private Integer quarter;
    @Column(unique = false, nullable = false, columnDefinition = "int(11) COMMENT '半年'")
    private Integer halfYear;
}