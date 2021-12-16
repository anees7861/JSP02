package servlet;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	String to;
	String subject;
	String text;
	
	public Email(String to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public void sendEmail() {
		
		try {
			
			System.out.println("=========mail===========");
			final String username = "yarabb7860@gmail.com";
			final String pass = "Mango911!";
			
			Properties props = new Properties();
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host","smtp.gmail.com");
			props.put("mail.smtp.port","587"); // giving information about the service used
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, pass);
				}
				
			}); // use this to log in on your email from eclipse
			
			
			// used to prepare message
			Message message = new MimeMessage(session);// create message on the current session
			message.setFrom(new InternetAddress(username)); // sets from
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));// sets to
			message.setSubject(subject);// sets subject
			message.setText(text);// set text
			
			Transport.send(message); // send the message
			
			System.out.println("done");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
