package com.xzk.action;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XiaoZK on 2016/11/9.
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        //将字符串2000-12-22转成Date类型
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = f.parse(source);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
