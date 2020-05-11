package com.kuang.demo01;

public class Client {
    public static void main(String[] args) {
        //房东要租房子l
        Host host = new Host();
        //host.rent();
        //代理，中介帮房东租房子，但是呢？代理一般会有一些附属操作
        Proxy proxy = new Proxy(host);

        //你不用面对房东，直接找中介租房即可！
        proxy.rent();

    }
}
