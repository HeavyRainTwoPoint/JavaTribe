package com.javatribe.apicommon.dto;

import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import lombok.Data;

import java.util.HashMap;

/**
 * 结合 hashmap
 * @Author lyr
 * @create 2020/9/20 11:01
 */
@Data
public class ViewObject  extends BaseEntity<Object>{
    private final HashMap<String, Object> data = new HashMap<>();

    private String message;

    private Integer code;

    public static ViewObject create() {
        return new ViewObject();
    }
    public ViewObject put(String k, Object v) {
        data.put(k,v);
        return this;
    }


    public static <Object>  ViewObject from(String msg, Integer code) {
        return create().setMessage(msg).setCode(code);
    }
    public static ViewObject success() {
        return from("ok",StatusCode.OK);
    }
    public static ViewObject ok(String msg) {
        return success().setMessage(msg);
    }

    public static ViewObject fail(String msg) {
        return from(msg,StatusCode.ERROR);
    }

    public static ViewObject notFound(String msg) {
        return from(msg,StatusCode.GET_LOST);
    }


    public String getMessage() {
        return message;
    }

    public ViewObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ViewObject setCode(Integer code) {
        this.code = code;
        return this;
    }


    public static ViewObject of(ApiInfo info) {
        return new ViewObject().setMessage(info.getMessage()).setCode(info.getCode());
    }

    public static ViewObject ofCode(ApiInfo info) {
        return new ViewObject()
                .setCode(info.getCode());
    }
}
