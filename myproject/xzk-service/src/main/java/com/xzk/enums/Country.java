package com.xzk.enums;

/**
 * Created by XiaoZK on 2016/8/24.
 */
public enum Country {
    UN_KNOW("000"),
    MALAYSIA("060"),
    JAPAN("081"),
    KOREA("082");
    private String countryNumber;

    Country(String countryNo) {
        this.countryNumber = countryNo;
    }

    public String countryNo() {
        return this.countryNumber;
    }

}
