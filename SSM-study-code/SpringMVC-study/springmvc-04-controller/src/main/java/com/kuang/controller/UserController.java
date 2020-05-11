package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //http://localhost:8080/user/t1 ? username = XXX
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1、接受前端参数
        System.out.println("接受到前端参数"+name);

        //2、将返回的结果传递给前端     ，   model
        model.addAttribute("msg",name);
        return "test";
    }

    //前端接受一个对象
    /*
    * 1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    * 2.假设传递的是- -个对象User，匹配User对象中的字段名:如果名字- -致则0K， 否则，匹配不到
    * */
    @GetMapping("/t2")
    public String test2(User user, Model model){
        //1、接受前端参数
        System.out.println("接受到前端参数"+user);

        //2、将返回的结果传递给前端     ，   model
        model.addAttribute("msg",user);
        return "test";
    }


}
