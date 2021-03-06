package cn.itcast.shop.user.dao;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.shop.user.pojo.User;
import cn.itcast.shop.util.PageHibernateCallback;
public class UserDao extends HibernateDaoSupport{

	//按用户名来查找用户
	public User findByName(String username) {
		System.out.println(" UserDao username "+username);
		
		String HQL = "FROM User where username = ? ";
		List<User> userList = this.getHibernateTemplate().find(HQL,username);
		System.out.println("***userList " +userList );
		if(userList!=null && userList.size() > 0){
			return userList.get(0);
		}
		
		return null;

	}

	
	//插入用户 并返回记录主键
	public void save(User user) {
		System.out.println(" UserDao user "+user);
		Serializable save = this.getHibernateTemplate().save(user);
		System.out.println(" save  user "+save);

	}


	public User findByCode(String code) {
		System.out.println(" UserDao code"+code);
		String HQL = "FROM User where code = ? ";
		List<User> userList = this.getHibernateTemplate().find(HQL,code);
		System.out.println("***userList " +userList );
		if(userList!=null && userList.size() > 0){
			return userList.get(0);
		}
		return null;
		
	}

	public void updateUser(User existUser) {
		System.out.println(" UserDao existUser"+existUser);
		this.getHibernateTemplate().update(existUser);
	}

	public User login(User user) {
		System.out.println(" UserDao user"+user);
		String HQL = "FROM User where username = ? and password = ? and state = ?";
		
		List<User> userList = this.getHibernateTemplate().find(HQL,user.getUsername(),user.getPassword(),1);
		System.out.println("***userList " +userList );
		if(userList!=null && userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<User> findByPage(int begin, int limit) {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}

	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

	public void delete(User existUser) {
		System.out.println(existUser);
		this.getHibernateTemplate().delete(existUser);
	}
}
