/* Setting the s_account */
function s_setAccount(){

var s_account="";

var curUrl = location.href;
	
		if(curUrl.indexOf("fmwdocs.us.oracle.com") != -1 ) {
				s_account = "oracledevall,oracledevdocs";
		}
		else {
				s_account = "oracledocs";
		}
		
		return s_account;
		
	}

function s_prePlugins(s){

	var arr=location.href.split('/');
	s.pageName = arr[3]+':';
	s.channel = arr[3]+':';
	
	for(i=4;i<=arr.length-1;i++) {
		s.pageName+=arr[i] + ((i==arr.length-1)?'':'/');
	} 
     if ( s.pageName.indexOf("index.html") != -1 )
	s.pageName=s.pageName.replace(/index\.html$/,"");
	if ( s.pageName.indexOf("index.htm") != -1 )
	s.pageName=s.pageName.replace(/index\.htm$/,"");
	
	for(i=4;i<=arr.length-2;i++) {
	s.channel+=arr[i] + ((i==arr.length-2)?'':'/');
	} 
}
function navTrack(sitename,language,pagearea,linklabel)
{
var linkvalue ='';
linkvalue = (typeof(sitename) != 'undefined'  || sitename != '') ? (sitename)  : '';
linkvalue = (typeof(language) != 'undefined' || language != '') ? (linkvalue + ':' + language)  : linkvalue;
linkvalue = (typeof(pagearea) != 'undefined' || pagearea != '') ? (linkvalue + ':' + pagearea)  : linkvalue;
linkvalue = (typeof(linklabel) != 'undefined' || linklabel != '') ? (linkvalue + ':' + linklabel) : linkvalue;
linkvalue = linkvalue.toLowerCase();
  if (linkvalue != '') {   
  
	var s=s_gi(s_setAccount()); 
	s.prop22 = linkvalue;
	s.linkTrackVars="prop22";
	s.tl(this,'o',linkvalue); 
	// Set after previous image is sent to server.
	s_objectID = linkvalue;
	// unset s.prop22 and s.linkTrackVars variable
	s.prop22 = '';
	s.linkTrackVars='';
  }
}