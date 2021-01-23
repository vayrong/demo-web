package com.example.herokudemo.pojo;

import lombok.Data;

@Data
public class ResponseDto<T> {
    int code;
    int page;
    int size;
    String message;
    T data;
    public ResponseDto() {

    }
    public ResponseDto(T t) {
        data = t;
    }
}
