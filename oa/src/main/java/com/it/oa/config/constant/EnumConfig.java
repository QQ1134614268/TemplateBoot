package com.it.oa.config.constant;

public class EnumConfig {
    // 汇报类型
    public static class ReportType {
        String DAY_Report = "日报";
        String WEEK_Report = "周报";
        String MONTH_Report = "月报";
    }

    // 性别
    public static class SexEnum {
        String MALE = "男";
        String FEMALE = "女";

    }

    // 员工状态
    public static class StaffStatusEnum {
        String FORMAL = "正式";
    }

    // 账号状态
    public static class AccountStatusEnum {

        String FORBIDDEN = "禁用";
        String NORMAL = "正常";
    }

    // 评分方式
    public static class ScoreEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }

    // 客户范围
    public static class CustomerEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }

    // 客户分类
    public static class CustomerGroupEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }

    // 客户标签
    public static class CustomerTagEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }

    // 成交状态
    public static class DealStatusEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }

    // 合同范围
    public static class ContractEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }

    // 合同结款
    public static class ContractPayStatusEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }

    // 合同结款
    public static class ContractRepayEnum {
        String SUM = "加和评分";
        String WEIGHT = "加权评分";
    }
}