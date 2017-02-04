/**
 * This is a utility class for sending
 * emails
 * 
 * @version: v.1.0 - 10 mag 2016 19:10:58 
 * @author:  Marco Canavese
 */
package com.kirth.util;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail
{

	FileInputStream fin;
	Properties prop = new Properties();
	public String mail_from = "", mail_pwd = "";
	public String host = "";
	public String port = "";
	public String authtype = "";
	public String key = "";
	public String socketFactory = "";

	public SendMail()
	{
		try
		{
			ResourceBundle rb2 = ResourceBundle.getBundle("com.kirth.util\\mail-config");

			mail_from = rb2.getString("mail-from");
			// System.out.println("Mail Sender :" + mail_from);

			mail_pwd = rb2.getString("mail-pwd");
			// System.out.println("Sender Password: " + mail_pwd);

			host = rb2.getString("host");
			// System.out.println("Host name: " + host);

			port = rb2.getString("port");
			// System.out.println("port: " + port);

			authtype = rb2.getString("authtype");
			// System.out.println("authtype is :" + authtype);

			key = rb2.getString("key");
			// System.out.println("key :" + key);

			socketFactory = rb2.getString("socketfactoryclass");

		} catch (Exception e)
		{
			System.out.println("Exception occured at SendMail constructor " + e);

		}
	}

	/**
	 * This method sends the email
	 * 
	 * @param to
	 * @param cc
	 * @param subject
	 * @param content
	 * @param attachment
	 * @return true if the mail is siccessfully sent, false otherwise
	 * @throws Exception
	 */
	public boolean sendMail(String to, String[] cc, String subject, String content,
			String attachment) throws Exception
	{
		// System.out.println("Inside sendMail block");

		boolean sent = true;

		try
		{
			Properties props = new Properties();

			props.put("mail.smtp.auth", authtype);
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.class", socketFactory);

			Authenticator auth = new SMTPAuthenticator();

			Session session = Session.getInstance(props, auth);

			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mail_from));

			InternetAddress[] toAddress = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, toAddress);

			msg.setSubject(subject);

			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(content);

			// create the second message part
			MimeBodyPart mbp2 = new MimeBodyPart();

			// attach the file to the message
			if (attachment != null)
			{
				FileDataSource fds = new FileDataSource(attachment);
				mbp2.setDataHandler(new DataHandler(fds));
				mbp2.setFileName(fds.getName());
			}

			// create the Multipart and add its parts to it

			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			if (attachment != null)
			{
				mp.addBodyPart(mbp2);
			}

			// add the Multipart to the message
			msg.setContent(mp);
			// set the Date: header
			msg.setSentDate(new Date());

			// send the message

			Transport.send(msg);
			System.out.println("Mail sent sucessfully. Check your inbox.");

		} catch (Exception e)
		{
			sent = false;
			throw new Exception("Exception occured at SendMail " + e);
		}
		return sent;

	}

	/**
	 * This mehtod send the email
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

	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

		@Override
		public PasswordAuthentication getPasswordAuthentication()
		{

			return new PasswordAuthentication(mail_from, mail_pwd);
		}
	}
}