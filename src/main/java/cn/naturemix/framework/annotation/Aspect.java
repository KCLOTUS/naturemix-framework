package cn.naturemix.framework.annotation;

import java.lang.annotation.*;

/**
 * Action 切面注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
