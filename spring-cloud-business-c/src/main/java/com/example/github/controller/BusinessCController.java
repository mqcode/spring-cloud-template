package com.example.github.controller;

import com.example.github.vo.response.ReturnVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "业务服务C接口")
@RestController
@RequestMapping("/businessC")
public class BusinessCController {

    @Value("${spring.application.name}")
    private String APPLICATION_NAME;

    @Value("${spring.application.description}")
    private String APPLICATION_DESCRIPTION;

    @ApiOperation("响应外部请求")
    @GetMapping("/responseCall")
    public ReturnVo responseCall(){
        Map<String,String> map = new HashMap<>();
        map.put(APPLICATION_NAME + APPLICATION_DESCRIPTION,"我是"+ APPLICATION_NAME + APPLICATION_DESCRIPTION+",你调用我成功了哦！");
        return ReturnVo.success(map);
    }
}
