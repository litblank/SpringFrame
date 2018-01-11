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

@Target(ElementType.FIELD)  //������
@Retention(RetentionPolicy.RUNTIME) //����ʱЧ
@Documented  
@Inherited //�̳�ע��
public @interface IsEmptyAnnotation {
	
	public boolean isEmpty() default true;
	
	public String message() default "�ֶβ���Ϊ��";
}
