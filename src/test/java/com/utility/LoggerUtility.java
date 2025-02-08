package com.utility;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	private Logger logger;//here we are not  static because every class should access and have there own logs
	//Ex: with static it will only print Class name if declare logs in other class in logs its shows only the main class name 
	//if we want to see the logs were we declare in particular class with name we need to decelerate as static in logger. 
	//private static Logger logger;
	
	private LoggerUtility() {
		
	}
	
	public static Logger getLogger(Class<?> clazz) {
		//Class<?>:- is a generic type in Java
		//The <?> is a wildcard that means "any type." In this case, it indicates that the method can accept any class type.
        //The parameter clazz holds a reference to the class object.
		Logger logger = null;//we declare because each logs have different logs phase in parallel testing
		if(logger ==null) {//Object will be created inside the class with the help of getlogger.
			logger=LogManager.getLogger(clazz);
			
		}
		return logger;
	}

}
