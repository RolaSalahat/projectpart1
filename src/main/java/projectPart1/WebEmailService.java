package projectPart1; 
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.*; 
import java.util.logging.*;



public class WebEmailService {
	final static Logger logger =Logger.getLogger(FinderApp.class.getName());


	public void sendEmail(String email , List<Home> homesIn) { 
		String to = email;

	      String from = "hayasam@najah.edu";
	      final String username = "49675f460af668";
	      final String password = "8fe8ef0a6834b5";

	 
	      String host = "smtp.mailtrap.io";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      
	      props.put("mail.smtp.starttls.enable", "true"); 
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "2525");

	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	    }
	         });

	      try {
	    Message message = new MimeMessage(session);
	 
	    message.setFrom(new InternetAddress(from));
	 
	    message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
	 
	    message.setSubject("List of requierd homes");
	 
	    
	    String homeListString = "";
	    for(int i=0;i<homesIn.size();i++) {
       	 homeListString =  homesIn.get(i).toString()+ "\n";
        }
	    
	    message.setText( homeListString);

	    Transport.send(message);

	   logger.info("Sent message successfully....");

	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
		


	}
	}
