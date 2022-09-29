package com.example.lizan.util;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.lizan.util.change.*;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class ChangeBefAftUtil {



    public static JSONArray changeJsonArray(JSONArray beforeArray, JSONArray afterArray, Object obj) throws Exception {
        if (CollectionUtils.isEmpty(beforeArray) && CollectionUtils.isEmpty(afterArray)) {
            return null;
        }
        JSONArray result = new JSONArray();
        if (CollectionUtils.isEmpty(afterArray)) {
            for (Object beforeObject : beforeArray) {
                Map<String, Object> changeBefAft = changeBefAft(JSONUtil.toBean((JSONObject) beforeObject, obj.getClass()), obj.getClass().newInstance());
                result.add(JSONUtil.parse(changeBefAft));
            }
            return result;
        }

        if (CollectionUtils.isEmpty(beforeArray)) {
            for (Object afterObject : afterArray) {
                Map<String, Object> changeBefAft = changeBefAft(obj.getClass().newInstance(), JSONUtil.toBean((JSONObject) afterObject, obj.getClass()));
                result.add(JSONUtil.parse(changeBefAft));
            }
            return result;
        }

        Set<JSONObject> remainBeforeSet = new HashSet<>();
        beforeArray.forEach(before -> {
            JSONObject beforeJSONObject = (JSONObject) before;
            remainBeforeSet.add(beforeJSONObject);
        });
        Set<JSONObject> remainAfterSet = new HashSet<>();
        afterArray.forEach(after -> {
            JSONObject afterJSONObject = (JSONObject) after;
            remainAfterSet.add(afterJSONObject);
        });
        List<String> compareIds = getCompareIds(obj.getClass());
        for (Object beforeObject : beforeArray) {
            JSONObject beforeJSONObject = (JSONObject) beforeObject;
            for (Object afterObject : afterArray) {
                if (afterObject instanceof JSONObject) {
                    JSONObject afterJSONObject = (JSONObject) afterObject;
                    int count = 0;
                    for (String compareId : compareIds) {
                        if (beforeJSONObject.get(compareId).equals(afterJSONObject.get(compareId)) && beforeJSONObject.get(compareId) != null) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        Map<String, Object> changeBefAftMap = changeBefAft(JSONUtil.toBean(beforeJSONObject, obj.getClass()), JSONUtil.toBean(afterJSONObject, obj.getClass()));
                        result.add(JSONUtil.parse(changeBefAftMap));
                        remainBeforeSet.remove(beforeJSONObject);
                        remainAfterSet.remove(afterJSONObject);
                    }
                }
            }
        }

        if (remainBeforeSet.size() > 0) {
            for (JSONObject object : remainBeforeSet) {
                Map<String, Object> changeBefAft = changeBefAft(JSONUtil.toBean(object, obj.getClass()), obj.getClass().newInstance());
                result.add(JSONUtil.parse(changeBefAft));
            }
        }

        if (remainAfterSet.size() > 0) {
            for (JSONObject object : remainAfterSet) {
                Map<String, Object> changeBefAft = changeBefAft(obj.getClass().newInstance(), JSONUtil.toBean(object, obj.getClass()));
                result.add(JSONUtil.parse(changeBefAft));
            }
        }

        return result;
    }


    /**
     * 比较之前和之后的结果值
     *
     * @param before 比较之前的对象：如对象中存在除基本类型的对象外，该对象需要实现IChangeCompare接口，如果是list集合对象需要存在比较的字段加上对应注解和实现IChangeCompare接口
     * @param after  比较之后的对象
     * @return 比较前后的值
     */
    public static Map<String, Object> changeBefAft(Object before, Object after) throws Exception {
        if (before == null && after == null) {
            return null;
        }
        if (before == null && after != null) {
            before = after.getClass().newInstance();
        }
        if (before != null && after == null) {
            after = before.getClass().newInstance();
        }
        if (!before.getClass().equals(after.getClass())) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        // 获取所有的属性信息，包括父类
        List<Field> fieldsBef = getAllField(before.getClass());
        List<Field> fieldsAft = getAllField(after.getClass());
        for (Field fieldBef : fieldsBef) {
            if (!fieldBef.isAccessible()) {
                fieldBef.setAccessible(true);
            }
            for (Field fieldAft : fieldsAft) {
                if (!fieldAft.isAccessible()) {
                    fieldAft.setAccessible(true);
                }
                if (fieldBef.getName().equals(fieldAft.getName())) {
                    //忽略字段
                    if (fieldBef.isAnnotationPresent(LogIgnore.class)) {
                        continue;
                    }

                    if (fieldBef.get(before) == null && fieldAft.get(after) != null) {
                        if (fieldAft.get(after) instanceof List) {
                            List<Object> aftList = (List) fieldAft.get(after);
                            if (aftList.size() <= 0 || !(aftList.get(0) instanceof IChangeCompare)) {
                                continue;
                            }
                            JSONArray array = changeJsonArray(JSONUtil.parseArray("[]"), JSONUtil.parseArray(aftList), aftList.get(0));
                            result.put(fieldBef.getName(), array);
                            continue;
                        }
                        result.put(fieldBef.getName(), new BefAft("", fieldAft.get(after)));
                    }
                    if (fieldBef.get(before) != null && fieldAft.get(after) == null) {
                        if (fieldBef.get(before) instanceof List) {
                            List<Object> befList = (List) fieldBef.get(before);
                            if (befList.size() <= 0 || !(befList.get(0) instanceof IChangeCompare)) {
                                continue;
                            }
                            JSONArray array = changeJsonArray(JSONUtil.parseArray(befList), JSONUtil.parseArray("[]"), befList.get(0));
                            result.put(fieldBef.getName(), array);
                            continue;
                        }
                        result.put(fieldBef.getName(), new BefAft(fieldBef.get(before), ""));
                    }
                    if (fieldBef.get(before) != null && fieldAft.get(after) != null) {
                        if (fieldBef.get(before) instanceof List) {
                            List<Object> befList = (List) fieldBef.get(before);
                            List<Object> aftList = (List) fieldAft.get(after);
                            Object obj = null;
                            if (befList.size() > 0) {
                                obj = befList.get(0);
                            }
                            if (aftList.size() > 0) {
                                obj = aftList.get(0);
                            }
                            if (obj == null || !(obj instanceof IChangeCompare)) {
                                continue;
                            }
                            JSONArray array = changeJsonArray(JSONUtil.parseArray(befList), JSONUtil.parseArray(aftList), obj);
                            result.put(fieldBef.getName(), array);
                            continue;
                        } else if (fieldBef.get(before) instanceof IChangeCompare) {
                            Map<String, Object> objectChangeMap = changeBefAft(fieldBef.get(before), fieldAft.get(after));
                            result.put(fieldBef.getName(), objectChangeMap);
                            continue;
                        }
                        if (!fieldBef.get(before).equals(fieldAft.get(after))) {
                            result.put(fieldBef.getName(), new BefAft(fieldBef.get(before), fieldAft.get(after)));
                        } else {
                            //如果有这个注解表示的，保留一份
                            if (fieldBef.isAnnotationPresent(LogRetain.class)) {
                                result.put(fieldBef.getName(), new BefAft(fieldBef.get(before), fieldAft.get(after)));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<Field> getAllField(Class<?> clazz) {
        List<Field> result = new ArrayList<>();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {//向上循环 遍历父类
            Field[] field = clazz.getDeclaredFields();
            result.addAll(Arrays.asList(field));
        }
        return result;
    }

    public static List<String> getCompareIds(Class<?> clazz) {
        List<String> result = new ArrayList<>();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {//向上循环 遍历父类
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isTransient(field.getModifiers())
                        || Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                if (field.isAnnotationPresent(ListCompareId.class)) {
                    result.add(field.getName());
                }
            }
        }
        return result;
    }

}
