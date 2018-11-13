var searchForm = $("#searchForm");
$("body").on("click", "._do_modify", function() {
	var row = $(this).data("row");
	$.get(
		"user-modify.html",
		function(html) {
			var html = $(html).appendTo($("body"));

			html.modal("show");
			html.on("hidden.bs.modal", function() {
				html.remove();
			});

			var s = $("select[name='roleId']").clone().attr("required", "required");
			html.find("._roleId").append(s);

			$.get(
				"user/get-" + row.id,
				function(data) {
					$.each(data, function(name, value) {
						html.find("[name='" + name + "']").val(value);
					});
					if(data.sex == false) {
						html.find("[name='sex']")[1].checked = true;
					}
				}, "json"
			);

			var form = html.find("form");
			form.submit(function() {
				$.ajax({
					type: "put",
					url: "user/modify",
					data: form.serialize(),
					dataType: "json",
					success: function(data) {
						if(data.ok) {
							$.alert("修改用户信息成功");
							searchForm.trigger("submit");
							html.modal("hide");
						} else {
							$.error(data.message);
						}
					}
				});
				return false;
			});

		}
	);
});