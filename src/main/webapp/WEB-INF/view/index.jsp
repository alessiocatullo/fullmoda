<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>	

<t:template>
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	    </ol>
	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner">
	      <div class="item active">
	        <img src="images/home/carousel_1.jpg" >
	      </div>
	
	      <div class="item">
	        <img src="images/home/carousel_2.jpg" >
	      </div>
	    
	      <div class="item">
	        <img src="images/home/carousel_3.jpg" >
	      </div>
	    </div>
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
	  
	  <div class="container marketing">
		  <hr class="featurette-divider">
	
	      <div class="row featurette">
	        <div class="col-md-7">
	          <h2 class="featurette-heading"><spring:message code="home.page.featurette.title1" htmlEscape="false" /></h2>
	          <p class="lead"><spring:message code="home.page.featurette.text1"/></p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" src="images/home/featurette_1.jpg" data-holder-rendered="true">
	        </div>
	      </div>
	      
	      <hr class="featurette-divider">

	      <div class="row featurette">
	        <div class="col-md-7 push-md-5">
	          <h2 class="featurette-heading"><spring:message code="home.page.featurette.title2" htmlEscape="false" /></h2>
	          <p class="lead"><spring:message code="home.page.featurette.text2"/></p>
	        </div>
	        <div class="col-md-5 pull-md-7">
	          <img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" src="images/home/featurette_2.jpg" data-holder-rendered="true">
	          
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	
	      <div class="row featurette">
	        <div class="col-md-7">
	          <h2 class="featurette-heading"><spring:message code="home.page.featurette.title3" htmlEscape="false" /></h2>
	          <p class="lead"><p class="lead"><spring:message code="home.page.featurette.text3"/></p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" src="images/home/featurette_3.jpg" data-holder-rendered="true">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	      
      
	  </div>
	
</t:template>
