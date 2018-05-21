/*
Track clicks from special elements
Arnan de Gans from AJdG Solutions (http://meandmymac.net, https://ajdg.solutions)
Version: 1.0
With help from: Fraser Munro
Original code: Arnan de Gans
*/
 
/* ------------------------------------------------------------------------------------
*  COPYRIGHT AND TRADEMARK NOTICE
*  Copyright 2008-2015 Arnan de Gans. All Rights Reserved.
*  ADROTATE is a trademark of Arnan de Gans.

*  COPYRIGHT NOTICES AND ALL THE COMMENTS SHOULD REMAIN INTACT.
*  By using this code you agree to indemnify Arnan de Gans from any
*  liability that might arise from it's use.
------------------------------------------------------------------------------------ */

(function($) {
	$(document).ready(function() {
		$(document).on('click', 'a.gofollow', function(){
			var tracker = $(this).attr("data-track");
			var debug = $(this).attr("data-debug");
	
			$.post(click_object.ajax_url, {'action':'adrotate_click','track':tracker});
			if(debug == 1) alert('Tracker: ' + tracker + '\nclick_object.ajax_url: '+click_object.ajax_url);		
		});
	});
}(jQuery));