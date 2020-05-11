package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    //http://localhost:8080/add?a=2&b=2
    //http://localhost:8080/add/2/5
    // @RequestMapping( value = "/add/{a}/{b}", method = RequestMethod.GET)
    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg","结果为="+res);
        //转发 forward:(默认就是转发)
        return "test";
    }

    @GetMapping("/c1/t2")
    public String test2(Model model){

        model.addAttribute("msg","结果为=");
        //重定向  加一个redirect:
        return "redirect:/index.jsp";
    }



}
