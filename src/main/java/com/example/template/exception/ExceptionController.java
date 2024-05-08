package com.example.template.exception;

import com.alibaba.fastjson.JSONObject;
import com.example.template.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author xiao yang
 * @Description: 全局异常处理类,本质是一个component，一般和exceptionHandler搭配使用
 * @date 2023/1/1616:44
 */
@ControllerAdvice
public class ExceptionController {

    public JSONObject handler(MyException e){
        return  new Result().responseResult(e.getCode(),e.getMessage());
    }
}
