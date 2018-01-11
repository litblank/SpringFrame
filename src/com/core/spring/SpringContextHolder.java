package core.spring;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.
 * 
 */
public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext; // NOSONAR
	}
	
	
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}
	
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> className) {
		checkApplicationContext();
		return (T) applicationContext.getBean(className);
	}
	
	/**
	 * 清除applicationContext静态变量.
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}
	
	
	

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}
	
	/** 
     * 功能说明：动态添加bean到springbeanFactory
     * @param acf 
     * @param mapCustom 
     */  
    public static void addBeanToSpringBeanFactory(Class<?> classType,String beanName) { 
    	ConfigurableApplicationContext cfa = (ConfigurableApplicationContext)SpringContextHolder.getApplicationContext();
        
    	//获取spring beanFactory
    	DefaultListableBeanFactory acf = (DefaultListableBeanFactory) cfa.getBeanFactory();
            
        // 注意：必须先注册到容器中，再得到Bean进行修改，否则数据源属性不能有效修改  
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder  
                     .genericBeanDefinition(classType); 
            
        //注册bean到Factory
        acf.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());  
    	
    }  
    
    /** 
     * 功能说明：动态移除bean 
     * @param acf 
     * @param mapCustom 
     */  
    public static void removeBeanFromSpringBeanFactory(String beanName) { 
    	ConfigurableApplicationContext cfa = (ConfigurableApplicationContext)SpringContextHolder.getApplicationContext();
        
    	//获取spring beanFactory
    	DefaultListableBeanFactory acf = (DefaultListableBeanFactory) cfa.getBeanFactory();
    	
    	//移除bean从beanFactory
    	acf.removeBeanDefinition(beanName);
    }  
	
	
}
