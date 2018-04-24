<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<spring:message code = "myaccount.edit.profile" var="submit"/>
<spring:message code = "register.page.label.email" var="email" />
<spring:message code = "edit.page.confirm" var="confirm" />
<spring:message code = "edit.page.cancel" var="cancel" />
<spring:message code = "edit.page.email.password" var="password" />
<spring:message code = "edit.page.address.line1" var="line1" />
<spring:message code = "edit.page.address.zipCode" var="zipCode" />
<spring:message code = "edit.page.address.town" var="town" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
	
	// JavaScript for label effects only
	$(window).on('load', function(){	
		if($(".input-effect input").val() != ""){
			$(".input-effect input").addClass("has-content");
		}else{
			$(".input-effect input").removeClass("has-content");
		}
		$(".input-effect input").focusout(function(){
			if($(this).val() != ""){
				$(this).addClass("has-content");
			}else{
				$(this).removeClass("has-content");
			}
		});
	    
		if($(".input-effect2 input").val() != ""){
			$(".input-effect2 input").addClass("has-content");
		}else{
			$(".input-effect2 input").removeClass("has-content");
		}
		$(".input-effect2 input").focusout(function(){
			if($(this).val() != ""){
				$(this).addClass("has-content");
			}else{
				$(this).removeClass("has-content");
			}
		});
	});
	
	function cancelClick(){
		window.location.href = "account_view";
	}	
	
	$(function() {
		$('.target').on('input', function() { 
			$("#div_left").css("display", "block"); 
			$("#div_right").css({"float":"", "width":"50%", "display":"block"}); 
			$("#cancel").css("float","left"); 
		});			
	});

</script>
 
<t:template>
	<form:form class="formZoom" action="account_address" method="post" modelAttribute="editAddress">
		<div id="informations" class="form-edit profile_info">		
			<div class="col-3 input-effect">
	        	<form:input id="address.line1" type="text" value="${user.address.line1}" autocomplete="address-line1" path="address.line1" class="target effect-21" placeholder=""/>
	            <label>${line1}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>	
	        <form:errors path="address.line1" cssClass="error effect-error-name"/>	
	        
	        <div class="col-3 input-effect2">
	        	<form:input id="address.zipCode" type="text" value="${user.address.zipCode}" autocomplete="postal-code" path="address.zipCode" class="target effect-21" placeholder=""/>
	            <label>${zipCode}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>	
	        <form:errors path="address.zipCode" cssClass="error effect-error-name"/>	
	        	
	        <div class="col-3 input-effect2">
	        	<form:input id="address.town" type="text" value="${user.address.town}" autocomplete="locality" path="address.town" class="target effect-21" placeholder=""/>
	            <label>${town}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>	
	        <form:errors path="address.town" cssClass="error effect-error-name"/>				
		</div>
		<div class="row">
			<div class="div_left col-sm-6" id="div_left">
				<button type="submit" class="hover_right hoverButton">${confirm}</button>
			</div>
			<div class="div_right col-sm-6" id="div_right">
				<button type="button" onclick="cancelClick()" id="cancel" name="cancel" class="hoverExit hoverButton">${cancel}</button>
			</div>
		</div>
   </form:form>
   
</t:template>