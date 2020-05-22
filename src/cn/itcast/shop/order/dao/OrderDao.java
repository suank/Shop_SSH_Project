package cn.itcast.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.order.vo.Order;
import cn.itcast.shop.order.vo.OrderItem;


public class OrderDao extends HibernateDaoSupport {

	// Dao层的保存订单的方法
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}
}