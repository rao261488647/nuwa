// JavaScript Document
$(document).ready(function() {
		initFade();
});


function initFade(){
	fadeOutFade.prototype={
		init:	function() {
					var _this=this;
					_this.reset(); 
					var oMenu = _this.oMenu;  
					if(oMenu.style.opacity ==0){  
						//_this.fnShow();   
						//setTimeout(function(){_this.fnHide()}, 1000);  
//						console.log("opacity=0");
					}else{  
						_this.fnHide();  
//						console.log("opacity=1");
						//setTimeout(function(){_this.fnShow()}, 2000);  
					} 
					//setTimeout(function(){_this.init()}, 10000);
				},
		reset:	function(){  
					var _this=this;
					var oMenu =_this.oMenu; 
					var i=_this.i;
					if(i>1){
						oMenu.style.opacity = 1;
						_this.i = 1;
					}else{ 
						oMenu.style.opacity = 0;
						_this.i = 0;
					} 
				}, 
		//直接隐藏
		hide:	function(){  
					var _this=this;
					var oMenu =_this.oMenu; 
					var i=_this.i;
					 
					oMenu.style.opacity = 0;
					_this.i = 0;
					
				}, 
		//渐现
		fnShow:function() {  
//					console.log("show");
					var _this=this;
					var oMenu =_this.oMenu;
					var i=_this.i; 
					if(i < 1){
						_this.i += 0.1; 
						oMenu.style.opacity = i; 
						setTimeout(function(){_this.fnShow()}, 100);
//						console.log("show in currnet value i is :"+i);
					} 
//					console.log("show end");
				},
		//渐隐
		fnHide:function() {
//					console.log("hide");
					var _this=this; 
					var oMenu =_this.oMenu;
					var i=_this.i; 
					if (i > 0.1) {
						_this.i -= 0.1;
						oMenu.style.opacity = i;
						setTimeout(function(){_this.fnHide()}, 100);
//						console.log("hide in");
					} else { 
						oMenu.style.opacity=0; 
//						console.log("hide not in");
					}
//					console.log("hide end");
				}
	}
}

function fadeOutFade(id){
	this.oMenu=document.getElementById(id);
	this.i=1;
}


