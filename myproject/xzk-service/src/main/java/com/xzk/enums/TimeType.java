package com.xzk.enums;

/**
 * Created by XiaoZK on 2016/8/17.
 */
public enum TimeType {
    APPLY("01"),
    START("02"),
    NEWEST("02"),
    REVIEW("03");
    private String typeNo;

    TimeType(String s) {
        this.typeNo = s;
    }

    @Override
    public String toString() {
        return typeNo;
    }
}
