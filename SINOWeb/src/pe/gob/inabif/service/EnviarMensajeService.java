package pe.gob.inabif.service;


public interface EnviarMensajeService {
	
	public void sendMail(String from, String to, String subject, String msg,
			String cc) throws Exception;

	public void sendMailMasivo(String from, String to[], String subject,
			String msg, String cc[]) throws Exception;

	public void sendMailAdjuntar(String from, String to[], String subject,
			String msg, String cc[], String greeting, String content,
			String nombreArchivo) throws Exception;

}
