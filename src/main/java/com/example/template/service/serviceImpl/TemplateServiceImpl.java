package com.example.template.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.example.template.mapper.TemplateMapper;
import com.example.template.pojo.Result;
import com.example.template.pojo.ResultCode;
import com.example.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired()
    TemplateMapper templateMapper;

    @Override
    public JSONObject getTemplateData(JSONObject jsonObject) {
        return new Result().responseResult(ResultCode.success.getStatusCode(),ResultCode.success.getMsg(),templateMapper.getTemplateData());
    }
}
