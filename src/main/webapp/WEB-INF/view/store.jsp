<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<spring:message code = "store.info1" var="info1" />
<spring:message code = "store.info2" var="info2" />

<t:template>
	<!-- TODO to be completed -->
       <div class="row">
	       <div class="col-sm-4 map">
				<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" 
					src="https://www.openstreetmap.org/export/embed.html?bbox=9.144546389579775%2C45.39725213843469%2C9.150533080101015%2C45.399444388452174&amp;layer=mapnik&amp;marker=45.398348274075225%2C9.147539734840393" 
					style="border: 1px solid black">
				</iframe>
				<br/>
				<small>
					<a href="https://www.openstreetmap.org/?mlat=45.39835&amp;mlon=9.14754#map=18/45.39835/9.14754&amp;layers=N">
						Visualizza mappa ingrandita
					</a>
				</small>
			</div>
	        <div class="col-sm-5">
				<h2 style="font-weight:bold">${info1}</h2><br/>
				<h2>${info2}</h2>
			</div>			
		</div>
</t:template>