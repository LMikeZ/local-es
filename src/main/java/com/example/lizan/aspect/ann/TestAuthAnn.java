package com.example.lizan.aspect.ann;

import java.lang.annotation.*;

/**
 * @author lizan
 * @version $Id: TestAuthAnn.java, v 0.1 2022年10月18日 17:51 lizan Exp $$
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TestAuthAnn {
    String value() default "";
}