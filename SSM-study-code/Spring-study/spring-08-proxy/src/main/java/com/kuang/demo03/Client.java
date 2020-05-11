package com.kuang.demo03;

public class Client {
    public static void main(String[] args) {
        //真是角色
        Host host = new Host();
        //代理角色：现在还没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过程序处理角色来处理我们要调用的接口对象！
        pih.setRent(host);
        //这里的proxy就是动态生成的，我们并没写
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }


}
