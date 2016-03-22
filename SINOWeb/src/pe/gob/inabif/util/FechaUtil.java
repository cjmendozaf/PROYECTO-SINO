package pe.gob.inabif.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class FechaUtil {

    private static final SimpleDateFormat DATE_SHORT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat DATE_LONG = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private static final SimpleDateFormat DATE_LONG_YYYY = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    private FechaUtil() {
    	
    } static String obtenerFechaFormatoCompleto(Date fecha) {
        return DATE_LONG.format(fecha);
    }
    
    public static Date obtenerFechaFormatoYYYYHH(String fecha) throws ParseException {
    	if(fecha == null || fecha.isEmpty()){
    		return null;
    	}
    	return DATE_LONG_YYYY.parse(fecha);
    }
    
    public static String obtenerFechaFormatoPersonalizado(Date fecha,
            String formato) {
        return new SimpleDateFormat(formato).format(fecha);
    }
   
    public static String obtenerFechaFormatoSimple(Date fecha) {
        return DATE_SHORT.format(fecha);
    }
    
    public static Date obtenerFechaFormatoCompleto(String fecha)
            throws ParseException {
        return DATE_LONG.parse(fecha);
    }
    
    public static Date obtenerFecha(String fecha) throws ParseException {
        return DATE_SHORT.parse(fecha);
    }
   
    public static Date obtenerFechaFormatoPersonalizado(String fecha,
            String formato) throws ParseException {
        return new SimpleDateFormat(formato).parse(fecha);
    }
  
    public static Date obtenerFechaActual() {
        return new Date();
    }

    public static String obtenerFechaEnvio(String fecha, String hora) {
    	String f1 = fecha.substring(8, 10);
    	String f2 = fecha.substring(5, 7);
    	String f3 = fecha.substring(0, 4);
        return f3.concat("-").concat(f2).concat("-").concat(f1).concat("T").concat(hora).concat(":00");
    }
    
    public static String getFecha(String fecha) {
    	if(fecha != null){
    		String[] valor = fecha.split("T");
    		return valor[0];
    	}
    	return "";
    }
    
    public static String getHora(String fecha) {
    	if(fecha != null){
    		String[] valor = fecha.split("T");
    		return valor[1];
    	}
    	return "";
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    	
    public static Date obtenerPrimerDiaDelMesMasMes(Integer meses) {  
    	Calendar cal = null;  
    	
    	cal = Calendar.getInstance();
    	
    	cal.add(Calendar.MONTH, meses);

    	cal.set(cal.get(Calendar.YEAR),   
    	cal.get(Calendar.MONTH),  
    	cal.getActualMinimum(Calendar.DAY_OF_MONTH),  
    	cal.getMinimum(Calendar.HOUR_OF_DAY),  
    	cal.getMinimum(Calendar.MINUTE),  
    	cal.getMinimum(Calendar.SECOND));  

    	return cal.getTime();  
    }  
    
    public static Date obtenerUltimoDiaDelMesMasMes(Integer meses) {  
    	Calendar cal = null;  
    	
    	cal = Calendar.getInstance();
    	
    	cal.add(Calendar.MONTH, meses);

    	cal.set(cal.get(Calendar.YEAR),  
    	cal.get(Calendar.MONTH),  
    	cal.getActualMaximum(Calendar.DAY_OF_MONTH),  
    	cal.getMaximum(Calendar.HOUR_OF_DAY),  
    	cal.getMaximum(Calendar.MINUTE),  
    	cal.getMaximum(Calendar.SECOND));  
    
    	return cal.getTime();  
    } 
}
