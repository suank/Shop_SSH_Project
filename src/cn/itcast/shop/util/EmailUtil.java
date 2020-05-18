package cn.itcast.shop.util;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

public class EmailUtil {
	//发送邮件
	/**
	 * 
	 * @param to 邮件发给谁
	 * @param code 发给用户的激活码
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	//邮箱STMP账号（也就是邮箱本身）
	public static String myEmailAcc = "redlion1024@126.com";
	//邮件STMP授权码
	public static String myEmailOuth = "UEMBRBFJMYJGFYOY";
	//STM服务器地址（见126）
	public static String myEmailSMTPHost = "smtp.126.com";
	//收件人
	public static String reciver = "917976723@qq.com";
	
	public static void  sendEmail(String to ,String code) throws AddressException, MessagingException {
		//获取连接对象
		Properties props  =new Properties(); 
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props, new Authenticator() {
			//匿名内部类
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//用这个账号密码连接到邮箱服务器上
				return new PasswordAuthentication(myEmailAcc,myEmailOuth);
			}
			
		});
		
		//创建邮件对象
		Message message = new MimeMessage(session);
		
		//组织并发送邮件
		//设定发件人
		message.setFrom(new InternetAddress(myEmailAcc));
		//设定收件人
		//TO:发送  （主要针对人）   BC:抄送   BCC:匿名抄送密送
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//设定主题
		message.setSubject("激活邮件测试");
		//设定正文
		message.setContent("<h1>激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://localhost:8080/shop/user_active.action?code="+code+"'>http://192.168.0.105:8080/shop/user_active.action?code="+code+"</a></h3>","text/html;charset=UTF-8");
		
		//发送邮件
		Transport.send(message);
	}
	
	@Test
	public void testMail() throws AddressException, MessagingException {
		sendEmail(reciver,"11111");
	}
	
}
