package 注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Retention(RetentionPolicy.SOURCE) // 注解保留到源码文件中，编译后消失
//@Retention(RetentionPolicy.CLASS) // 注解保留到编译class文件中
@Retention(RetentionPolicy.RUNTIME) // 注解保留到运行时
public @interface First {
}
