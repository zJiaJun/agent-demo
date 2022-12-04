package com.github.akwei.agentdemo.agent2.test;

import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujiajun
 * @version 1.0
 * @since 2022/12/4 14:29
 */
public class TestActionImpl implements TestAction {

    @Override
    public Map<String, Object> enter(Object obj) {
        //agent custom class loader
        System.out.println("test action enter class loader: " + this.getClass().getClassLoader());
        System.out.println("test action enter obj utils is empty " + ObjectUtils.isEmpty(obj));
        Map<String, Object> map = new HashMap<>();
        map.put("beginTime", System.currentTimeMillis() - 2000);
        ((TestFieldAccessor) obj).setValue(map);
        Object result;
        try {
            Method newMethod = obj.getClass().getDeclaredMethod("newMethod", String.class, Long.class, Boolean.class);
            newMethod.setAccessible(true);
            result = newMethod.invoke(obj, "s1", 10L, true);
            map.put("result", result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public void exit(Map<String, Object> map, Object obj) {
        System.out.println("test action exit class loader: " + this.getClass().getClassLoader());
        System.out.println("test action exit obj utils is empty " + ObjectUtils.isEmpty(obj));
        Map<String, Object> value = (Map<String, Object>) ((TestFieldAccessor) obj).getValue();
        long beginTimeByFieldAccessor = (long) value.get("beginTime");
        long beginTime = (long) map.get("beginTime");
        System.out.println("beginTime(field accessor)=" + beginTimeByFieldAccessor
                + ",beginTime(return map get value)=" + beginTime
                + ", equals " + (beginTimeByFieldAccessor == beginTime));
        System.out.println(map.get("result"));
        long duration = System.currentTimeMillis() - beginTime;
        System.out.println("test advice exit duration " + duration + "ms");
    }
}
