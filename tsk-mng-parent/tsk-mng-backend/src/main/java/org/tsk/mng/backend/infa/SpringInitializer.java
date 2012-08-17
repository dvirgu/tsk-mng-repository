package org.tsk.mng.backend.infa;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.tsk.mng.backend.config.Consts;



public class SpringInitializer {

	private static AbstractApplicationContext beanFactory = null;
	
	public static AbstractApplicationContext getBeanFactory(){
		return getBeanFactory(null);
	}
	
	public static AbstractApplicationContext getBeanFactory(String springLoaderFileName){
		try{
			if(beanFactory != null){
				Object beanFactoryLivelihoodTester = beanFactory.getBean("beanFactoryLivelihoodTester"); 
			}
			else{
				String springLoaderFileNameFixed = springLoaderFileName;
				if((springLoaderFileNameFixed == null) || (springLoaderFileNameFixed.length() == 0)){
					springLoaderFileNameFixed = Consts.SPRING_FOLDER_PATH +  "/" + "spring/spring.xml";
				}
				String springLoaderPathFile = springLoaderFileNameFixed;
				beanFactory = new FileSystemXmlApplicationContext(springLoaderPathFile);
			}
		} catch (Exception e) {
			System.out.println("Error getting beanFactory. Message: " + e.getMessage());
		}
		
		return beanFactory;
	}
}
