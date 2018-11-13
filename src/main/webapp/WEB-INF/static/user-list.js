var role = $("select[name='roleId']");
var searchForm = $("#searchForm");
var datagrid = $("#datagrid");
var t1 = datagrid.children().remove();
var pagination = $(".pagination");
var t2 = pagination.children(":eq(1)").remove();

$.get(
	"role/list",
	function(data) {
		$.each(data, function(i, v) {
			var o = $("<option></option>");
			o.text(v.roleName);
			o.val(v.roleId);
			role.append(o);
		});
	}, "json"
);

var loadPage = function(page) {
	var ps = searchForm.serializeArray();
	ps.push({
		"name": "page",
		"value": page
	});
	$.get(
		"user/page",
		ps,
		function(data) {
			formatDataGrid(data);
			formatPagination(data);
		}, "json"
	);
}

searchForm.submit(function() {
	loadPage(1);
	return false;
}).submit();

pagination.on("click", "a[data-page]", function() {
	loadPage($(this).data("page"));
	return false;
});

var formatDataGrid = function(data) {
	datagrid.empty();
	$.each(data.list, function(rowIndex, row) {
		var tr = t1.clone().appendTo(datagrid);
		row.rowNumber = rowIndex + 1;
		row.userLocked = row.userLocked == true ? "锁定" : "正常";
		row.sex = row.sex == true ? "男" : "女";
		//				tr.find("._userName").text(row.userName);
		$.each(row, function(name, value) {
			tr.find("._" + name).text(value);
		});
		tr.find("a").data("row", row);
	});
}

var formatPagination = function(data) {
	pagination.children(":not(:first,:last)").remove();
	
	$.each(data.navigatepageNums,function(i,v){
		var li = t2.clone().insertBefore(pagination.children(":last"));
		li.children().text(v).attr("data-page", v);
		if(v == data.pageNum) {
			li.addClass("active");
		}
	});
	
	pagination.children("li:last").children().attr("data-page", data.pages);
}