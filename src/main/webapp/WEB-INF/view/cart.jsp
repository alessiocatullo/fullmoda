<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<t:template>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/main.css"/>

<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:40%">Prodotto</th>
							<th class="text-center" style="width:10%"></th>
							<th class="text-center" style="width:5%">Colore</th>
							<th class="text-center" style="width:15%">Quantità</th>
							<th class="text-center" style="width:10%">Prezzo</th>
							<th class="text-center" style="width:15%">Totale</th>
							<th style="width:5%"></th>
						</tr>
					</thead> 
					<c:forEach var="var" items="${cart}" >
					<tbody>
						<tr>
							<td data-th="Prodotto">
								<div class="row">
									<div class="col-sm-2">
										<a href="p-${var.product.color.product.code}">
											<img src="images/${var.product.color.product.code}.jpg" alt="..." class="img-responsive"/>
										</a>
									</div>
									<div class="col-sm-9">
										<a href="p-${var.product.color.product.code}">
											<h4 class="nomargin"><b><c:out value="${var.product.color.product.shortDescription}"/></b></h4>
										</a>
										<div id="div-${var.product.color.product.code}" class="row gradient"><c:out value="${var.product.color.product.description}"/></div>
										<div class="expanded" onclick="getId('${var.product.color.product.code}')">
											<i id="arrow-${var.product.color.product.code}" class="fas fa-caret-down"></i>
										</div>
									</div>	
								</div>
							</td>
							<td data-th="Size">
							<p class="text-center" onclick="test()">
								Taglia: 
								<c:out value="${var.product.size.code.substring(2, var.product.size.code.length())}" />
							</p>
							</td>
							<td data-th="Colore">
								<p class="text-center"><i class="fas fa-square" style="color: ${var.product.color.colorData.htmlCode}; font-size: 1.5em;"></i></p>
							</td>
							<td data-th="Quantità">
								<div class="center">
							    <p>
							      </p><div class="input-group">
							          <span class="input-group-btn">
							              <a href="delete-1-${var.id}" class="${ var.quantity>19 ? 'disable' : ''}"><button type="button" class="btn btn-default btn-number" data-type="minus">
							                  <span class="glyphicon glyphicon-minus"></span>
							              </button></a>
							          </span>
							          <input type="text" name="quant[1]" class="form-control-cart input-number text-center" readonly value="${var.quantity}">
							          <span class="input-group-btn">
							              <a href="addCart-1-${var.id}" class="${ var.quantity>19 ? 'disable' : ''}"><button type="button" class="btn btn-default btn-number" data-type="plus">
							                  <span class="glyphicon glyphicon-plus"></span>
							              </button></a>
							          </span>
							      </div>
							    <p>
								<p></p>
							</div>
							</td>
							<td data-th="Prezzo" class="text-center" style="font-size: 1.3em;"><c:out value="${var.product.color.product.price.value}"/> €</td>
							<td data-th="Totale" class="text-center" style="color: DarkRed; font-size: 1.5em">
								<b>
									<c:out value="${var.product.color.product.price.value * var.quantity}"/> €</b>
							</td>
							<td class="actions text-center" data-th="">
								<a href="delete-${var.id}"><i class="fas fa-trash-alt" style="color: #222222; font-size: 1.5em"></i></a>
							</td>
						</tr>
					</tbody>
					</c:forEach>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><c:out value="price"/></td>
						</tr>
						<tr>
							<td><a href="products" class="btn btn-warning" style="background-color: #222222; border: #222222">Continua lo Shopping</a></td>
							<td colspan="4" class="hidden-xs"></td>
							<td class="hidden-xs text-center" style="color: red; font-size: 1.7em"><b><c:out value="${tot}"/> €</b></td>
							<td><a href="payment-${idCart}-${tot}" class="btn btn-success btn-block" style="${tot>0 ? '':'display:none'}; background-color: #222222; border: #222222">Prosegui</a>
							</td>
						</tr>
					</tfoot>
				</table>
	</div>
</t:template>

<script>
function getId(id){
	var arr = "arrow-"+id;
	var arr = document.getElementById(arr);
	var div = "div-"+id;
	var div = document.getElementById(div);
	
	if(div.className == "row gradient"){
		div.className="row gradientless";
		arr.className="fas fa-caret-up";
	}else {
		div.className="row gradient";
		arr.className="fas fa-caret-down";
	}
}

function test(){
    $.ajax({
        url : 'cart',
        success : function (){
        	location.reload(true);
        },
    	error :	function (){
    		alert("Error");
    	}
    });
}

function addOnes(){
    $.ajax({
        url : 'cart',
        success : function (){
        	location.reload(true);
        },
    	error :	function (){
    		alert("Error");
    	}
    });
}

function test(){
    $.ajax({
        url : 'cart',
        success : function (){
        	alert('${cart}');
        },
    	error :	function (){
    		alert("Error");
    	}
    });
}
</script>