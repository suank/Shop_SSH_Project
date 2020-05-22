package cn.itcast.shop.user.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.user.pojo.User;
public class DaoTest {
		
	
	@Test
	public void test(){
		ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		Session session = sf.openSession();	
		System.out.println("*"+session);
	 Object object = session.get(User.class, 7);
		System.out.println("object   "+object);

	}
}
