package cn.itcast.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.user.pojo.User;
import cn.itcast.shop.user.service.UserService;
import cn.itcast.shop.util.CheckImgUtil;

/**
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>  {
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

//	// 验证码不是User的属性，所以要通过set方式将前端的验证码传递
//	private String front_checkCode;
//	
//	public void setCheckCode(String front_checkCode) {
//		this.front_checkCode = front_checkCode;
//	}


	/**
	 * 跳转到登录页面
	 */
	public String loginPage(){
		return "loginPage";
	}


	/**
	 * 跳转到注册页面
	 */
	public String registPage(){

		return "registPage";
	}


	/**
	 * 前端AJAX异步发起请求，接收用户名后，去数据库获取用户对象
	 * @throws IOException 
	 */ 

	
	  
	public String findByName() throws IOException {
		  HttpServletRequest request = ServletActionContext.getRequest();
	     String username = (String)request.getAttribute("username");
		 System.out.println("[[[[[[]]]"+username);
		  
		// 调用Service进行查询:
		User existUser = userService.findByName(username);
		
		// 获得response对象,项页面输出:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("+existUser++"+existUser);
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE; //页面不跳转
	}


	
	//用户注册
	public String regist() throws Exception {
		
		//后台校验
		String username = user.getUsername();
		System.out.println("*username -*-*"+username);
		if(username==null) {
			throw new Exception("用户名为空");
		}
		
		//从Session获取注册表单中的验证码 进行比对校验
		String back_checkCode= (String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		String front_checkCode = user.getCheckcode();
		if(!back_checkCode.equalsIgnoreCase(front_checkCode)) {
			this.addActionError("验证码错误");
			return "registPage";
		}
		
		//用户数据入库
		userService.save(user);
		this.addActionMessage("注册成功,请前往邮箱激活");
		return "msg";
		
	}

	//用户激活 
	public String active() {
		
		User existUser = userService.findByCode(user.getCode());
		
		//根据邮箱中的激活码去找用户，如果找不到说明激活码可能被篡改
		if (existUser==null) {
			//激活失败
			this.addActionMessage("激活失败");
		} else {
			//激活成功
			existUser.setState(1);
			userService.updateUser(existUser);
			this.addActionMessage("激活失败,可以登录系统了");
		}
		
		return "msg";
	} 

	
	//用户登录 
	public String login() {
		User existUser = userService.login(user);
		if (existUser==null) {
			//登录失败 提示并跳转
			this.addActionMessage("用户登录失败:  用户名或密码错误或用户未激活");
			return "loginPage";
		} else {
			//登录成功 将用户信息保存在Session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess"; //带着用户信息发起重定向
		}
	} 
	
	//退出登录 
	public String quit(){
		// 销毁session
//		ServletActionContext.getRequest().getSession().invalidate();
		ServletActionContext.getRequest().getSession().removeAttribute("existUser");
		return "quit";
	}
	
	public String checkImg() throws IOException{
		System.out.println("999checkImg99999999");
		//在指定位置生成验证码
		CheckImgUtil.createCheckImg();
		return NONE;
	}
	
}
