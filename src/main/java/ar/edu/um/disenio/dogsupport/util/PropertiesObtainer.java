package ar.edu.um.disenio.dogsupport.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesObtainer {
	private static PropertiesObtainer INSTANCE;
	private Properties properties;
	
	private PropertiesObtainer(){
		properties = new Properties();
		InputStream in = PropertiesObtainer.class.getClassLoader().getResourceAsStream("basededatos.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static PropertiesObtainer getInstance(){
		if (INSTANCE != null) {
			return INSTANCE;
		}
		return INSTANCE = new PropertiesObtainer();
	}
	
	public String getPropiedad(String clave) {
		return properties.getProperty(clave);
	}
}
