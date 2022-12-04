package com.github.akwei.agentdemo.agent2.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2022/12/4 14:23
 */
public class TestDispatcher {

    private static final Map<String, TestAction> MAP = new HashMap<>();

    public static void setAction(String key, TestAction action) {
        MAP.put(key, action);
    }

    public static TestAction getAction(String key) {
        return MAP.get(key);
    }


}
