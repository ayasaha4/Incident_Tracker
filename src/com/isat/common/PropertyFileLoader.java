package com.isat.common;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyFileLoader {

	private static final Logger logger = Logger.getLogger(PropertyFileLoader.class);
	public String attribute;

	protected String loadProperty(String attribute) throws IOException {
		this.attribute = attribute;
		Properties prop = new Properties();

		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("/WebContent/resources/properties/dashboard.properties");

			prop.load(stream);
		} catch (Exception ex) {
			logger.debug("Unable to Find The Properties File", ex);
		}

		return prop.getProperty(attribute);
		// return getResourceBundle().getString(attribute.toString());
	}


	public static void main(String args[]) {
		PropertyFileLoader load = new PropertyFileLoader();
		try {
			load.loadProperty("error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
