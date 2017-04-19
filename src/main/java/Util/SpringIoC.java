package Util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringIoC {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"/Ioc.xml"});
	public static <T> T classGetter(Class<T> target)
	{
		return context.getBean(target);
	}
	public static <T> T idGetter(String beanId, Class<T> classname)
	{
		return (T)context.getBean(beanId);
	}
}
