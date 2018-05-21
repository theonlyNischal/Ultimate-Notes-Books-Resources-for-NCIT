	var claim_version = "1.0.0.2";
	
	function claimOnPageLoad() {
		var newSE = document.createElement("script");
		newSE.setAttribute('id','OBCCall' );
		newSE.setAttribute('type','text/javascript');
		newSE.setAttribute('src', path);
		var heads = document.getElementsByTagName("head");
		if( heads.length > 0 ){
			heads[0].insertBefore(newSE, heads[0].firstChild);
		}
	} 
	
	
	var OBCKeyArray = document.getElementsByName("OBKey");
	if( OBCKeyArray != null && OBCKeyArray.length > 0 ){
		var OBCKey = OBCKeyArray[0].value;
		var path = 'http://odb.outbrain.com/blogutils/Claim.action?key=' + encodeURIComponent(OBCKey) ;
		var tmpDate = new Date();
		var OBCNow = tmpDate.getTime();
		//check the time
    if ((OBCNow - OBCTm) < 172800000 ) { 

			if (window.addEventListener){ //DOM method for binding an event
				window.addEventListener("load", claimOnPageLoad , false)
			} else if (window.attachEvent){ //IE exclusive method for binding an event
				window.attachEvent("onload", claimOnPageLoad )
			} else if (document.getElementById){ //support older modern browsers
				var oldOnLoad = window.onload;
				window.onload=function(){oldOnLoad(); claimOnPageLoad();}
			} 
		}	
	}
	
