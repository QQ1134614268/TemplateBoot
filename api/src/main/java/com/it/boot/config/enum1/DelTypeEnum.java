package com.it.boot.config.enum1;

/**
 * @date 2023-02-01 09:34
 */
public enum DelTypeEnum  {

    NO(0, "是"),
    YES(1, "否");

    final Integer value;
    final String label;

    DelTypeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
