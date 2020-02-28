package com.spring;

import com.spring.config.YmlPropertySourceFactory;
import com.spring.test.Person;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(Person.class)
public class OutSideConfigApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext run = SpringApplication.run(OutSideConfigApplication.class, args);
//         new Thread(new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                Person person = run.getBean("person", Person.class);
//                while(true){
//                    TimeUnit.SECONDS.sleep(1);
//                    log.info("person:"+person.toString());
//                }
//            }
//        }).start();
         new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                File file1 = new File("static/test.txt");
                log.info(file1.getAbsolutePath());
                log.info(file1.exists()?"static/test.txt: Get Success!":"static/test.txt: Get fail!");


                try {
                    File file2 = ResourceUtils.getFile("classpath:static/test.txt");
                    log.info(file2.exists()?"classpath:static/test.txt: Get Success!":"classpath:static/test.txt: Get fail!");
                } catch (FileNotFoundException e) {
                    log.error("classpath:static/test.txt: Get fail!");
                }





                File file3 = ResourceUtils.getFile("file:");
                log.info(file3.exists()?"file:test.txt: Get Success!":"file:test.txt: Get fail!");

            }
        }).start();
    }

}
