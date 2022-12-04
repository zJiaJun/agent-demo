package com.github.akwei.agentdemo.app;

public class Main {

    public static void main(String[] args) {
//        System.out.println("hello");
        UserBean userBean = new UserBean();
        userBean.setUserId(10);
        userBean.setName("aaa");
        userBean.printInfo("a");
    }
}
