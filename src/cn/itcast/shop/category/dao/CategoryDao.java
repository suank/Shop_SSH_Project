package cn.itcast.shop.category.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.category.pojo.Category;
import cn.itcast.shop.product.pojo.Product;

public class CategoryDao extends HibernateDaoSupport{
	
	/**
	 *	查询一级分类 
	 * @return
	 *	@author Garfield
	 */
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String HQL = "From Category";
		List<Category> find = this.getHibernateTemplate().find(HQL);
		System.out.println("**find "+find );
		return find;
	}

	
}
