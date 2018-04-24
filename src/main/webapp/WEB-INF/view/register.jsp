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
<spring:message code = "register.page.label.birthdate" var="birthdate" />
<spring:message code = "register.page.label.line1" var="line1" />
<spring:message code = "register.page.label.zipCode" var="zipCode" />
<spring:message code = "register.page.label.town" var="town" />
<spring:message code = "register.page.label.passwordConfirmation" var="passwordConfirmation" />
<spring:message code = "register.page.label.privacy" var="privacy" />
<spring:message code = "generic.error" var="generic_error" />

<t:template>
	<div class="row">
		<div class="col-sm-12">
	      <form:form action="register" method="POST" commandName="registerForm" class="form-signin">
	        <h2 class="form-signin-heading"><spring:message code = "register.page.title"/></h2>
	        
	        <label for="email" class="sr-only"></label>
	        <form:input path="email" class="form-control" placeholder="${email}*"/>
	        <form:errors path="email" cssClass="error"/>
	        
	        <label for="password" class="sr-only"><spring:message code = "register.page.label.password"/></label>
	        <form:input path="password" type="password" class="form-control" placeholder="${password}*"/>
	        <form:errors path="password" cssClass="error"/>
	        
	        <label for="passwordConfirmation" class="sr-only"><spring:message code = "register.page.label.passwordConfirmation"/></label>
	        <form:input path="passwordConfirmation" type="password" class="form-control" placeholder="${passwordConfirmation}*"/>
	        <form:errors path="passwordConfirmation" cssClass="error"/>
	        
	        <label for="name" class="sr-only"><spring:message code = "register.page.label.name"/></label>
	        <form:input path="name" class="form-control" placeholder="${name}*"/>
	        <form:errors path="name" cssClass="error"/>
	        
	        <label for="surname" class="sr-only"><spring:message code = "register.page.label.surname"/></label>
	        <form:input path="surname" class="form-control" placeholder="${surname}*"/>
	        <form:errors path="surname" cssClass="error"/>
	        
	        <label for="birthdate" class="sr-only"><spring:message code = "register.page.label.birthdate"/></label>
	        <form:input path="birthdate" type="date" class="form-control" placeholder="${birthdate}*"/>
	        <form:errors path="birthdate" cssClass="error"/>
	
	        <label for="address.line1" class="sr-only"><spring:message code = "register.page.label.line1"/></label>
	        <form:input path="address.line1" class="form-control" placeholder="${line1}"/>
	        <form:errors path="address.line1" cssClass="error"/>
	        
	        <label for="address.zipCode" class="sr-only"><spring:message code = "register.page.label.zipCode"/></label>
	        <form:input path="address.zipCode" class="form-control" placeholder="${zipCode}"/>
	        <form:errors path="address.zipCode" cssClass="error"/>
	        
	        <label for="address.town" class="sr-only"><spring:message code = "register.page.label.town"/></label>
	        <form:input path="address.town" class="form-control" placeholder="${town}"/>
	        <form:errors path="address.town" cssClass="error"/>
	        	        	        	        
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