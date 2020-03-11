
// JavaScript Document
$(document).ready(function() {
		getBasicInfo();
});

function getBasicInfo(){
	
	$.ajax({
		url:'http://rain.paradise0932.com:7001/basic/index',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		//timeout:2000,//超时
		//请求成功
		success:function(data,status){
			if(data.code == "1"){
				var da = JSON.parse(data.data);
				var select0 = da.isJump == "0" ? "selected" : "";
				var select1 = da.isJump == "1" ? "selected" : "";
				var option = "<option value=\"0\" "+select0+" >否</option><option value=\"1\"  "+select1+" >是</option>";
				$("#isJumpSelect").html(option);
				$("#nuwaTip").val(da.nuwaTip);
				$("#id").val(da.id);
				$("#lottoNum").val(da.lottoNum);
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

function saveBasicInfo(){
	var id = $("#id").val();
	var isJump = $("#isJumpSelect").val();
	var nuwaTip = $("#nuwaTip").val();
	var lottoNum = $("#lottoNum").val();
	
	
	if(isJump == ""){
		alert("是否跳转不能为空！");
		return false;
	}
	if(nuwaTip == ""){
		alert("女娲独白不能为空！");
		return false;
	}
	
	$.ajax({
		url:'http://rain.paradise0932.com:7001/basic/save',//地址
		dataType:'json',//数据类型
		type:'POST',//类型
		data:{"id":id,"isJump":isJump,"nuwaTip":nuwaTip,lottoNum:lottoNum},
		//timeout:2000,//超时
		//请求成功
		success:function(data,status){
			if(data.code == "1"){
				alert("保存成功");
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