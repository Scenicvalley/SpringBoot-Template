package com.example.template.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiao yang
 * @Description: swagger文档配置
 * @date 2023/1/1412:29
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger2",value = {"enable"},havingValue = "true")
public class Swagger2 {

    @Value("${swagger2.enable}")
    private boolean enable;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试接口文档")
                .description("template")
                .termsOfServiceUrl("http://localhost:8003")
                .version("1.0")
                .build();
    }

    // 配置请求头
    private List<Parameter> globalOperation(){
        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        /*配置请求头*/
        tokenPar.name("Authorization").description("token令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
    @Bean(value = "defalutApi")
    public Docket DefalutApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .host("localhost:8003")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.template.controller"))
                .paths(PathSelectors.any())
                .build().groupName("需要token检验的接口").ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class)
                .enable(enable)
                .globalOperationParameters(globalOperation());

    }

    @Bean(value = "publicApi")
    public Docket publicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.template.userController"))
                .paths(PathSelectors.any())
                .build().groupName("无需token验证").ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
    }
}
