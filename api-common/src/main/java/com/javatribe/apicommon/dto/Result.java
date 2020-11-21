package com.javatribe.apicommon.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * @Author lyr
 * @create 2020/7/14 0:53
 * @description 统一返回数据 Result
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> extends BaseEntity<T>{


    /**
     * @apiNote 是否成功
     *
     */
    // private Boolean flag;//是否成功

    private Integer code;//返回码

    private String message;//返回消息


    private T data;//返回数据

    public static<T>  Result<T> from(String msg, Integer code, Boolean flag, T data) {
        return from(msg,code,data);
    }
    public static <Object>  Result<Object> from(String msg, Integer code) {
        return new  Result<Object>().setMessage(msg).setCode(code);
    }

    public static<T>  Result<T> from(String msg, Integer code, T data) {
        return  Result.<T>from(msg,code)
                .setData(data);
    }

    // public Boolean getFlag() {
    //     return flag;
    // }
    //
    // public  Result<T> setFlag(Boolean flag) {
    //     this.flag = flag;
    //     return this;
    // }

    public Integer getCode() {
        return code;
    }

    public  Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public  Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public  Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static Result<String> success() {
        return from("ok",StatusCode.OK);
    }
    public static <T> Result<T> success(T data) {
        return from("ok",StatusCode.OK,data);
    }

    public static Result<String> fail() {
        return from("失败",StatusCode.ERROR);
    }
    public static Result<String> fail(String msg) {
        return from(msg,StatusCode.ERROR);
    }
    public static Result<String> notFound() {
        return from("没有资源",StatusCode.GET_LOST);
    }
    // public static Result<String> missing(String msg) {
    //     return from(msg,StatusCode.GET_LOST);
    // }
    public static Result<?> notFound(String msg) {
        return from(msg,StatusCode.GET_LOST);
    }



    public static  <T> Result<T> of(ApiInfo info) {
        Result<T> result = new Result<>();
        return result.setCode(info.getCode()).setMessage(info.getMessage());
    }

    public static <T> Result<T> ofCode(ApiInfo info) {
        Result<T> result = new Result<>();
        return result.setCode(info.getCode());
    }

}
