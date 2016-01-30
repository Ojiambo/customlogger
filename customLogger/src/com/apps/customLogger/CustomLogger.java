package com.apps.customLogger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CustomLogger extends Logger {

	
	  static String FQCN = CustomLogger.class.getName() + ".";
	  
	  private static String Error_Prefix = "E"; 
	  
	  private static long WS_Error = 100000;
	  private static long MW_Error = 200000;
	  private static long UE_Error = 300000;
	  
	  // It's enough to instantiate a factory once and for all.
	  private static CustomLoggerFactory factory = new CustomLoggerFactory();

	  /**
	     Just calls the parent constuctor.
	   */
	  public CustomLogger(String name) {
	    super(name);
	  }

	  /**
	     Overrides the standard debug method by appending " world" at the
	     end of each message.  */
	  public 
	  void debug(Object message) {
	    super.log(FQCN, Level.DEBUG, message, null);    
	  }

	  /**
	     This method overrides {@link Logger#getLogger} by supplying
	     its own factory type as a parameter.
	  */
	  public 
	  static
	  Logger getLogger(String name) {
	    return Logger.getLogger(name, factory); 
	  }

	  public
	  void trace(Object message, XLevel level) {
	    super.log(FQCN, XLevel.TRACE, message, null); 
	  }
	  
	  public
	  void lethal(Object message, XLevel level) {
	    super.log(FQCN, XLevel.LETHAL, message, null); 
	  }
	
/*	  public
	  void trace(Object message) {
		  
	    super.log( XLevel.TRACE, message);
	    
	  }*/

}
