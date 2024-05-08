package com.example.template.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author xiao yang
 * @Description: 时间格式转换工具类
 * @date 2023/1/1412:43
 */
@Component
public class DateUtil {
    /**
     * 获取UU-id
     */
    public String getID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取时间戳
     */
    public String getDatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    /**
     * 获取日期
     */
    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 将string转换为时间戳
     */
    public long dateStringToLong(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse(date);
        long da = date1.getTime();
        return da;
    }
    /**
     * 将date类型转换为string类型
     */
    public  String dateToString(Date date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(date);
        return s;
    }

    public Date StringToDate(String time) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = ft.parse(time);
        return date;
    }

    /***
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date  date){
        String dateFormat="s mm HH * * *";
        return formatDateByPattern(date, dateFormat);
    }
    /***
     *  修改cron参数格式
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateByPattern(Date date,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
}
