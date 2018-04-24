<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
	
<spring:message code = "login.register.submit.button" var="register_button"/>
<spring:message code = "register.page.button.submit" var="submit"/>
<spring:message code = "register.page.label.email" var="email" />
<spring:message code = "register.page.label.name" var="name" />
<spring:message code = "register.page.label.surname" var="surname" />
<spring:message code = "register.page.label.password" var="password" />
<spring:message code = "register.page.label.passwordConfirmation" var="passwordConfirmation" />
<spring:message code = "register.page.label.privacy" var="privacy" />
<spring:message code = "generic.error" var="generic_error" />

<t:template>
	<div class="row">
		<div class="col-sm-12">
	      <form:form action="register" method="POST" commandName="registerForm" class="form-signin">
	        <h2 class="form-signin-heading"><spring:message code = "register.page.title"/></h2>
	        
	        <label for="email" class="sr-only"></label>
	        <form:input path="email" class="form-control" placeholder="${email}"/>
	        <form:errors path="email" cssClass="error"/>
	        
	        <label for="password" class="sr-only"><spring:message code = "register.page.label.password"/></label>
	        <form:input path="password" class="form-control" placeholder="${password}"/>
	        <form:errors path="password" cssClass="error"/>
	        
	        <label for="passwordConfirmation" class="sr-only"><spring:message code = "register.page.label.passwordConfirmation"/></label>
	        <form:input path="passwordConfirmation" class="form-control" placeholder="${passwordConfirmation}"/>
	        <form:errors path="passwordConfirmation" cssClass="error"/>
	        
	        <label for="name" class="sr-only"><spring:message code = "register.page.label.name"/></label>
	        <form:input path="name" class="form-control" placeholder="${name}"/>
	        <form:errors path="name" cssClass="error"/>
	        
	        <label for="surname" class="sr-only"><spring:message code = "register.page.label.surname"/></label>
	        <form:input path="surname" class="form-control" placeholder="${surname}"/>
	        <form:errors path="surname" cssClass="error"/>
	        
	       	<div class="checkbox">
	          <label>
	          	<form:checkbox path="privacy" value="true"/><spring:message code = "register.page.label.privacy"/> 
	          </label> 
	          <form:errors path="privacy" cssClass="error"/>
	        </div>	
	        <spring:hasBindErrors name="registerForm">
		        <c:forEach var="error" items="${errors.globalErrors}">
		        	<span class="error"><spring:message message="${error}" /></span>
		        <br/>
		        </c:forEach>
		    </spring:hasBindErrors>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">${submit}</button>
	      </form:form>
		</div>
	</div>
</t:template>