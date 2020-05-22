package cn.itcast.shop.util;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;


//this.getHibernateTemplate().execute(new HibernateCallback<T>);
// 实现HibernateCallback 复杂SQL操作就不需要实现匿名内部类

public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
	
	//要执行的HQL
	private String hql;
	
	//HQL中的参数
	private Object[] params;
	
	//分页起始位置
	private int startIndex;
	
	//分页大小
	private int pageSize;
	

	
	
	public PageHibernateCallback(String hql, Object[] params,
			int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}


	
	//封装基于Session的分页查询
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		
		//1 执行hql语句
		Query query = session.createQuery(hql);
		
		//2 遍历参数数组，设置参数
		if(params != null){
			for(int i = 0 ; i < params.length ; i ++){
				query.setParameter(i, params[i]);
			}
		}
		
		//3 分页
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

}
