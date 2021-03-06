package com.kuang.pojo;


import org.springframework.lang.Nullable;

import javax.annotation.Resource;

public class People {

    @Resource(name = "cat22")
    private Cat cat;

    @Resource
    private Dog dog;

    private String name;

    @Override
    public String toString() {
        return "people{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(@Nullable Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
