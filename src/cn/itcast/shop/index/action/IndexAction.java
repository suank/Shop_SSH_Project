package cn.itcast.shop.index.action;

import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.product.pojo.Product;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.category.pojo.Category;

/**
 * 首页访问的Action
 *
 */
public class IndexAction extends ActionSupport{
	
	private CategoryService categoryService; 
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	private ProductService productService; 
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

		
	/**
	 * 执行的访问首页的方法: 
	 * 访问首页的时候，获取第一分类数据并在前端呈现，获取热门商品数据并呈现
	 * @author garfield 
	 */
	public String execute(){
		System.out.println("[][][][]");
		
		List<Category> clist = categoryService.findAll();
		
		//将数据库第一分类数据保存到Session中
		ActionContext.getContext().getSession().put("cList", clist);
		
		
		//查询热门商品
		List<Product> hList = productService.findHot();
		System.out.println("hList [][][][]"+hList );
		
		//将数据保存到值栈中
		ActionContext.getContext().getValueStack().set("hList", hList);
//		ActionContext.getContext().getSession().put("hList", hList);

		//查询最新商品
		List<Product> nList = productService.findNew();
		//将数据保存到值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		System.out.println("nList  [][][][]"+nList  );
		
		return "index";
	}
	
	
	
}
