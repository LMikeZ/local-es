package com.example.lizan.util;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author Alaske
 * @version 1.0.0
 * @createDate 2022-07-01 13:49
 * @Description
 */
@FunctionalInterface
public interface SFunction<T, R> extends Function<T, R>, Serializable {
}
