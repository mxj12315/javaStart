package 注解;

import java.lang.annotation.Inherited;

@Inherited  // 被修饰的注解可以被继承
public @interface Third {
    int value(); // 使用时可以省略value
}
