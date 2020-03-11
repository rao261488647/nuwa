
// JavaScript Document
$(document).ready(function() {
		getBasicInfo();

//		$('body').on('hidden.bs.modal', '.modal', function () {
//            console.log("RemoveData before:" + $(this).data("bs.modal"));
//            $(this).removeData("bs.modal");
//            console.log("RemoveData after:" + $(this).data("bs.modal"))
//        });
//		$("#myModal").on('hidden.bs.modal', '.modal', function () {
//			$(this).removeData('bs.modal');
//		});
		$('#myModal').on('hidden.bs.modal', '.modal', function () {
            $(this).removeData('bs.modal');
        });
});

function getBasicInfo(){
	
	$.ajax({
		url:'http://rain.paradise0932.com:7001/stone/index',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		//timeout:2000,//超时
		//请求成功
		success:function(data,status){
			if(data.code == "1"){
				var stoneList = JSON.parse(data.data);
				
				
				var html = "";
				for(var i = 0;i<stoneList.length;i++){
					var stone = stoneList[i];
					html += "<tr>" +
					"<td class=\"highlight\">" +
					"<div class=\"success\"></div>" +
					"<a href=\"javascript:;\"> "+ stone.stoneNo +" </a>" +
					"</td>" +
					"<td class=\"hidden-xs\"> "+ stone.tipInfo +" </td>" +
					"<td> "+ stone.cipherText +" </td>" +
					"<td> "+ translateCode(stone.isDecode) +" </td>" +
					"<td>" +
					"<a href=\"#\" onClick=\"getStoneDetail('"+stone.id+"')\" data-toggle=\"modal\" data-target=\"#myModal\"    class=\"btn btn-outline btn-circle btn-sm purple\">" +
					"<i class=\"fa fa-edit\"></i> 编辑 </a>" +
					"</td>" +
					"</tr>"
				}
				
				$("#tbody").html(html);
			}
//			alert(data.data);
			//alert(status);
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){
			if(textStatus==='timeout'){
				alert('請求超時');
				setTimeout(function(){
					alert('重新请求');
				},2000);
			}
			//alert(errorThrown);
		}
	});

	
}
function translateCode(code){
	var res = "否";
	if(code == "1"){
		res = "是";
	}
	return res;
}


function getStoneDetail(id){
	
	$.ajax({
		url:'http://rain.paradise0932.com:7001/stone/detail',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		data:{"id":id},
		//timeout:2000,//超时
		//请求成功
		success:function(data,status){
			if(data.code == "1"){
				var stone = JSON.parse(data.data);
				$("#id").val(stone.id);
				$("#tipInfo").val(stone.tipInfo);
				$("#cipherText").val(stone.cipherText);
				
//				console.log("data-data:"+data.data);

				$("input[name='isDecode']").removeAttr('checked');
				$("input:radio[value='"+stone.isDecode+"']").attr('checked','true');

	
			}

		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){
			if(textStatus==='timeout'){
				alert('請求超時');
				setTimeout(function(){
					alert('重新请求');
				},2000);
			}
			//alert(errorThrown);
		}
	});

	
}

function saveStone(){
	var id = $("#id").val();
	var tipInfo = $("#tipInfo").val();
	var cipherText = $("#cipherText").val();
	
	var isDecode = $("input[type='radio']:checked").val()
	
	if(tipInfo == ""){
		alert("提示信息不能为空！");
		return false;
	}
	if(cipherText == ""){
		alert("密文不能为空！");
		return false;
	}
	
	$.ajax({
		url:'http://rain.paradise0932.com:7001/stone/save',//地址
		dataType:'json',//数据类型
		type:'POST',//类型
		data:{"id":id,"tipInfo":tipInfo,"cipherText":cipherText,"isDecode":isDecode},
		//timeout:2000,//超时
		//请求成功
		success:function(data,status){
			if(data.code == "1"){
				alert("保存成功");
				window.location.reload();
			}
//			alert(data.data);
			//alert(status);
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){
			if(textStatus==='timeout'){
				alert('請求超時');
				setTimeout(function(){
					alert('重新请求');
				},2000);
			}
			//alert(errorThrown);
		}
	});

	
}