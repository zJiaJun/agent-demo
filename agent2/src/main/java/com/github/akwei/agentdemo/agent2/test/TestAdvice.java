package com.github.akwei.agentdemo.agent2.test;

import net.bytebuddy.asm.Advice;

import java.util.Map;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2022/12/4 14:30
 */
public class TestAdvice {


    @Advice.OnMethodEnter
    public static Map<String, Object> enter(@Advice.This Object obj) {
        //app class loader
        System.out.println("test advice enter class loader: " + obj.getClass().getClassLoader());
        TestAction action = TestDispatcher.getAction("test");
        Map<String, Object> map = action.enter(obj);
        return map;
    }

    @Advice.OnMethodExit
    public static void exit(@Advice.Enter Map<String, Object> map,
                            @Advice.This Object obj) {
        System.out.println("test advice exit class loader: " + obj.getClass().getClassLoader());
        TestAction action = TestDispatcher.getAction("test");
        action.exit(map, obj);
    }
}
