package com.example.template.pojo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author xiao yang
 * @Description: 结果集
 * @date 2023/1/1321:08
 */
@Component
public class Result {
    public JSONObject responseResult(int statusCode, String msg){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("statusCode",statusCode);
        jsonObject.put("msg",msg);
        return jsonObject;
    }

    public JSONObject responseResult(int statusCode,String msg,Object object){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("statusCode",statusCode);
        jsonObject.put("msg",msg);
        jsonObject.put("rst",object);
        return jsonObject;
    }
}
