
// JavaScript Document
$(document).ready(function() {
	

});
/**
 * 使用get方式弹出模态窗体展示页面 增加随机数，防止ie缓存
 * @param id   模态窗体div id
 * @param url 要跳转的地址
 */
function goJumpUrl(id,url){
    //此处是为了防止IE缓存，将具体请求url后面增加随机数
    if(url.indexOf("?") != -1){
        url+="&";
    }else{
        url+="?";
    }
    url+="b="+Math.random();
    $.get(url, function(data) {
        $('#'+id+'').html('');
        $('#'+id+'').html(data);
    });
}



