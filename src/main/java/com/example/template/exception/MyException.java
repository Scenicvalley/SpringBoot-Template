package com.example.template.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiao yang
 * @Description: 自定义异常类
 * @date 2023/1/1616:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {
    private int code; //异常状态码
    private String message; //异常信息

}
