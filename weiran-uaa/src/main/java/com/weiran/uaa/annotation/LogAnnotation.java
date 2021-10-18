package com.weiran.uaa.annotation;

import java.lang.annotation.*;

/**
 * @ClassName LogAnnotation.java
 * @Description 自定义的、关于登陆日志的切点注释
 */
@Target({ElementType.METHOD}) // 单参数,标识运用到方法上
@Retention(RetentionPolicy.RUNTIME) //运行级别保存，编译后class文件中存在
@Documented //指明修饰的注解，可以被例如javadoc此类的工具文档化，只负责标记，没有成员取值。
public @interface LogAnnotation {

}
