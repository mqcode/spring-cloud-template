package com.example.github.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger访问地址
 * http://localhost:8080/swagger-ui/index.html
 * 一些常用注解说明
 * @ Api：用在controller类，描述API接口
 * @ ApiOperation：描述接口方法
 * @ ApiModel：描述对象
 * @ ApiModelProperty：描述对象属性
 * @ ApiImplicitParams：描述接口参数
 * @ ApiResponses：描述接口响应
 * @ ApiIgnore：忽略接口方法
 */
@Configuration
public class Swagger3Config {

    @Value("${spring.application.name}")
    private String API_TITLE;

    @Value("${spring.application.description}")
    private String API_DESCRIPTION;

    @Value("${spring.application.version}")
    private String API_VERSION;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .contact(new Contact("mqcode", "https://mqcode.github.io", "maqiangsdu@foxmail.com"))
                .version(API_VERSION)
                .build();
    }

}