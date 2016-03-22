package pe.gob.inabif.service.impl;

import java.text.ParseException;
import java.util.Date;

import pe.gob.inabif.util.FechaUtil;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fecha = "12/01/2016";
		String hora = "12:12";
		
		try {
			Date fechaFinal = FechaUtil.obtenerFechaFormatoYYYYHH(fecha.concat(" "+hora.concat(":00")));
			System.out.println(fechaFinal);
			
			
			
			
			String valor = "xxx/";
			valor = valor.concat("jorge/");
			
			System.out.println(valor);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
