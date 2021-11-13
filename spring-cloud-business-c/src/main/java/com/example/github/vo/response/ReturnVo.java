package com.example.github.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一返回类
 */
@Data
@ApiModel("统一返回类")
public class ReturnVo<T> {

    private static final String SUCCESS_CODE = "SUCCESS";
    private static final String ERROR_CODE = "ERROR";

    /**
     * 返回代码
     */
    @ApiModelProperty("返回代码")
    private String code;

    /**
     * 返回信息
     */
    @ApiModelProperty("返回信息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty("返回数据")
    private T data;

    ReturnVo(String code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ReturnVo<T> success(T data){
        return new ReturnVo(SUCCESS_CODE,"",data);
    }

    public static <T> ReturnVo<T> fail(String message,T data){
        return new ReturnVo(ERROR_CODE,message,data);
    }
}
