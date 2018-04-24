<%@tag description="Fullmoda Page template" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- Custom css -->
    <link rel="stylesheet" href="css/main.css"/>
    <!-- Icon CSS -->
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet"> 
   
    </head>
	<body>
	<jsp:include page="/WEB-INF/view/navigation.jsp"/>
	<div class="container-fluid">
			<div class="jumbotron">
				<jsp:doBody/>
			</div>
		<jsp:include page="/WEB-INF/view/footer.jsp"/>
	</div>

	<!-- jQuery library -->
	<!-- Bootstrap JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Custom JavaScript -->
	<script src="js/main.js"></script>
	<script src="js/home.js"></script>
	<script src="js/product.js"></script>
  </body>
</html>