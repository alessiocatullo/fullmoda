<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<spring:message code = "productlist.page.link.addCart" var="addcart"/>

<t:template>
	<div class="row">
		<div class="col-sm-6">
			<img src="images/${product.code}.jpg" class="img_product img-responsive img-rounded"/>
		</div>
		<div class="col-sm-4 col_product">
			<div class="product-name">
				<h2><c:out value="${product.shortDescription}"/></h2>
			</div>
			<div class="product-price">
				<span><b><c:out value="${product.price.value}"/> €</b></span>
			</div>
			<div class="product_code">
				<span><c:out value="${product.code}"/></span>
			</div>
			<div class="product_desc">
				<span><c:out value="${product.description}"/></span>
			</div> 
			<div class="row color-div">
				<div class="col-sm-4 row-padding">
					<c:forEach var="color" items="${product.variants}" >
						<a href="color-${product.code}-${color.code}">
							<i class="fas fa-square icon" style="color:${color.colorData.htmlCode}"></i>
						</a>
					</c:forEach>
				</div>
				<div class="col-sm-4 row-padding">
					<c:forEach var="colors" items="${product.variants}" >
						<c:forEach var="size" items="${colors.variants}" >
							<input type="button" ${ request.getRequestURL() == null  ? '' : 'disabled="disabled"'} value="${size.size.code.substring(2, size.size.code.length())}">
						</c:forEach>	
					</c:forEach>
				</div>
				<div class="col-sm-4">
					<c:forEach var="size" items="${color.variants}" >
						<p class="text-center">
							<a href="addCart-${size.code}">
								Taglia: 
								<c:out value="${size.size.code.substring(2, size.size.code.length())}" />
							</a>
						</p>
					</c:forEach>
				</div>
			</div>
	</div>
</t:template>

<script>

</script>