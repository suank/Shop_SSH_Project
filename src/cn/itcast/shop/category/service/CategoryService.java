package cn.itcast.shop.category.service;

import java.util.List;

import cn.itcast.shop.category.dao.CategoryDao;
import cn.itcast.shop.category.pojo.Category;
import cn.itcast.shop.user.dao.UserDao;

public class CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}
	
}
