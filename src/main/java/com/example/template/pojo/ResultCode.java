package com.example.template.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author xiao yang
 * @Description: 结果代码集
 * @date 2023/1/1321:09
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode {
    success(0, "成功"),
    fail(1, "不存在该用户"),
    error(2, "密码错误"),
    exception(3, "服务端异常"),
    find_error(4, "查询失败"),
    no_match(5, "验证码错误"),
    file_nomatch(6, "文件格式不对"),
    exits(7, "该用户已经存在"),
    overdue(8, "验证码过期"),
    modify_error(9, "修改失败"),
    no_url(10, "url为空"),
    fail_register(11, "注册失败"),
    //    no_record(12, "没有跑步记录"),
    no_data(12,"没有用户数据"),
    no_historicaldata(13,"历史数据为空"),
    no_running(14,"跑步总里程为0"),
    no_token(15,"token失效"),
    had_friend(16,"好友已添加");

    private int statusCode;
    private String msg;
    public int getStatusCode() {
        return statusCode;
    }

    public String getMsg() {
        return msg;
    }
}
