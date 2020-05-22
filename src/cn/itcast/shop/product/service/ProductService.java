package cn.itcast.shop.product.service;

import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.product.dao.ProductDao;
import cn.itcast.shop.product.pojo.Product;
import cn.itcast.shop.util.PageBean;

@Transactional
public class ProductService {
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}

	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}

	
	public Product findByPid(Integer pid) {
		
		// TODO Auto-generated method stub
		return productDao.findByPid(pid);
	}

	/**
	 * 
	 * @param cid 一级分类id
	 * @param page 当前页
	 * @return
	 */
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		//当前页码
		pageBean.setPage(page);
		//每页显示
		int limit = 8;
		pageBean.setLimit(limit);
		//总记录数
		int totalCount;
		totalCount = productDao.findCountCid(cid); //根据Cid查询其下所有商品个数
		pageBean.setTotalCount(totalCount);
		//总页数
		int totalPage;
		
		totalPage = (int) Math.ceil(totalCount/limit); //向下取整 1.05 -> 2
		pageBean.setTotalPage(totalPage);
		
		//每页数据集合
		int begin = (page-1)*limit; //从哪开始
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		
		return 	pageBean;
	}

	
}
