
// JavaScript Document
$(document).ready(function() {
		getBasicInfo();

		$('#myModal').on('hidden.bs.modal', '.modal', function () {
            $(this).removeData('bs.modal');
        });
});

function getBasicInfo(){
	
	$.ajax({
		url:'http://rain.paradise0932.com:7001/lotto/index',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		//timeout:2000,//超时
		//请求成功
		success:function(data,status){
			if(data.code == "1"){
				var lottoList = JSON.parse(data.data);
				
				
				var html = "";
				for(var i = 0;i<lottoList.length;i++){
					var lotto = lottoList[i];
					html += "<tr>" +
					"<td class=\"highlight\">" +
					"<div class=\"success\"></div>" +
					"<a href=\"javascript:;\"> "+ lotto.id +" </a>" +
					"</td>" +
					"<td class=\"hidden-xs\"> "+ lotto.lottoPrize +" </td>" +
					"<td> "+ translateCode(lotto.status) +" </td>" +
					"<td>" +
					"<a href=\"#\" onClick=\"getlottoDetail('"+lotto.id+"')\" data-toggle=\"modal\" data-target=\"#myModal\"    class=\"btn btn-outline btn-circle btn-sm purple\">" +
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


function getlottoDetail(id){
	
	$.ajax({
		url:'http://rain.paradise0932.com:7001/lotto/detail',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		data:{"id":id},
		//timeout:2000,//超时
		//请求成功
		success:function(data,status){
			if(data.code == "1"){
				var lotto = JSON.parse(data.data);
				$("#id").val(lotto.id);
				$("#lottoPrize").val(lotto.lottoPrize);

				
				console.log("data-data:"+data.data);

				$("input[name='status']").removeAttr('checked');
				$("input:radio[value='"+lotto.status+"']").attr('checked','true');
	
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

function savelotto(){
	var id = $("#id").val();
	var lottoPrize = $("#lottoPrize").val();

	var status = $("input[type='radio']:checked").val()
	
	if(lottoPrize == ""){
		alert("奖品名称不能为空！");
		return false;
	}

	$.ajax({
		url:'http://rain.paradise0932.com:7001/lotto/save',//地址
		dataType:'json',//数据类型
		type:'POST',//类型
		data:{"id":id,"lottoPrize":lottoPrize,"status":status},
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