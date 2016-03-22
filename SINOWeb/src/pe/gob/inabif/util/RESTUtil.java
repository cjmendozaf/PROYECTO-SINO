package pe.gob.inabif.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class RESTUtil {

	public enum MetodoEnvio {
		GET, POST, UPDATE, DELETE, PUT
	}

	public static String conectaRest(String urlRest, MetodoEnvio metodo, String datosJson) throws Exception {

		String respuesta = null;
		HttpURLConnection conexionJson = null;
		BufferedReader lectorBuffer = null;
		OutputStream flujoSalida = null;
		URL urlBE;

		try {
			urlBE = new URL(urlRest);
			conexionJson = (HttpURLConnection) urlBE.openConnection();
			conexionJson.setRequestMethod(metodo.toString());
			conexionJson.setDoOutput(true);
			conexionJson.setRequestProperty("Content-Type", "application/json");

			flujoSalida = conexionJson.getOutputStream();
			
			flujoSalida.write(datosJson.getBytes(Constantes.CODIFICACION_DEFECTO));
			flujoSalida.flush();

			int codigoRespuesta = conexionJson.getResponseCode();
			if (codigoRespuesta == 403) {
				throw new Exception(urlRest);
			}

			Charset charset = Charset.forName(Constantes.CODIFICACION_DEFECTO);
			lectorBuffer = new BufferedReader(new InputStreamReader(conexionJson.getInputStream(), charset));
			StringBuilder datoSalida = new StringBuilder();
			String output;
			while ((output = lectorBuffer.readLine()) != null) {
				datoSalida.append(output);
			}
			respuesta = datoSalida.toString();

		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (lectorBuffer != null) {
					lectorBuffer.close();
				}
				if (flujoSalida != null) {
					flujoSalida.close();
				}
				if (conexionJson != null) {
					conexionJson.disconnect();
				}
			} catch (IOException e) {
				throw e;
			}
		}

		return respuesta;
	}

}
