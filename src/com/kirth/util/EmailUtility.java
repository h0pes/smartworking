/**
 * This class is an utility class and contains
 * a static method to send email with the 
 * JavaMail API
 * 
 * @version: v.1.0 - 04 mag 2016 15:04:12 
 * @author:  Marco Canavese
 */
package com.kirth.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility
{

	/**
	 * This method allows sending email using JavaMail API.
	 * 
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
	 * @param toAddress
	 * @param subject
	 * @param message
	 * @param date
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendEmail(String host, String port, final String userName,
			final String password, String toAddress, String subject, String message, String date)
			throws AddressException, MessagingException
	{

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator()
		{
			public PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

	}
}
