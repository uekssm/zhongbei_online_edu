$(function(){
	let parent=$(".index_test_btn>li");

	let son = $(".index_test_list>ul");

	for(let i = 0;i < parent.length;i++){
		parent[i].onclick = function(){
			for(let j = 0;j < parent.length;j++){
				parent[j].className = '';
				son[j].style.display = 'none';
			}
			this.className = 'index_test_btnActive';
			son[i].style.display = 'block';
		}
	}


 	var canvas1=document.querySelector("#canvas");
 	var canvas2=document.querySelector("#canvas1");
 	var canvas3=document.querySelector("#canvas2");

 	function progress(canvas,background,color,num){
 		var cobj=canvas.getContext("2d");
	    cobj.lineWidth=8;
	    cobj.strokeStyle=background;
	    cobj.font="12px 宋体";
	    cobj.textAlign="center";
	    cobj.textBaseline="middle";
	    cobj.fillStyle = color;
	    var n=0;
	    var fn;
	    function power(){
			n++;
			if(n>=num){
				cancelAnimationFrame(fn)
			}else{
				fn=requestAnimationFrame(power);
			}
			cobj.clearRect(0,0,67,67);
			cobj.beginPath();
			var angle=(n/100*360-90)*Math.PI/180;
			cobj.arc(33.5,33.5,20,-Math.PI/2,angle);
			cobj.stroke();
			cobj.fillText(n+"%",33.5,33.5);
	   }
	   power();
 	}
 	var background1 = '#4682FE';
 	var color1 = '#4682FE';
 	var background2 = '#29CB6D';
 	var color2 = '#29CB6D';
 	var background3 = '#FFB033';
 	var color3 = '#FFB033';
    progress(canvas1,background1,color1,80);
    progress(canvas2,background2,color2,60);
    progress(canvas3,background3,color3,56);

    var modules = $('.index_module_details');
    var spider = $('.spider');
    spider.css({opacity:0,zIndex:-1});
    modules.on('click',function(){
         spider.css({opacity:1,zIndex:9999});
    })
    

})