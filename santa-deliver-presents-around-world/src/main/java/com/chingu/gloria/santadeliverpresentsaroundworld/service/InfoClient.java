package com.chingu.gloria.santadeliverpresentsaroundworld.service;

import com.chingu.gloria.santadeliverpresentsaroundworld.model.Response;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "fakerapi",url = "https://fakerapi.it/api/v1")
public interface InfoClient {

    @RequestLine("GET /persons?_quantity={quantity}")
    Response personList(@Param(value = "quantity") int quantity);

    @RequestLine("GET /books?_quantity={quantity}")
    Response bookList(@Param(value = "quantity") int quantity);
}
