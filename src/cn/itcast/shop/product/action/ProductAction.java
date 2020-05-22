package cn.itcast.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.category.pojo.Category;
import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.product.pojo.Product;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.util.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	public Product getModel() {
		return product ;
	}

	private ProductService productService ;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//接受前端传入当前页码
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}


	//根据pid查询商品
	public String findByPid() {
		//为了在前端显示，需要将数据放入值栈中，但是模型驱动却是存在于值栈栈顶的，所以可以直接利用
		product = productService.findByPid(product.getPid());

		return "findByPid";
	}

	
	//接受一级分类Cid 
	private Integer cid;
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	//注入一级分类Service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	//根据cid查询1级分类数据 交给前端迭代获取二级分类
	public String findByCid() {
		//获取所有一级分类 直接查询或者是从Session内获取（在Index中已经实现获取）
		//List<Category> findAll = categoryService.findAll();
		
		PageBean<Product> pageBean  = productService.findByPageCid(cid,page);//根据一级分类查询商品并分页显示
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}






}
