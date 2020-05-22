package cn.itcast.shop.util;

import java.util.List;

//分页类  对什么数据进行分页显示
public class PageBean<T> {
	
	private int page;    	// 当前页数
	private int totalCount; // 总记录数
	private int totalPage;  // 总页数
	private int limit;		// 每页显示的记录数
	private List<T> list;   // 每页显示数据的集合.
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public PageBean(int page, int totalCount, int totalPage, int limit, List<T> list) {
		super();
		this.page = page;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.limit = limit;
		this.list = list;
	}
	public PageBean() {
		super();
	}
	
}
