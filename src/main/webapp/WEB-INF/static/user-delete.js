var searchForm = $("#searchForm");
$("body").on("click", "._do_del", function() {
	var row = $(this).data("row");
	$.confirm("您确定要删除[" + row.realName + "]吗？", function(r) {
		if(r) {
			$.ajax({
				type: "delete",
				url: "user/del-" + row.id,
				async: true,
				dataType: "json",
				success: function(data) {
					if(data.ok) {
						$.alert("删除成功");
						searchForm.trigger("submit");
					} else {
						$.error(data.message);
					}
				}
			});
		}
	});
});