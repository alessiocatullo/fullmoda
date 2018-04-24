<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
	
<spring:message code = "login.submit.button" var="submit"/>
<spring:message code = "login.title" var="title"/>
<spring:message code = "login.label.email" var="email"/>
<spring:message code = "login.label.password" var="password"/>
<spring:message code = "login.register.title" var="register_title"/>
<spring:message code = "login.register.text1" var="register_text1"/>
<spring:message code = "login.register.text2" var="register_text2"/>
<spring:message code = "login.register.submit.button" var="register_button"/>

<t:template>
<div class="row">
	<div class="col-sm-6">
      <form:form action="login" method="POST" commandName="loginForm" class="form-signin">
        <h2 class="form-signin-heading"><c:out value="${title}"/></h2>
        
        <label for="email" class="sr-only">${email}</label>
        <form:input path="email" class="form-control" placeholder="${email}"/>
        <form:errors path="email" cssClass="error"/>
        
        <label for="password" class="sr-only">${password}</label>
        <form:input path="password" class="form-control" placeholder="${password}"/>
        <form:errors path="password" cssClass="error"/>
       	<div class="checkbox">
          <!-- <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label> -->
        </div>	
        
		<spring:hasBindErrors name="loginForm">
	        <c:forEach var="error" items="${errors.globalErrors}">
	        	<span class="error"><spring:message message="${error}" /></span>
	        <br/>
	        </c:forEach>
	    </spring:hasBindErrors>
	    
        <button class="btn btn-lg btn-primary btn-block" type="submit">${submit}</button>
      </form:form>
	</div>
	<div class="col-sm-6">
		<p class="uppercase"><c:out value="${register_title}"/></p>
		<p><c:out value="${register_text1}"/></p>
		<p><c:out value="${register_text2}"/></p>
		<a class="btn btn-lg btn-primary btn-block" href="register">${register_button}</a>
	</div>
</div>
    

	
	<%-- <div class="row">
		<div class="col-sm-6">
		<form:errors path="error.message" cssClass="error"/>
		<form:form action="login" method="POST" commandName="loginForm">
			${label.email}<form:input path="email" /><form:errors path="email" cssClass="error"/>
			${label.password}<form:input path="password"/><form:errors path="password" cssClass="error"/>
			<input type="submit" value="${submit}"/>
		</form:form>
		</div>
		<div class="col-sm-6">
		
		
		</div>
	</div> --%>
	
</t:template>