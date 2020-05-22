<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
<!-- 		OGNL从Session获取用户信息  	-->
			<s:if test="#session.existUser == null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/user_registPage.action">注册</a>|
				</li>
			</s:if>
			<s:else>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<s:property value="#session.existUser.name" /> |
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/user_quit.action">订单</a> |
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/user_quit.action">退出</a>|
				</li>
			</s:else>

		</ul>
	</div>
	
	<div class="cart"   >
		<a href="./购物车.htm">购物车</a>
	</div>
	
</div>

<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index.action">首页</a> |</li>
		<s:iterator var ="c" value="#session.cList">
<!-- 					根据一级分类获取其下二级分类数据   并显示一级分类下所有商品并分页呈现 -->
					<li><a href=" ${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1 "> <s:property value="#c.cname"/></a> |</li>	
		</s:iterator>
	</ul>
</div>