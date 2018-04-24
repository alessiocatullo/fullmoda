<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<spring:message code = "productlist.page.link.show" var="show"/>		
		<t:template>
		
	        <div class="row">
				<c:forEach var="product" items="${productList}">
					<div class="col-sm-4">
						<img src="images/${product.code}.jpg" class="img-responsive img-rounded"/>
						<p><c:out value="${product.shortDescription}"/>
						<p><c:out value="${product.price.currency.symbol}"/>&nbsp;<fmt:formatNumber value="${product.price.value}" minFractionDigits="2"/></p>
						<p><a href ="p-${product.code}"><c:out value="${show}"/></a>	
					</div>
				</c:forEach>
			</div>
		
	
		</t:template>