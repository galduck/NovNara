package novNara;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {

	private static class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("jspstudy2", "jspstudy2001");
		}
	}
	
	public static void send(String title, String content, String toEmail) {
		Properties p = new Properties();

		p.put("mail.smtp.starttls.enable", "true");
		// �̸��� �߼��� ó������ SMTP����
		p.put("mail.smtp.host", "smtp.gmail.com");
		// SMTP ������ ������ ����Ѵٴ� �ǹ�
		p.put("mail.smtp.auth", "true");
		// TLS�� ��Ʈ��ȣ�� 587�̸� SSL�� ��Ʈ��ȣ�� 465�̴�.
		p.put("mail.smtp.port", "587");
		// soket������ protocol���� �ذ�
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(p, auth);
			session.setDebug(true); 
			MimeMessage msg = new MimeMessage(session);
			String message = content;
			msg.setSubject(title);
			Address fromAddr = new InternetAddress("jspstudy2@gmail.com"); 
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(toEmail); 
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(message, "text/html;charset=KSC5601");
			Transport.send(msg);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}











