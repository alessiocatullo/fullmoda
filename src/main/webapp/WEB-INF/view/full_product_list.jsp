<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<spring:message code = "productlist.page.link.show" var="show"/>		


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
	
	// JavaScript for label effects only
	$(window).on('load', function(){	
		if ('${user}' != ""){
			if ('${user.phonenumber}' == ""){
			    var x = document.getElementById("snackbar");
			    x.className = "show";
			    setTimeout(function(){
			    	x.classList.remove("show"); 
			    }, 5000);
			}
		}
	});
	</script>

<spring:message code = "productlist.page.link.show" var="show"/>
		<t:template>
	        <div class="row">
				<c:forEach var="product" items="${productList}">
					<div class="col-sm-4">
						<img src="images/${product.code}.jpg" class="img-responsive img-rounded"/>
						<p><c:out value="${product.shortDescription}"/>
						<p><c:out value="${product.price.currency.symbol}"/>&nbsp;<fmt:formatNumber value="${product.price.value}" minFractionDigits="2"/></p>
						<p><a href ="p-${product.code}"><button class="btn_cart"> ${show} </button></a><p>
					</div>
				</c:forEach>
			</div>
		</t:template>