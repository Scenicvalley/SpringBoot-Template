package com.example.template.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.template.service.TemplateService;
import com.example.template.util.LoginRequired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/template")
@Api(tags = "模板接口")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @RequestMapping(value = "/get/templateData",method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value = "获取今日跑步数据",notes = "请求参数说明：{\"学号(number):String\"}")
    @LoginRequired
    public Object getHistoryDataByid(@RequestBody JSONObject jsonObject ) throws ParseException {
        return templateService.getTemplateData(jsonObject);
    }
}
