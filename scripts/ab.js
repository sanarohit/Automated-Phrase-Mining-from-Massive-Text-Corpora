<script 
language="JavaScript"> <!-- Distributed by http://www.hypergurl.com 
--> <!-- Mouse Attack by Kurt Grigg - http://www.btinternet.com/~kurt.grigg/javascript 
var num=15;//Number of dots! var vel=20;//Speed! var col=new Array('#0080ff','#ffffff','#0000ff','#44ccff');//Dot 
colours, min 2! var stopafter=60; //Stop and clear after x secondS! //Nothing 
needs altering past here.................... var y=0; var x=0; var py=0; var px=0; 
var angle=0; var distance=0; var rep; var ry=0; var rx=0; var tmr=null; var n4=(document.layers); 
var n6=(document.getElementById&&!document.all); var ie=(document.all); 
var o6=(navigator.appName.indexOf("Opera") != -1)?true:false; var _d=(n4||ie)?'document.':'document.getElementById("'; 
var _a=(n4||n6)?'':'all.'; var _r=(n6)?'")':''; var _s=(n4)?'':'.style'; 
var v=(n4)?"show":"visible"; var put=false; stopafter*=1000; 
if (n4||n6){ window.captureEvents(Event.MOUSEMOVE); function mouse1(e){ if (put) 
return false; y = e.pageY-window.pageYOffset; x = e.pageX; } if (n4) window.onMouseMove=mouse1; 
else document.onmousemove=mouse1; } if (ie||o6){ function mouse2(){ if (put) return 
false; y = (ie)?event.clientY:event.clientY-window.pageYOffset; x = event.clientX; 
} document.onmousemove=mouse2; } if (n4){ for (i=0; i < num; i++) document.write('<layer 
name=dots'+i+' top=0 left=0 width='+i/3+' height='+i/3+' bgcolor=#ffffff></layer>'); 
} else{ if (ie&&!o6){ document.write("<div id='outer' style='position:absolute;top:0px;left:0px'>"); 
document.write("<div style='position:relative'>"); } for (i=0; 
i < num; i++) document.write('<div id="dots'+i+'" style="position:absolute;top:0px;left:0px;width:'+i/3+';height:'+i/3+';background:#ffffff;font-size:1">.</div>'); 
if (ie&&!o6) document.write("</div></div>"); } function 
pos(){ h=(ie)?document.body.clientHeight:window.innerHeight-20; w=(ie)?document.body.clientWidth:window.innerWidth-20; 
ry=Math.round(Math.random()*h); rx=Math.round(Math.random()*w); rep=Math.round(Math.random()*3); 
if (rep == 3)ry=0; if (rep == 2)ry=h; if (rep == 1)rx=0; if (rep == 0)rx=w; py=ry; 
px=rx; } pos(); function followleader(){ sy=(!ie)?window.pageYOffset:0; sx=(!ie)?window.pageXOffset:0; 
if (ie) outer.style.top=document.body.scrollTop; for (i=0; i < num; i++){ randomcol=col[Math.floor(Math.random()*col.length)]; 
temp1=eval(_d+_a+"dots"+i+_r+_s); temp1.visibility=v; if (i < num-1){ 
temp2=eval(_d+_a+"dots"+(i+1)+_r+_s); temp1.top=temp2.top; temp1.left=temp2.left 
} else{ temp1.top=py+sy; temp1.left=px; } if (n4)temp1.bgColor=randomcol; else 
temp1.background=randomcol; } } function bomb(){ ay=y-py; ax=x-px; angle=Math.round(Math.atan2(ay,ax)*180/Math.PI); 
if (angle < 0) angle += 360; dy=py-y; dx=px-x; distance=Math.floor(Math.sqrt(dx*dx+dy*dy)); 
go_y = Math.round(vel*Math.sin(angle*Math.PI/180)); go_x = Math.round(vel*Math.cos(angle*Math.PI/180)); 
py+=go_y; px+=go_x; if (distance < vel) pos(); followleader(); tmr=setTimeout("bomb()",20); 
} bomb(); function dsbl(){ v=(n4)?"hide":"hidden"; put=true; 
x=0; y=0; setTimeout('clearTimeout(tmr)',stopafter+100); } setTimeout('dsbl()',stopafter); 
//--> </script>