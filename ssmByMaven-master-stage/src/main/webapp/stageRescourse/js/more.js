/*
* @Author: 'YY-xiaolei'
* @Date:   2018-01-07 18:36:48
* @Last Modified by:   'YY-xiaolei'
* @Last Modified time: 2018-01-07 18:44:49
*/
window.onload=function(){
	// 学院
	/*let li=document.getElementsByClassName("ml")[0];
	let h4s=$("h4",li);

	for(let i=0;i<h4s.length;i++){
		
		h4s[i].onclick=function(){
			for(let j=0;j<h4s.length;j++){
				h4s[j].className="";
			}
			this.className="hot";
		}
	}*/
	// 专业
	let li1=document.getElementsByClassName("ml1")[0];
	let h42=$("h4",li1);
	for(let i=0;i<h42.length;i++){
		h42[i].onclick=function(){
			for(let j=0;j<h42.length;j++){
				h42[j].className="";
			}
			this.className="hot";
		}
	}
	
	// 方向
	let li2=document.getElementsByClassName("ml2")[0];
	let h43=$("h4",li2);
	for(let i=0;i<h43.length;i++){
		h43[i].onclick=function(){
			for(let j=0;j<h43.length;j++){
				h43[j].className="";
			}
			this.className="hot";
		}
	}
	
	// 年级
	let li3=document.getElementsByClassName("ml3")[0];
	let h44=$("h4",li3);
	for(let i=0;i<h44.length;i++){
		h44[i].onclick=function(){
			for(let j=0;j<h44.length;j++){
				h44[j].className="";
			}
			this.className="hot";
		}
	}
	
	// 类型
	let li4=document.getElementsByClassName("ml4")[0];
	let h45=$("h4",li4);
	for(let i=0;i<h45.length;i++){
		h45[i].onclick=function(){
			for(let j=0;j<h45.length;j++){
				h45[j].className="";
			}
			this.className="hot";
		}
	}
}