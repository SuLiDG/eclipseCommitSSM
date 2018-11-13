var searchForm = $("#searchForm");
$("body").on("click", "._do_pwd", function() {
	var row = $(this).data("row");
	$.confirm("您确定要将[" + row.realName + "]的密码设置为123456吗？", function(r) {
		if(r) {
			$.ajax({
				type: "put",
				url: "user/pwd",
				data:{"id":row.id,"pwd":"123456"},
				dataType: "json",
				success: function(data) {
					if(data.ok) {
						$.alert("重置密码成功");
					} else {
						$.error(data.message);
					}
				}
			});
		}
	});
});