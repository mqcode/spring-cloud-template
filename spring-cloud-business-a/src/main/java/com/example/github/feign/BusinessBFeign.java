package com.example.github.feign;

import com.example.github.vo.response.ReturnVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("SPRING-CLOUD-BUSINESS-B")
public interface BusinessBFeign {
    @RequestMapping(value = "/businessB/responseCall",method = RequestMethod.GET)
    ReturnVo<Map<String,String>> callBAndGetResponse();


    @RequestMapping(value = "/businessB/responseCallAndCallC",method = RequestMethod.GET)
    ReturnVo<Map<String,String>> callBThenBCallCAndGetResponse();
}
