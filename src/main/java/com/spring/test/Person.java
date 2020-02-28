package com.spring.test;

import com.spring.config.YmlPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@PropertySource(value = {"classpath:out-side-config-person.yml"}, encoding = "utf-8", factory = YmlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "person")
@Component
public class Person {
    private String money;
    private String sex;


}

