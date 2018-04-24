$(document).on("click", "button.remove-from-cart", function(){	

	var productCode = "" + $(this).data("productcode");
	var remove = "div#product-" + productCode + ".row";
	var totalPrice = $(this).data("total");
	var subtotalPrice = $(document).find("sdpan#subtotalPrice").data("subtotal");
	var newSubtotal = subtotalPrice - totalPrice;
	$.ajax({
		type: "GET",
		url: "removeFromCart-" + productCode,
		success: function() {
			
			console.log("Total price of element: " + totalPrice);
			console.log("Subtotal price of element: " + subtotalPrice);
			console.log("New subtotal: " + newSubtotal);
			$(remove).remove();
			$(subtotalPriceElement).text(newSubtotal);
		}
	});
});