package core.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 
 * @author chenyd
 *
 */
public class AnnotationDealUtil {
	 private static Logger log = Logger.getAnonymousLogger();  
	 
	  @SuppressWarnings("unchecked")  
	    public static Map<String, Object> validate(Object bean) {  
	        Map<String, Object> result = new HashMap<String, Object>();  
	        result.put("message", "��֤ͨ��");  
	        result.put("result", true);  
	        Class<?> cls = bean.getClass();  
	          
	        // ���field�Ƿ����  
	        try {  
	            // ��ȡʵ���ֶμ���  
	            Field[] fields = cls.getDeclaredFields();  
	            for (Field f : fields) {  
	                // ͨ�������ȡ�����Զ�Ӧ��ֵ  
	                f.setAccessible(true);  
	                // ��ȡ�ֶ�ֵ  
	                Object value = f.get(bean);  
	                // ��ȡ�ֶ��ϵ�ע�⼯��  
	                Annotation[] arrayAno = f.getAnnotations();  
	                for (Annotation annotation : arrayAno) {  
	                    // ��ȡע�����ͣ�ע�����Class��  
	                    Class<?> clazz = annotation.annotationType();  
	                    // ��ȡע�����еķ�������  
	                    Method[] methodArray = clazz.getDeclaredMethods();  
	                    for (Method method : methodArray) {  
	                        // ��ȡ������  
	                        String methodName = method.getName();  
	                        // ���˴�����ʾ�����ĵ���  
	                        if(methodName.equals("message")) {  
	                            continue;  
	                        }  
	                        // ��ʼ��ע����֤�ķ��������� ���ҵĴ�����ж�ر����У�  
	                        Object obj = AnnotationDealUtil.class.newInstance();  
	                        // ��ȡ����  
	                        try {  
	                            // ���ݷ�������ȡ�÷���  
	                            Method m = obj.getClass().getDeclaredMethod(methodName, Object.class, Field.class);  
	                            // ���ø÷���  
	                            result = (Map<String, Object>)m.invoke(obj, value, f);  
	                            /* ��֤��� ��һ��ʧ�����˳� */  
	                            if(result.get("result").equals(false)) {  
	                                return result;  
	                            }  
	                        } catch (Exception e) {  
	                            e.printStackTrace();  
	                            log.info("�Ҳ����÷���:"+methodName);  
	                        }  
	                    }  
	                }  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            log.info("��֤����");  
	        }  
	        return result;  
	    }  
	
	public Map<String, Object> isEmpty(Object value, Field field) {  
        Map<String, Object> validateResult = new HashMap<String, Object>();  
        IsEmptyAnnotation annotation = field.getAnnotation(IsEmptyAnnotation.class);  
        if(value == null || value.equals("")) {  
            validateResult.put("message", field.getName() + annotation.message());  
            validateResult.put("result", false);  
        } else {  
            validateResult.put("message", "��֤ͨ��");  
            validateResult.put("result", true);  
        }  
        return validateResult;  
    }  
}
