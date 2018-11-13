/**
 * 系统提示对话框,系统错误对话框,系统确认对话框
 */
$.get(
	"dialog.html",
	function(dialog) {
		dialog = $(dialog).appendTo($("body"));
		$.confirm = function(msg, fn) {
			dialog.find(".modal-body").html(msg);
			dialog.modal("show");
			var btn = dialog.find(".modal-footer").children();
			btn.off("click");
			btn.eq(0).click(function() {
				fn(true);
			});
			btn.eq(1).click(function() {
				fn(false);
			});
		}
	}
);
$.alert = function(msg) {
	bootoast({
		message: msg,
		type: 'info',
		position: 'right-bottom',
		timeout: 2
	});
}
$.error = function(msg) {
	bootoast({
		message: msg,
		type: 'danger',
		position: 'right-bottom',
		timeout: 2
	});
}