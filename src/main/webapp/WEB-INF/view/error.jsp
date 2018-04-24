<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<spring:message code = "error.button" var="error_button"/>

<t:template>
	<div class="row">
	
		<h2 class="erroreform">OPS! Questa pagina non esiste :(</h2>
		<a href="../fullmoda" class="hoverButton">
 			<span>${error_button}</span>
		</a>
	</div>
</t:template>