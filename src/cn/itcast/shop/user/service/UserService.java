package cn.itcast.shop.user.service;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.pojo.User;
import cn.itcast.shop.util.EmailUtil;
import cn.itcast.shop.util.PageBean;
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
	// 业务层用户查询所有
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<User> list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}


	public void delete(User existUser) {
		userDao.delete(existUser);
	}
}
