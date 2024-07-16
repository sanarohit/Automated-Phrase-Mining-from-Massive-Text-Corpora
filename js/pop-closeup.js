<!-- Begin POP-UP SIZES AND OPTIONS CODE


// ONLY USE lowercase FOR ALL OPTIONS


// CHANGE ANY OF THESE VARIABLES FOR THE GALLERY POP UPS


var slideshow_button 	= "no"		// SLIDESHOW BUTTON yes/no
var close_button 	= "yes"		// CLOSE BUTTON yes/no

border_color		= "000000"	// PICTURE OUTLINE COLOR

var view_width 		= 600		// GALLERY POPUP WIDTH
var view_height 	= 500       // GALLERY POPUP HEIGHT

var scrollbarS 		= "1"		// TURN ON POPUP SCROLLBARS "1" FOR ON "0" FOR OFF






// COPYRIGHT 2003 © Allwebco Design Corporation
// Unauthorized use or sale of this script is strictly prohibited by law

// YOU DO NOT NEED TO EDIT BELOW THIS LINE

// START SOUND POPUP CODE





function popUp(URL) {
var look='toolbar=0,scrollbars=' + scrollbarS + ',location=0,statusbar=0,menubar=0,resizable=1,width='+view_width+',height='+view_height+','
popwin=window.open("","",look)
popwin.document.open()
popwin.document.write('<title>Image Close Up</title><head>')
popwin.document.write('<link rel=StyleSheet href="corporatestyle.css" type="text/css" media="screen"></head>')
popwin.document.write('<body bgcolor="#FFFFFF" leftmargin=0 rightmargin=0 topmargin=0 bottommargin=0 marginheight=0 marginwidth=0>')
popwin.document.write('<TABLE cellpadding=0 cellspacing=0 border=0 width="100%" height="100%" ><tr><td align="center">')
popwin.document.write('<br>')
popwin.document.write('<TABLE cellpadding="0" cellspacing="0" border="1" bordercolor="#' + border_color + '" style="border-collapse: collapse"><tr><td>')
popwin.document.write('<img src="'+URL+'"><br>')
popwin.document.write('</td></tr></table>')
popwin.document.write('<br>')
popwin.document.write('<TABLE cellpadding="0" cellspacing="0" border="0"><tr><td>')
   if (close_button == "yes") {
popwin.document.write('<form style="margin: 0px"><input type="button" value="Close" onmouseover="this.className=\'buttonon-popups\'" onmouseout="this.className=\'button-popups\'" class="button-popups" onClick=\'self.close()\'>&nbsp;</form>')
}
   if (slideshow_button == "yes") {
popwin.document.write('</td><td>')
popwin.document.write('<form action="slideshow.htm" style="margin: 0px"><input type="submit" value="Slideshow" onmouseover="this.className=\'buttonon-popups\'" onmouseout="this.className=\'button-popups\'" class="button-popups"></form>')
}
popwin.document.write('</td></tr></table>')
popwin.document.write('</td></tr></table>')
popwin.document.write('</body>')
popwin.document.close()
}


// End -->



document.write('<div Class="divstyle" id="info" style=\'display:none;\'>')
document.write('<div id="imagetitle" class="pstyletitle" align="center"></div>')
document.write('</div>')



<!-- Begin SMALL MESSAGES


var IE = document.all?true:false

if (!IE) document.captureEvents(Event.MOUSEMOVE)

document.onmousemove = getMouseXY;

var tempX = 0
var tempY = 0

  
function getMouseXY(e) {
  if (IE) { // grab the x-y pos.s if browser is IE
    tempX = event.clientX + document.body.scrollLeft
    tempY = event.clientY + document.body.scrollTop
  } else {  // grab the x-y pos.s if browser is NS
    tempX = e.pageX
    tempY = e.pageY
  }  
  // catch possible negative values in NS4
  if (tempX < 0){tempX = 0}
  if (tempY < 0){tempY = 0}  
  // show the position values in the form named Show
  // in the text fields named MouseX and MouseY
obj_info = document.getElementById("info")
obj_info.style.top = tempY + 10;
obj_info.style.left = tempX + 10;
  return true
}

function alert_msg(titletext){
obj_info = document.getElementById("info")
obj_info.style.display = '';
obj_imagetitle = document.getElementById("imagetitle");
obj_imagetitle.innerHTML = titletext;

}

function away()
{
obj_info = document.getElementById("info")
obj_info.style.display = 'none';
}


function goToURL() { history.go(-1); }


//  End -->