package cn.itcast.shop.user.service;

import java.util.HashSet;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.pojo.User;
import cn.itcast.shop.util.EmailUtil;
import cn.itcast.shop.util.UuidUtil;
//@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findByName(String username) {

		System.out.println("+++username++"+username);

		return userDao.findByName(username);
	}

	public void save(User user) throws AddressException, MessagingException {
		//1.将数据插入数据库
		//用户入库的时候 设置用户状态：0用户未激活，1用户已激活
		user.setState(0); 
		//随机生成的UUID作为用户激活码
		String code = UuidUtil.getUUID();
		user.setCode(code);
		userDao.save(user);
		//2.往用户邮箱发送激活邮件
		EmailUtil.sendEmail(user.getEmail(),code);
	}

	//根据用户激活码查询用户
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}


	//
	public void updateUser(User existUser) {
		userDao.updateUser(existUser);
	}

	//登录
	public User login(User user) {
		return userDao.login(user);
	}
}
