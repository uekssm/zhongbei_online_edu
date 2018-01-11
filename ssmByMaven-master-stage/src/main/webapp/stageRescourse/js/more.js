/*
* @Author: 'YY-xiaolei'
* @Date:   2018-01-07 18:36:48
* @Last Modified by:   'YY-xiaolei'
* @Last Modified time: 2018-01-07 18:44:49
*/
window.onload=function(){
	// 年级
	let li=document.getElementsByClassName("ml")[0];
	let h4s=$("h4",li);

	for(let i=0;i<h4s.length;i++){
		h4s[i].onclick=function(){
			for(let j=0;j<h4s.length;j++){
				h4s[j].className="";
			}
			this.className="hot";
		}
	}
	// 类型
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
}