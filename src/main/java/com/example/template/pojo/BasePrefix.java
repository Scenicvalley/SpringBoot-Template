package com.example.template.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author xiao yang
 * @Description: 前缀
 * @date 2023/1/1412:18
 */
@AllArgsConstructor
@NoArgsConstructor
public enum BasePrefix {
    user_prefix(0,"user_"),
    data_year_prefix(1,"data_year"),
    data_month_prefix(2,"data_month"),
    data_week_prefix(3,"data_week"),
    totalMileage_prefix(4,"totalMileage");
    private int code;
    private String prefix;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
