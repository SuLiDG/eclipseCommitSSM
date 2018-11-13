$("body").on("click","._do_look",function(){
	var row = $(this).data("row");
	$.get(
		"user-look.html",
		function(html){
			var html = $(html).appendTo($("body"));
			
			html.modal("show");
			html.on("hidden.bs.modal",function(){
				html.remove();
			});
			
			$.get(
				"user/get-"+row.id,
				function(data){
					data.sex=data.sex?"男":"女";
					$.each(data, function(name,value) {
						html.find("._"+name).append(value);
					});
				},"json"
			);
			
		}
	);
});
