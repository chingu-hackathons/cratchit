package com.chingu.gloria.santadeliverpresentsaroundworld.model;

import lombok.Data;

@Data
public class DataWrapper<T> {

    private T data;

}