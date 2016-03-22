package pe.gob.inabif.util;

import com.google.gson.Gson;

public class GsonUtil {
	public static String toJson(Object objeto) throws Exception {
		Gson gson = null;
		gson = new Gson();
		return gson.toJson(objeto);
	}
}
