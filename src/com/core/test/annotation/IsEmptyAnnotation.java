package core.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @author chenyd
 *
 */

@Target(ElementType.FIELD)  //作用域
@Retention(RetentionPolicy.RUNTIME) //运行时效
@Documented  
@Inherited //继承注解
public @interface IsEmptyAnnotation {
	
	public boolean isEmpty() default true;
	
	public String message() default "字段不能为空";
}
