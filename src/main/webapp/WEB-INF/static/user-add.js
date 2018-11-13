var searchForm = $("#searchForm");
$("body").on("click", "._add", function() {
	var row = $(this).data("row");
	$.get(
		"user-add.html",
		function(html) {
			var html = $(html).appendTo($("body"));

			html.modal("show");
			html.on("hidden.bs.modal", function() {
				html.remove();
			});

			var s = $("select[name='roleId']").clone().attr("required", "required");
			html.find("._roleId").append(s);

			var form = html.find("form");

			form.submit(function() {

				if(form[0].pwd.value != form[0].pwdConfirm.value) {
					$.error("两次输入的密码不一致");
				}
				
				$.post(
					"user/add",
					form.serialize(),
					function(data){
						if(data.ok){
							$.alert("添加成功");
							searchForm.trigger("submit");
							html.modal("hide");
						}else{
							$.error(data.message);
						}
					},"json"
				);
				
				

				return false;
			});

		}
	);
});