package com.example.template.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface TemplateMapper {

    @Select("select * from data")
    ArrayList<Object> getTemplateData();

}

