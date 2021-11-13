package com.example.github.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 解决feign远程调用丢失请求头问题
 */
@Configuration
public class FeignConfig {
    @Bean("requestInterceptor")
    public RequestInterceptor requestInterceptor(){
        return template -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String element = headerNames.nextElement();
                template.header(element,request.getHeader(element));
            }
        };
    }
}
