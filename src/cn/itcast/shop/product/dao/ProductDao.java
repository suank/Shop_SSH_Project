package cn.itcast.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.shop.product.pojo.Product;
import cn.itcast.shop.user.pojo.User;
import cn.itcast.shop.util.PageHibernateCallback;
@Repository
public class ProductDao extends HibernateDaoSupport {

	//首页上热门商品查询
	public List<Product> findHot() {
//		String HQL = "FROM User";
//		List<User> hList = this.getHibernateTemplate().find(HQL);
//		System.out.println("+++++hList++++++++++++"+hList);

		//分页查询-离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class); //反射
		//条件:热门
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序排序(最新热门)
		criteria.addOrder(Order.desc("pdate"));
		System.out.println("--this.getHibernateTemplate().---"+this.getHibernateTemplate() );

		//分页查询
		List<Product> hList = this.getHibernateTemplate().findByCriteria(criteria,0,10);
		
		System.out.println("+++++hList++++++++++++"+hList);
		return hList;
	}
	
	//首页上最新商品查询
	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class); //反射
		//倒序排序(最新热门)
		criteria.addOrder(Order.desc("pdate"));
		//分页查询
		List<Product> nList = this.getHibernateTemplate().findByCriteria(criteria,0,10);
		System.out.println("+++++nList ++++++++++++"+nList );
		return nList ;
	}

	
	public Product findByPid(Integer pid) {
		return  this.getHibernateTemplate().get(Product.class, pid);
	}


	//根据商品分类id  商品个数
	public int findCountCid(Integer cid) {
		//
		//必须先建立一级分类和二级分类的关系,商品和二级分类的关系 
		//cid -> csid -> product
		String HQL = "select count(*) from Product p where p.categorySecond.category.cid = ?";

		List<Long> findList = this.getHibernateTemplate().find(HQL,cid); //select count 返回Long
		
		if(findList!=null && findList.size()>0) {
			return findList.get(0).intValue();
		}
		return 0;
		
	}
	
	
	//根据商品分类id  查询商品集合
	 public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		//通过cid 关联查询
		 String HQL = "select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		  //有SQL的分页查询  		简单分页查询：离线查询
		 List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback(HQL, new Object[] {cid}, begin, limit) );
		 
		 return list;
	}
	
}


