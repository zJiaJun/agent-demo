package com.github.akwei.agentdemo.agent2.test;

import java.util.Map;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2022/12/4 14:23
 */
public interface TestAction {


    Map<String, Object> enter(Object obj);

    void exit(Map<String, Object> map, Object obj);

}
