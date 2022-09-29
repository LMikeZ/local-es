package com.example.lizan.util;


import cn.hutool.json.JSONUtil;
import com.example.lizan.repository.model.TestUser;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ConvertUtils {


    /**
     * 比较两个类，将源类里面的值赋值到目标类中，如果目标类中该属性有值则不变，没有值则赋上源类里面属性相同的值
     *
     * @param target 目标类
     * @param source 源类
     */
    public static void classConvert(Object target, Object source) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Map<String, Field> targetFieldMap = mapAllField(target.getClass());
        Map<String, Field> sourceFieldMap = mapAllField(source.getClass());
        try {
            for (Map.Entry<String, Field> targetEntry : targetFieldMap.entrySet()) {
                Field targetField = targetEntry.getValue();
                ReflectionUtils.makeAccessible(targetField);

                if (targetField.get(target) == null) {
                    Field sourceField = sourceFieldMap.get(targetEntry.getKey());
                    ReflectionUtils.makeAccessible(sourceField);
                    Object sourceFieldValue = sourceField.get(source);
                    if (sourceFieldValue != null) {
                        targetField.set(target, sourceFieldValue);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Field> mapAllField(Class<?> clazz) {
        Map<String, Field> result = new HashMap<>();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {//向上循环 遍历父类
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isTransient(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                result.put(field.getName(), field);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TestUser user = new TestUser();
        user.setName("刘书豪");
        user.setPassword("1234567");
        TestUser user2 = new TestUser();
        user2.setName("刘书豪");
        user2.setSex("女");
        user2.setPassword("12345");
        classConvert(user, user2);
        System.out.println(JSONUtil.parseObj(user));
    }


}














