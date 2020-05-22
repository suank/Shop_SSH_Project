<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container header">
<div class="headerAd">

		<%@ include file="menu.jsp" %>
</div>	

<div class="container productList">
		
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator var="c" value="#session.cList">
						
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>"><s:property value="#c.cname"/></a>
							</dt>
						
							<s:iterator var="cs" value="#c.categorySeconds" >
									<dd>
										<a ><s:property value="#cs.csname"/></a>
									</dd>
							</s:iterator>		
				
						</dl>
				
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">


					
				<div id="result" class="result table clearfix">
						<ul>
								<s:iterator var="p" value="pageBean.list">
									<li>
										<a href="./京华商城分页面.htm">
											<img src="${pageContext.request.contextPath}/<s:property value="#p.image"/> " width="170" height="170"  style="display: inline-block;">
											   
											<span style='color:green'>
											 	<s:property value="#p.pname"/>
											</span>
											 
											<span class="price">
												<s:property value="#p.shop_price"/>
											</span>
											 
										</a>
									</li>
								</s:iterator>
						</ul>
				</div>
	<div class="pagination">
			<span class="firstPage">&nbsp;</span>
			<span class="previousPage">&nbsp;</span>
				<span class="currentPage">1</span>
				<a href="javascript: $.pageSkip(2);">2</a>
			<a class="nextPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
			
			<a class="lastPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
	</div>
			</form>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
</div>	</div>
	<div class="span24">
	</div>
	<div class="span24">
	</div>
</div>
</body></html>