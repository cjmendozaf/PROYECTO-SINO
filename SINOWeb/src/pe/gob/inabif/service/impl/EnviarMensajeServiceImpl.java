package pe.gob.inabif.service.impl;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pe.gob.inabif.seguridad.ServiceContext;
import pe.gob.inabif.service.EnviarMensajeService;
import pe.gob.inabif.util.ConfigMail;
import pe.gob.inabif.util.Constantes;

@Scope("singleton")
@Service
public class EnviarMensajeServiceImpl implements EnviarMensajeService {

	private static Logger log = LogManager
			.getLogger(EnviarMensajeServiceImpl.class.getName());
	

	public void sendMail(String from, String to, String subject, String msg,
			String cc) throws Exception {
		
		try {
			Properties prop = new Properties();
			InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_CONFIG);
			prop.load(input);

			String host = prop.getProperty(Constantes.HOST);
			int port = Integer.parseInt(prop.getProperty(Constantes.PORT));
			String user = prop.getProperty(Constantes.USER);
			String password = prop.getProperty(Constantes.PASSWORD);


			ConfigMail config = new ConfigMail();
			Session session = config.getOpenConection(host, port, user);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(from));
			message.setSubject(subject);
			message.setText(msg);
			
			config.sendMail(session, user, password, message);
			
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public void sendMailMasivo(String from, String to[], String subject,
			String msg, String cc[]) throws Exception {

	}

	public void sendMailAdjuntar(String from, String to[], String subject,
			String msg, String cc[], String greeting, String content,
			String nombreArchivo) throws Exception {

	}
}