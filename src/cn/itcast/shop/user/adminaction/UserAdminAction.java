package cn.itcast.shop.user.adminaction;

import cn.itcast.shop.user.service.UserService;

import cn.itcast.shop.user.pojo.User;
import cn.itcast.shop.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 后台用户管理的Action类
 *
 */
public class UserAdminAction extends ActionSupport implements ModelDriven<User>{
	// 模型驱动使用的类
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	// 注入用户的Service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 接受page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	// 后台查询所有用户的方法带分页:
	public String findAll(){
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

}
