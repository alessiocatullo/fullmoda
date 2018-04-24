<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<spring:message code = "myaccount.edit.profile" var="submit"/>
<spring:message code = "register.page.label.name" var="name" />
<spring:message code = "register.page.label.surname" var="surname" />
<spring:message code = "register.page.label.phonenumber" var="phonenumber" />
<spring:message code = "register.page.label.birthdate" var="birthdate" />
<spring:message code = "register.page.label.birthplace" var="birthplace" />
<spring:message code = "register.page.label.fiscalcode" var="fiscalcode" />
<spring:message code = "edit.page.confirm" var="confirm" />
<spring:message code = "edit.page.cancel" var="cancel" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
	
	function hasContent(classe){
		if($(classe).val() != ""){
			$(classe).addClass("has-content");
		}else{
			$(classe).removeClass("has-content");
		}
		$(classe).focusout(function(){
			if($(this).val() != ""){
				$(this).addClass("has-content");
			}else{
				$(this).removeClass("has-content");
			}
		});
	}
	
	// JavaScript for label effects only
	$(window).on('load', function(){	
		hasContent(".input-effect input");
		hasContent(".input-effect2 input");
		hasContent(".input-effect3 input");
		hasContent(".input-effect5 input");
		hasContent(".input-effect6 input");
		
	});
	
	function cancelClick(){
		if (document.getElementById('div_left').style.display =="block"){
			if ('${user.name}' != document.getElementById('name').value 
					|| '${user.surname}' != document.getElementById('surname').value
					|| '${user.phonenumber}' != document.getElementById('phonenumber').value
					|| '${user.birthdate}' != document.getElementById('birthdate').value
					|| '${user.birthplace}' != document.getElementById('birthplace').value
					|| '${user.fiscalcode}' != document.getElementById('fiscalcode').value){
				swal({
					  closeOnClickOutside: false,
					  closeOnEsc: false,
					  title: "Attenzione",
					  text: "Alcuni dati sono stati modificati ma non sono stati salvati.",
					  icon: "warning",
					  buttons: {
						  cancel: {
						        text: "Annulla",
						        visible: true,
						      },
						  nosave: {
						        text: "Non salvare",
						        value: false,
						      },
						  save: {
						      text: "Salva",
						      value: true,
						    },
	
					  },
					})
					.then((value) => {
						  switch (value) {
						 
						    case true:
						    	document.getElementById("subname").click();
						      break;
						 
						    case false:
						    	window.location.href = "account_view";
						      break;
						 
						    default:
						      break;
						  }
					});
			}
			else {
				  window.location.href = "account_view";
			}
		  }	else {
			  window.location.href = "account_view";
		}
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
	<form:form class="formZoom" action="account_name" method="post" modelAttribute="editName">
		<div id="informations" class="form-edit profile_info">		
			<div class="col-3 input-effect">
	        	<form:input id="name" autocomplete="given-name" name="name" value="${user.name}" path="name" class="target effect-21" type="text" placeholder=""/>
	            <label>${name}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>
	        <form:errors path="name" cssClass="error effect-error-name"/>
	        
	        <div class="col-3 input-effect2">
	        	<form:input id="surname" autocomplete="family-name" value="${user.surname}" path="surname" class="target effect-21" type="text" placeholder=""/>
	            <label>${surname}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>	
	        <form:errors path="surname" cssClass="error effect-error-name"/>
	        
	        <div class="col-3 input-effect3">
	        	<form:input id="phonenumber" autocomplete="tel" value="${user.phonenumber}" path="phonenumber" class="target effect-21" type="tel" placeholder=""/>
	            <label>${phonenumber}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>   
	        <form:errors path="phonenumber" cssClass="error effect-error-name"/>
	        
	        <div class="col-3 input-effect" >
	        	<form:input id="birthdate" autocomplete="bday" value="${user.birthdate}" path="birthdate" class="target effect-21" type="date" placeholder=""/>
	            <label>${birthdate}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>	
	        <form:errors path="birthdate" cssClass="error effect-error-name"/>

	        <div class="col-3 input-effect5">
	        	<form:input id="birthplace" value="${user.birthplace}" path="birthplace" class="target effect-21" type="text" placeholder=""/>
	            <label>${birthplace}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>		
	        <form:errors path="birthplace" cssClass="error effect-error-name"/>
	        
	        <div class="col-3 input-effect6">
	        	<form:input id="fiscalcode" value="${user.fiscalcode}" path="fiscalcode" class="target effect-21" type="text" placeholder=""/>
	            <label>${fiscalcode}</label>
	            <span class="focus-border">
	            	<i></i>
	            </span>
	        </div>					
	        <form:errors path="fiscalcode" cssClass="error effect-error-name"/>
	        
		</div>
		<div class="row">
			<div class="div_left col-sm-6" id="div_left">
				<button id="subname" type="submit" class="hover_right hoverButton">${confirm}</button>
			</div>
			<div class="div_right col-sm-6" id="div_right">
				<button type="button" onclick="cancelClick()" id="cancel" name="cancel" class="hoverExit hoverButton">${cancel}</button>
			</div>
		</div>
   </form:form>
   
</t:template>