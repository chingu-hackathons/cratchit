package com.chingu.gloria.santadeliverpresentsaroundworld.model;

import lombok.Data;

@Data
public class Response<T> {
    private String status;
    private String code;
    private String total;
    private T data;
}
