package com.javatribe.apicommon.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 13:49
 * @description 响应类
 */
@Getter
@Setter
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 4811333361458162044L;
    private T data;
    private ResponseStatus status;
    private Long totalCount;

    public Response() {
        this.status = ResponseStatus.SUCCESS;
    }

    public Response(T data, ResponseStatus status) {
        this.data = data;
        this.status = status;
    }

    public Response(T data) {
        this.data = data;
        this.status = ResponseStatus.SUCCESS;
    }

    public static<T> Response success(T data) {
        return new Response(data,ResponseStatus.SUCCESS);
    }

    public static<T> Response fail(T data) {
        return new Response(data,ResponseStatus.ERROR);
    }

    public static<T> Response fail(T data, ResponseStatus responseStatus) {
        return new Response(data,responseStatus);
    }

    public static<T> Response fail (ResponseStatus responseStatus) {
        return new Response(null,responseStatus);
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", status=" + status.status +
                ", message='" + status.message + '\'' +
                '}';
    }
}
