package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会Spring容器托管，注册到容器中，因为他本来就是1@Component, @Configuration代表这是一个几置类，就和我们之前看的beans.xmL
@Configuration
@ComponentScan("com.kuang.pojo")
@Import(MyConfig2.class)
public class MyConfig {

    //注册- -个bean ，就相当 于我们之前写的一个bean 标签
    //这个方法的名字，就相当Fbean标签中的id属性
    //这个方法的返回值，就相当Fbean标签中的cLass属性
    @Bean
    public User getUser(){

        return new User();
    }

}
