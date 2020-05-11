package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//@Controller
@RestController
public class UserController {

    @RequestMapping(value = "/j1")
   // @ResponseBody//添加之后就不会走试图解析器，会直接返回一个字符串
    public String test1() throws JsonProcessingException {

        //jackson   ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("Tom",13,"男");

        String str = mapper.writeValueAsString(user);

        return str;
    }


    @RequestMapping(value = "/j2")
    // @ResponseBody//添加之后就不会走试图解析器，会直接返回一个字符串
    public String test2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();
        User user = new User("Tom",13,"男");
        User user2 = new User("Tom2",13,"男");
        User user3 = new User("Tom3",13,"男");
        User user4 = new User("Tom4",13,"男");
        User user5 = new User("Tom5",13,"男");
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        //String str = mapper.writeValueAsString(users);

        return JsonUtils.getJson(users);
    }


    @RequestMapping(value = "/j3")
    // @ResponseBody//添加之后就不会走试图解析器，会直接返回一个字符串
    public String test3() throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            mapper.setDateFormat(sdf);

            Date date = new Date();


            //时间解析后默认格式 Timestamp，时间戳
            return mapper.writeValueAsString(date);
        }


        //对test3的改进


    @RequestMapping(value = "/j4")
    // @ResponseBody//添加之后就不会走试图解析器，会直接返回一个字符串
    public String test4() throws JsonProcessingException {
        Date date = new Date();

        return JsonUtils.getJson(date);
    }



}
