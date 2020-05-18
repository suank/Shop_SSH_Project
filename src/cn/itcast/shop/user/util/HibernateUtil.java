package cn.itcast.shop.user.util;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {
    
	public static Session getSession() {
		ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session session = sf.openSession();	
        return session;
	}
	
	
}
