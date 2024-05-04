package com.example.demo.domain.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        return Response.<T>builder().code(200).message("success").data(data).build();
    }

    public static <T> Response<T> error(String message) {
        return Response.<T>builder().code(500).message(message).build();
    }

    public static <T> Response<T> error(int code, String message) {
        return Response.<T>builder().code(code).message(message).data(null).build();
    }

    public boolean isSuccess() {
        return code == 200;
    }

}
