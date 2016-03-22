package pe.gob.inabif.util;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class ConfigMail {

	public Session getOpenConection(String host, int port, String user) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", host);
		//props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port", String.valueOf(port));
		props.setProperty("mail.smtp.user", user);
		props.setProperty("mail.smtp.auth", "true");

		props.put("mail.smtp.ssl.enable", "true");
		
		// Preparamos la sesion
		Session session = Session.getDefaultInstance(props);
		return session;
	}

	public void sendMail(Session session, String user, String password,
			MimeMessage message) throws Exception {
		Transport t = session.getTransport("smtp");
		t.connect(user, password);
		t.sendMessage(message, message.getAllRecipients());
		t.close();
	}

}
