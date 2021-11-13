package com.example.github.feign;

import com.example.github.vo.response.ReturnVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("SPRING-CLOUD-BUSINESS-C")
public interface BusinessCFeign {
    @RequestMapping(value = "/businessC/responseCall",method = RequestMethod.GET)
    ReturnVo<Map<String,String>> callCAndGetResponse();
}