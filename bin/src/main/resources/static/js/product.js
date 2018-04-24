$(document).ready(function() {
	if ($(".size-select").length) {
		$(".size-select").first().show();
	}
});

$(".color-select").change(function(elem){
	var selected = this.value;
	$(".size-select").hide();
	$("#sizesOf-"+selected).show();
});