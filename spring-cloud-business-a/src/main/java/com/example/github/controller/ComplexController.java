package com.example.github.controller;

import com.example.github.service.ComplexService;
import com.example.github.vo.response.ReturnVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 一个调用链路复杂的接口
 */
@Api(tags = "一个调用链路复杂的接口")
@RestController
@RequestMapping("complex")
public class ComplexController {

    @Resource
    private ComplexService complexService;

    @ApiOperation("你好,新生代农民工")
    @GetMapping("/hello")
    public ReturnVo hello(){
        return ReturnVo.success("你好,新生代农民工");
    }

    @ApiOperation("A调用B")
    @GetMapping("/aCallB")
    public ReturnVo aCallB(){
        return ReturnVo.success(complexService.aCallB());
    }
    
    @ApiOperation("A调用C")
    @GetMapping("/aCallC")
    public ReturnVo aCallC(){
        return ReturnVo.success(complexService.aCallC());
    }
    
    @ApiOperation("A调用B,然后调C")
    @GetMapping("/aCallBThenCallC")
    public ReturnVo aCallBThenCallC(){
        return ReturnVo.success(complexService.aCallBThenCallC());
    }

    @ApiOperation("A调用B,B中调C")
    @GetMapping("/")
    public ReturnVo BCallCWhenACallB(){
        return ReturnVo.success(complexService.BCallCWhenACallB());
    }

}
