 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<spring:message code = "myaccount.edit.name" var="edit_name"/>
<spring:message code = "myaccount.edit.email" var="edit_email"/>
<spring:message code = "myaccount.edit.password" var="edit_password"/>
<spring:message code = "myaccount.edit.address" var="edit_address"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

 <script type="text/javascript">
 
	function readURL(input) {
	    var url = input.value;
	    var ext = url.substring(url.lastIndexOf('.') + 1).toLowerCase();
	    if (input.files && input.files[0]&& (ext == "png" || ext == "jpeg" || ext == "jpg")) {
	        var reader = new FileReader();
	
	        reader.onload = function (e) {
	            $('#profile_pic').attr('src', e.target.result);
		    }
	
	        reader.readAsDataURL(input.files[0]);
	        updateImg();
	    }else{
	    	swal({
	    		  title: "Errore",
	    		  text: "Il file selezionato è di un formato non supportato",
	    		  icon: "warning",
	    		  buttons: {
					  cancel: {
					      text: "Annulla",
					      value: false,
					      visible: true,
					    },
					  confirm: {
					        text: "Seleziona un altro file",
					        value: true,
					      },
	    		  },
	    		  dangerMode: true,
	    		})
	    		.then((value) => {
	    		  if (value) {
	    			  document.getElementById("file-upload").click();
	    		  }
	    		});
	    }
	    
	}
 
 	function changeImg(){
 		swal({
			  title: "Selezionare un'opzione",
			  text: "Cosa si desidera fare con l'immagine profilo?",
			  icon: "info",
			  buttons: {
				  cancel: {
				      text: "Annulla",
				      visible: true,
				    },
				  reset: {
				      text: "Rimuovi",
				      value: "reset",
				    },
				  view: {
				        text: "Apri",
				        value: "view",
				      },
				  edit: {
				      text: "Modifica",
				      value: "edit",
				    },
			  },
			})
			.then((value) => {
				  switch (value) {
				 
				    case "view":
				    	var winref = window.open('#', '', '', true);
				    	if(winref.location.href === 'about:blank'){
				    		winref.document.write("<img src='"+document.getElementById('profile_pic').src+"'/>");
				    	}
				    	else {
				    		winref.focus();
				    	}

				      break;
				 
				    case "edit":
				    	document.getElementById("file-upload").click();
				      break;
				      
				    case "reset":
				    	swal({
				    		  title: "Sicuro?",
				    		  closeOnClickOutside: false,
							  closeOnEsc: false,
				    		  text: "Verrà ripristinata l'immagine di default, continuare?",
				    		  icon: "warning",
				    		  buttons: {
								  cancel: {
								      text: "No",
								      value: false,
								      visible: true,
								    },
								  confirm: {
								        text: "Si",
								        value: true,
								      },
				    		  },
				    		  dangerMode: true,
				    		})
				    		.then((value) => {
				    		  if (value) {
							   	$('#profile_pic').attr('src', "data:image/png;base64,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");
							   	updateImg();
				    		  }
				    		});
				      break;
				 
				    default:
				      break;
				  }
			});
	}
 	
 	function updateImg() {
		var img = {}
		 setTimeout(function(){
				img["image"] = document.getElementById('profile_pic').src;
				$.post({
					contentType : "application/json",
					url : "account_view",
					data : JSON.stringify(img),
					dataType : 'json',
					success : function(res) {
						console.log("SUCCESS: ", res);
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
		    }, 200);
		
 	}
	
 </script>
<t:template>
	<div class="row row_accview">
		<input id="profile_pic" type="image" onclick="changeImg()" src="${user.image}" alt="${user.name} ${user.surname}" class="img_profile img-responsive img-rounded" />
		<input style="visibility:hidden;" id="file-upload" accept=".png,.jpeg,.jpg" onchange="readURL(this)" type="file"/>
	</div>
	<table class="div-master">
		<tr>
			<td>
				<div class="col-sm-6">
					<p class="p-nome">Nome:</p> <br/> 
					<p class="nomesub"><c:out value="${user.name} ${user.surname}"/></p>				
				</div>
				<div class="col-sm-6">
					<a href="account_name" class="hoverInfo hoverButton">${edit_name} </a> 
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="col-sm-6">
					<p class="p-nome">Indirizzo:</p> <br/> 
					<p class="nomesub"><c:out value="${user.address.line1}, ${user.address.zipCode}, ${user.address.town}"/></p>				
				</div>
				<div class="col-sm-6">
					<a href="account_address" class="hoverInfo hoverButton">${edit_address} </a> 
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="col-sm-6">
					<p class="p-nome">E-mail:</p> <br/> 
					<p class="nomesub"><c:out value="${user.email}"/></p>
					
				</div>
				<div class="col-sm-6">
					<a href="account_email" class="hoverInfo hoverButton">${edit_email} </a> 
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="col-sm-6">
					<p class="p-nome">Password:</p> <br/>  
					<p class="nomesub">**********</p>					
				</div>
				<div class="col-sm-6">
					<a href="account_password" class="hoverInfo hoverButton">${edit_password} </a> 
				</div>
			</td>
		</tr>
	</table>
</t:template>