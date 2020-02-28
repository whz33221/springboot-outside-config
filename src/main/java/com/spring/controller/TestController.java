package com.spring.controller;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.Charset;


//todo 打包进行测试待会
@RestController
public class TestController {
    @RequestMapping("classpathFile1")
    public String classpathFile1() throws Exception {

        File file = ResourceUtils.getFile("classpath:static/test.txt");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        int read = inputStream.read(bytes);
        String res = new String(bytes,"UTF-8");
        return res;

    }
    @RequestMapping("classpathFile2")
    public String classpathFile2() throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resource = resolver.getResources("classpath:static\\test.txt");
        InputStream input = resource[0].getInputStream();
        byte[] bytes = new byte[input.available()];
        int read = input.read(bytes);
        return new String(bytes);
    }

    @RequestMapping("classpathFile3")
    public String classpathFile3() throws Exception {
        Resource resource = new ClassPathResource("static/test.txt");
        InputStream input = resource.getInputStream();
        byte[] bytes = new byte[input.available()];
        int read = input.read(bytes);
        return new String(bytes);
    }



    @RequestMapping("outsizeFile1")
    public Object outsizeFile1() throws Exception {
        File file = new File("static/test.txt");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        int read = inputStream.read(bytes);
        String res = new String(bytes,"UTF-8");
        return res;
    }

    @RequestMapping("outsizeFile2")
    public Object outsizeFile2() throws Exception {
        File file = ResourceUtils.getFile("file:./static/test.txt");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        int read = inputStream.read(bytes);
        String res = new String(bytes,"UTF-8");
        return res;
    }






}
