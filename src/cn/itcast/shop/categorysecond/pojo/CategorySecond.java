package cn.itcast.shop.categorysecond.pojo;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.category.pojo.Category;
import cn.itcast.shop.product.pojo.Product;

public class CategorySecond {
	private Integer csid;
	private String csname;
	
	//对应一级分类
	private Category category;

	//对应二级分类下的商品
	private Set<Product> products = new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", category=" + category + "]";
	}

	public CategorySecond(Integer csid, String csname, Category category) {
		super();
		this.csid = csid;
		this.csname = csname;
		this.category = category;
	}

	public CategorySecond() {
		super();
	}
	
}
