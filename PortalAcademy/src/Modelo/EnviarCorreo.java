package Modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreo {

	private static String correo_gmail = "portalacademyadm";
	private static String contrasena_gmail = "aJ#1uYOiFCFt";

	public static void enviarGmailUnico(String destinatario, String asunto, String cuerpo) {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", correo_gmail);
		props.put("mail.smtp.clave", contrasena_gmail);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props);
		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			mimeMessage.setFrom(new InternetAddress(correo_gmail));
			mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			mimeMessage.setSubject(asunto);
			mimeMessage.setText(cuerpo);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", correo_gmail, contrasena_gmail);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			throw new ErrorBD("Error al enviar el correo. " + e.getMessage());
		}
	}

}
