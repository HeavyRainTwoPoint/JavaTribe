package com.javatribe.apilife.dto;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    public static Result ok() {
        return ok(null);
    }

    public static Result ok(Object data) {
        Result result = new Result();
        result.code = 200;
        result.message = "成功";
        result.data = data;
        return result;
    }
}
