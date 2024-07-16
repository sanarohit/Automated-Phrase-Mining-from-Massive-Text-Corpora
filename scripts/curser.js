var trailimage=["./images/Bluebird05-animated-chick_in_flight.gif", 40, 40] //image path, plus width and height
var offsetfrommouse=[7,28] //image x,y offsets from cursor position in pixels. Enter 0,0 for no offset
var displayduration=0 //duration in seconds image should remain visible. 0 for always.

if (document.getElementById || document.all)
document.write('<div id="trailimageid" style="position:absolute;visibility:visible;left:0px;top:0px;width:1px;height:1px"><img src="'+trailimage[0]+'" border="0" width="'+trailimage[1]+'px" height="'+trailimage[2]+'px"></div>')

function gettrailobj(){
if (document.getElementById)
return document.getElementById("trailimageid").style
else if (document.all)
return document.all.trailimagid.style
}

function truebody(){
return (!window.opera && document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
}

function hidetrail(){
gettrailobj().visibility="hidden"
document.onmousemove=""

}

function followmouse(e){
var xcoord=offsetfrommouse[0]
var ycoord=offsetfrommouse[1]
if (typeof e != "undefined"){
xcoord+=e.pageX
ycoord+=e.pageY
}
else if (typeof window.event !="undefined"){
xcoord+=truebody().scrollLeft+event.clientX
ycoord+=truebody().scrollTop+event.clientY
}
var docwidth=document.all? truebody().scrollLeft+truebody().clientWidth : pageXOffset+window.innerWidth-15
var docheight=document.all? Math.max(truebody().scrollHeight, truebody().clientHeight) : Math.max(document.body.offsetHeight, window.innerHeight)
if (xcoord+trailimage[1]+3>docwidth || ycoord+trailimage[2]> docheight)
gettrailobj().display="none"
else 
gettrailobj().display=""
gettrailobj().left=xcoord+"px"
gettrailobj().top=ycoord+"px"
}

document.onmousemove=followmouse

if (displayduration>0)
setTimeout("hidetrail()", displayduration*1000)
