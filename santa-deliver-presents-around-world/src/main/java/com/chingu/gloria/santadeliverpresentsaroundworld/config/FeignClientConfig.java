package com.chingu.gloria.santadeliverpresentsaroundworld.config;

import feign.Contract;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
