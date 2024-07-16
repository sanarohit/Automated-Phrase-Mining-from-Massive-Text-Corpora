
function get_check_value()
{
   var val=document.deleteform.crid.value;
	if(val)
	{
		if (document.deleteform.crid.checked)
      	{
      	return true;
      	}
      	else
      	{
      		alert("Select A Task");
      		return false;
      	}
	}
	else
	{
		var val=document.deleteform.crid.length;
		if(val==5){
   			if (document.deleteform.crid[0].checked || document.deleteform.crid[1].checked || document.deleteform.crid[2].checked || document.deleteform.crid[3].checked || document.deleteform.crid[4].checked)
      			{return true;}
      		else{alert("Select A Task"); return false;}
      		}
      	else if(val==4){
   			if (document.deleteform.crid[0].checked || document.deleteform.crid[1].checked || document.deleteform.crid[2].checked || document.deleteform.crid[3].checked)
      			{return true;}
      		else{alert("Select A Task"); return false;}
      		}
      	else if(val==3){
   			if (document.deleteform.crid[0].checked || document.deleteform.crid[1].checked || document.deleteform.crid[2].checked )
      			{return true;}
      		else{alert("Select A Task"); return false;}
      		}
      	else{
   			if (document.deleteform.crid[0].checked || document.deleteform.crid[1].checked)
      			{return true;}
      		else{alert("Select A Task"); return false;}
      		}	
 	}
}
  