package com.example.lizan.util;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
/**
 * @author lizan
 * @version $Id: FieldUtils.java, v 0.1 2023年03月24日 14:23 lizan Exp $$
 */
public class FieldUtils {
    public FieldUtils() {
    }

    public static <T, R> String fnToFieldName(SFunction<T, R> fn) {
        try {
            Method method = fn.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            SerializedLambda serializedLambda = (SerializedLambda)method.invoke(fn);
            String fieldWithGet = serializedLambda.getImplMethodName();
            return fieldWithGet.startsWith("is") ? lowCaseFirst(fieldWithGet.substring(2)) : lowCaseFirst(fieldWithGet.substring(3));
        } catch (ReflectiveOperationException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static String lowCaseFirst(String value) {
        return value.substring(0, 1).toLowerCase().concat(value.substring(1));
    }
}
