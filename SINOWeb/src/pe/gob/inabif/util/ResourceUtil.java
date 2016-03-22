package pe.gob.inabif.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceUtil {
	
	public String getProperty(String clave) throws Exception {
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);
		try {
			prop.load(input);
			return prop.getProperty(clave);
		} catch (IOException e) {
			throw new Exception(e);
		}
	}
}
