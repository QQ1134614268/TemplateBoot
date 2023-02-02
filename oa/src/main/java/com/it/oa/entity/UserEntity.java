package com.it.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@ApiModel(value = "人事管理/员工档案")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
@Entity(name = "user")
@Table(appliesTo = "user", comment = "人事管理/员工档案")
public class UserEntity extends BaseEntity {
    @ApiModelProperty(value = "用户名", example = "test_1", required = true)
    @Column(unique = true, nullable = false, columnDefinition = "varchar(255) COMMENT '用户名'")
    private String userName;
    @ApiModelProperty(value = "密码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;
    @ApiModelProperty(value = "员工头像", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '员工头像'")
    private String avatar;

    @ApiModelProperty(value = "员工姓名", example = "test_1", required = true)
    @Column(unique = false, nullable = false, columnDefinition = "varchar(255) COMMENT '员工姓名'")
    private String staffName;
    @ApiModelProperty(value = "手机号码", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '手机号码'")
    private String phone;
    @ApiModelProperty(value = "身份证号", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '身份证号'")
    private String idCard;
    @ApiModelProperty(value = "性别", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '性别'")
    private String sex;
    @ApiModelProperty(value = "出生日期", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '出生日期'")
    private Date birthDay;
    @ApiModelProperty(value = "年龄", example = "125668391", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '年龄'")
    private Integer age;
    @ApiModelProperty(value = "民族", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '民族'")
    private String nation;
    @ApiModelProperty(value = "政治面貌", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '政治面貌'")
    private String politicalStatus;
    @ApiModelProperty(value = "最高学历", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '最高学历'")
    private String highestEducation;
    @ApiModelProperty(value = "最高学位", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '最高学位'")
    private String highestDegree;
    @ApiModelProperty(value = "籍贯", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '籍贯'")
    private String province;
    @ApiModelProperty(value = "现居地", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '现居地'")
    private String address;
    @ApiModelProperty(value = "婚姻状况", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '婚姻状况'")
    private String maritalStatus;
    @ApiModelProperty(value = "参加工作时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '参加工作时间'")
    private Date startWorkDate;
    @ApiModelProperty(value = "紧急联系人", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '紧急联系人'")
    private String emergencyContactPerson;
    @ApiModelProperty(value = "紧急联系人电话", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '紧急联系人电话'")
    private String emergencyContactPhone;
    @ApiModelProperty(value = "联系邮箱", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '联系邮箱'")
    private String email;
    @ApiModelProperty(value = "排序", example = "924347886", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '排序'")
    private Integer userOrder;
    @ApiModelProperty(value = "账号状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '账号状态'")
    private String accountStatus;

    @ApiModelProperty(value = "员工状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '员工状态'")
    private String staffStatus;
    @ApiModelProperty(value = "入职时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '入职时间'")
    private Date entryDate;
    @ApiModelProperty(value = "部门", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '部门'")
    private Integer orgId;
    @ApiModelProperty(value = "是否是领导", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '是否是领导'")
    private Integer isLeader;
    @ApiModelProperty(value = "直属上级id", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '直属上级id'")
    private Integer directLeaderId;

    @ApiModelProperty(value = "职位id", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '职位id'")
    private Integer postId;
    @ApiModelProperty(value = "管理员id", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "int(11) COMMENT '管理员id'")
    private Integer adminId;
    @ApiModelProperty(value = "试用时间", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '试用时间'")
    private Date probationaryDate;
    @ApiModelProperty(value = "转正时间", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '转正时间'")
    private Date regularDate;
    @ApiModelProperty(value = "合同时间", example = "-372385430", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '合同时间'")
    private Date contractDate;
}