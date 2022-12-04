package com.github.akwei.agentdemo.agent2.test;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2022/12/4 21:26
 */
public class TestMethodDelegate {

    public static String newMethod(String s1, Long l1, Boolean b1) {
        System.out.println("TestMethodDelegate newMethod");
        return "TestMethodDelegate newMethod_" + s1 + "_" + l1 + "_" + b1;
    }
}
