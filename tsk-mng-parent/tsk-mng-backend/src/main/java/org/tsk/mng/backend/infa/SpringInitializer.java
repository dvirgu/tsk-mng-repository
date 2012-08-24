package org.tsk.mng.backend.infa;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tsk.mng.backend.config.Consts;



public class SpringInitializer {

	private static AbstractApplicationContext beanFactory = null;
	
	public static AbstractApplicationContext getBeanFactory(){
		return getBeanFactory(null);
	}
	
	public static AbstractApplicationContext getBeanFactory(String springLoaderFileName){
		try{
			if(beanFactory != null){
//				Object beanFactoryLivelihoodTester = beanFactory.getBean("beanFactoryLivelihoodTester");TODO is suppose to be like that DVIR To ANAR 
			}
			else{
				String springLoaderFileNameFixed = springLoaderFileName;
				if((springLoaderFileNameFixed == null) || (springLoaderFileNameFixed.length() == 0)){
					springLoaderFileNameFixed = Consts.SPRING_FOLDER_PATH +  "/" + "spring/spring.xml";
					//springLoaderFileNameFixed =  "../spring/spring.xml"; FIXME SpringInitilizer
				}
				String springLoaderPathFile = springLoaderFileNameFixed;
				beanFactory = new ClassPathXmlApplicationContext(springLoaderPathFile);
				//beanFactory = new FileSystemXmlApplicationContext(springLoaderPathFile); FIXME SpringInitilizer
			}
		} catch (Exception e) {
			System.out.println("Error getting beanFactory. Message: " + e.getMessage());
		}
		
		return beanFactory; // FIXME case of npe
	}
	
	/**
	 * Generic method that gets the class of wanted bean and returns the instance of that bean 
	 * @author anara  
	 * @param beanClass - class type of the wanted bean
	 * @return instance of the wanted bean
	 */
	public static <T> T getBean(Class<T> beanClass){
			
		T bean = getBeanFactory().getBean(beanClass.getSimpleName(), beanClass);
		
		return bean;
	}
}
