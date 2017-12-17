function Preview_DNA_Excel(file) {
	alert("1");
	var jc = $.confirm({
		columnClass : 'col-md-10', 
		title : 'Excel预览',
		content : '<table class="table table-hover table-bordered">'
				+ '<thead>'
				+'<th>DNA编号</th><th>姓名</th><th>性别</th><th>身份证号</th><th>出生日期</th><th>住址</th><th>违法事实</th><th>建档单位</th><th>建档单位</th><th>建档人</th><th>建档时间</th><th>交档时间</th><th>备注</th>'
				+ '</thead>' 
				+ '<tbody>'
				+'<tr><td>562735672365</td>'
				+'<td>补一个色</td>'
				+'<td>男</td>'
				+'<td>3465346535645634</td>'
				+'<td>3465346535645634</td>'
				+'<td>3465346535645634</td>'
				+'<td>3465346535645634</td>'
				+'<td>3465346535645634</td>'
				+'<td>补一个色</td>'
				+'<td>补一个色</td>'
				+'<td>补一个色</td>'
				+'<td>补一个色</td>'
				+'<td>补一个色</td>'
				+'</tr>'
				+ '</tbody>' 
				+ '</table>',
		buttons : {
			创建 : function() {
				var formData = new FormData();
				var xhr = false;
				xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {
							/*
							 * responseText的值为1代表创建成功 2代表创建失败
							 */
							if (xhr.responseText == "1") {
								// jc.close();
								toastr.success("DNA信息录入成功！");
								List_DNA_By_PageAndSearch(1);
							}
						} else {
							toastr.error(xhr.status);
						}
					}
				}
				xhr.open("POST", "/xsjsglxt/DNA/DNAManagement_CreateDNA");
				xhr.send(formData);
			},
			取消 : function() {
				
			}
		},
		onContentReady : function() {

		}
	});

}
