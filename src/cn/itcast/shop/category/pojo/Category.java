package cn.itcast.shop.category.pojo;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.categorysecond.pojo.CategorySecond;

public class Category {
	private Integer cid;
	private String cname;
	
	//二级分类 集合 一个一级分类对应多个二级分类
	private Set<CategorySecond> categorySeconds= new HashSet<CategorySecond>();
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname +  "]";
	}
}
