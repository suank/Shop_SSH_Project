<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>商城DEMO</title>
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="container header">
	<div class="span5">
	</div>
	<div class="span9">
<div class="headerAd">
</div>	
</div>
	
<!-- 	引入导航 -->
	<%@ include file="menu.jsp" %>
</div>	

<div class="container index">
		
		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
					<div class="title">
						<strong>热热热热门商品</strong>
						<!-- <a  target="_rrblank"></a> -->
					</div>
					<ul class="tab">
							<li class="current">
								<a href="./蔬菜分类.htm?tagIds=1" target="_blank"></a>
							</li>
							<li>
								<a  target="_blank"></a>
							</li>
							<li>
								<a target="_blank"></a>
							</li>
					</ul>
<!-- 					<div class="hotProductAd">
			<img src="${pageContext.request.contextPath}/image/a.jpg" width="260" height="343" alt="热门商品" title="热门商品">
</div> -->
					
<!-- 						热门商品 -->
						<ul class="tabContent" style="display: block;">
						
							
							<s:iterator var="p" value="hList">	
									<li>
										<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>"   target="_blank">  <img src="${pageContext.request.contextPath}/<s:property value="#p.image" />"  data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg" style="display: block"></a>
									</li>
							</s:iterator>
							
									
						</ul>
						
						
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
					<div class="title">
						<strong>最新新新商品</strong>
						<a  target="_blank"></a>
					</div>
					<ul class="tab">
							<li class="current">
								<a href="./蔬菜分类.htm?tagIds=2" target="_blank"></a>
							</li>
							<li>
								<a  target="_blank"></a>
							</li>
							<li>
								<a target="_blank"></a>
							</li>
					</ul>
						 <ul class="tabContent" style="display: block;">
							<s:iterator var="p" value="nList">	
									<li>
										<a target="_blank" href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>" >  <img src="${pageContext.request.contextPath}/<s:property value="#p.image" />"  data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg" style="display: block;"></a>
									</li>
							</s:iterator>
						</ul>
						
			</div>
		</div>
	</div>

</body>
</html>