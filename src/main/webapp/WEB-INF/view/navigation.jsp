<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		

<spring:message code="login.welcome.message" var="welcome" arguments="${user.name}"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 
 <nav class="nav-down navbar navbar-inverse navbar-fixed-top">
  
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
	      			<li><a href="account_view"><spring:message code = "navigation.header.menu.my-account"/></a></li>
	      			<li><a href="logout"><spring:message code = "navigation.header.menu.logout"/></a></li>
	      		</c:otherwise>
	      	</c:choose>
	    </ul>
    </div>
    	<div id="snackbar">Completa il tuo profilo nella sezione "Modifica Nome"</div>
    
 </nav>
 
 <script type="text/javascript">

	//Hide Header on on scroll down
	var didScroll;
	var lastScrollTop = 0;

	$(window).scroll(function(event){
	    didScroll = true;
	});
	
	setInterval(function() {
	    if (didScroll) {
	        hasScrolled();
	        didScroll = false;
	    }
	}, 10);
	
	function hasScrolled() {
		var st = $(this).scrollTop();
	    // Make sure they scroll more than delta
	
	    // If they scrolled down and are past the navbar, add class .nav-up.
	    // This is necessary so you never see what is "behind" the navbar.
	    if (st > lastScrollTop){
	        // Scroll Down
	        $('nav').removeClass('nav-down').addClass('nav-up');
	    } else {
	        // Scroll Up
		    $('nav').removeClass('nav-up').addClass('nav-down');

	    }
	    
	    lastScrollTop = st;
		}
	


</script>