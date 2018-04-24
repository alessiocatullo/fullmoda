<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		

<spring:message code="login.welcome.message" var="welcome" arguments="${user.name}"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
  
    <div class="navbar-header">
      <a class="navbar-brand" href="home"><spring:message code = "app.name"/></a>
      <div class="navbar-welcome">
	    <c:if test="${user != null and user.name != '' }">
	    	<c:out value="${welcome}" />
	  	</c:if>
      </div>
    </div>
    <div class="navbar-subheader">
    	<div class="subheader-left">
		    	<ul class="nav navbar-nav">
		      		<li><a href="store"><spring:message code = "navigation.header.menu.store"/></a></li>
		    	</ul>
		</div>
	    <ul class="nav navbar-nav">
	    			<li><a href="products"><spring:message code = "navigation.header.menu.products"/></a></li>
	      	<c:choose>
	      		<c:when test="${user == null}">
	      			 <li><a href="login"><spring:message code = "navigation.header.menu.login"/></a></li>
	      		</c:when>
	      		<c:otherwise>
	      			<li><a href="my-account"><spring:message code = "navigation.header.menu.my-account"/></a></li>
	      			<li><a href="logout"><spring:message code = "navigation.header.menu.logout"/></a></li>
	      		</c:otherwise>
	      	</c:choose>
	    </ul>
    </div>
    
</nav>