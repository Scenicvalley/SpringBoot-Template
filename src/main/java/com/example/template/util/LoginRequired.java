package com.example.template.util;

import java.lang.annotation.*;

/**
 * @author xiao yang
 * @Description: 标签注解
 * @date 2023/1/1412:42
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginRequired {
}
