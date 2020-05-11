package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private String  id;         //随机生成一个Id，利用IDUtile
    private  String title;
    private String author;
    private Date createTime;    //属性名字段名不一致
    private int views;
}
