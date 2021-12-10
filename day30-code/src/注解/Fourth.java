package 注解;

import java.lang.annotation.Repeatable;

@Repeatable(Fourths.class)  // 代表可以重复的  java9 中
public @interface Fourth {
    String name() default "";
}
// 注解容器，通常只有一个value属性
@interface Fourths  {
    // value属性可以是一个Fourth数组
    Fourth[] value();
}
