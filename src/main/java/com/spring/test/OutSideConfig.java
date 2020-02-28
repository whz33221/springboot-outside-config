package com.spring.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class OutSideConfig {
    @Value("${test.msg}")
    private String msg;
}
