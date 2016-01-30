package com.apps.customLogger;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class CustomLoggerFactory implements LoggerFactory {

	/**
	 * The constructor should be public as it will be called by configurators in
	 * different packages.
	 */
	public CustomLoggerFactory() {
	}

	@Override
	public Logger makeNewLoggerInstance(String name) {
		
		return new CustomLogger(name);
	}

}
