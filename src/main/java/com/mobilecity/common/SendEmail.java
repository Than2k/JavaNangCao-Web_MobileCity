package com.mobilecity.common;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	/**
	 * tạo thông tin và gửi email
	 * @param fromEmail
	 * @param ma
	 * @param tenNguoiNhan
	 */
	public static void send( String fromEmail,String ma, String tenNguoiNhan) {
		final String username = "19T1021237@husc.edu.vn";
        final String password = "qofwocbszkybflyn";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(fromEmail)
            );
            
            message.setSubject("Đặt lại mật khẩu cho tài khoản của bạn!!");// set title email
            message.setText("xin chào " +  tenNguoiNhan + "\n" + "mã xác thực cho tài khoản của bạn là: " + ma
    				+ "\n" + "bạn không được cung cấp mã này cho bất kì ai để tránh mất tài khoản");// set nội dung

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	public static long timeVerifyCode(LocalTime timeSend) {
		LocalTime timeNow = java.time.LocalTime.now();// lấy thời gian hiện tại
		long timeMilis = timeNow.getLong(ChronoField.MILLI_OF_DAY)
				- timeSend.getLong(ChronoField.MILLI_OF_DAY);
		return timeMilis/1000;
	}

	
}
