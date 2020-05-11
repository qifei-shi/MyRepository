package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param===>"+name);
        if ("kuangshen".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");

        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<>();
        //添加数据
        userList.add(new User("狂神说java",12,"男"));
        userList.add(new User("狂神说C",13,"男"));
        userList.add(new User("狂神说Linux",12,"女"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "";
        if (name!=null){
            //admin应该从数据库中查到
            if ("admin".equals(name)){
                msg = "ok";
            }else if(name==""){
                msg = "用户名不能为空";
            }else {
                msg = "用户名已存在";
            }
        }
        if (pwd!=null){
            //pwd应该从数据库中查到
            if ("admin".equals(pwd)){
                msg = "ok";
            }else if (pwd==""){
                msg = "密码不能为空";
            }else{
                msg = "密码有误";
            }
        }

        return msg;
    }

}
