package com.example.github.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC跨域及Swagger重定向配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 跨域
     * @param registry 跨域资源共享登记 Cross-Origin Resource Sharing Registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 添加映射路径
         */
        registry.addMapping("/**")
                /**
                 * 是否发送Cookie
                 */
                .allowCredentials(true)
                /**
                 * 设置放行哪些原始域 .allowedOriginPatterns("*")
                 * SpringBoot2.4.4下低版本使用.allowedOrigins("*")
                 */
                .allowedOrigins("*")
                /**
                 * 放行哪些请求方式
                 * .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                 * .allowedMethods("*") //或者放行全部
                 */
                .allowedMethods("*")
                /**
                 * 放行哪些原始请求头部信息
                 */
                .allowedHeaders("*");
    }

    /**
     * Swagger重定向配置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addRedirectViewController("/", "/swagger-ui/");
    }
}