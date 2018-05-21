//depend on mtqid
var mtq_current_question = [] ;
var mtq_total_questions = [] ;
var mtq_ui_questions = [] ;
var mtq_current_score = [] ;
var mtq_max_score = [] ;
var mtq_score_percent = [] ;
var mtq_questions_answered = [] ;
var mtq_questions_correct = [] ;
var mtq_problems_attempted = [] ;
var mtq_questions_wrong = [] ;
var mtq_questions_not_attempted = [];
var	mtq_answer_display = [] ;
var	mtq_single_page = [] ;
var	mtq_show_hints = [] ;
var	mtq_show_start = [] ;
var	mtq_show_final = [] ;
//var mtq_extra_page = [] ;
var mtq_show_list = [] ;
var mtq_show_stamps = [] ;
var	mtq_multiple_chances = [] ;
var mtq_quiz_finished = [] ;
var mtq_exit_warning = [] ;
var mtq_quiz_started = [] ;
var mtq_display_number = [] ;
var mtq_first_show = [];
var mtq_view_anchor = [];
var mtq_gf_present = [];
var mtq_quiz_in_form = [];
var mtq_cf7_present = [];
var mtq_timer_val = [];
var mtq_timer_initial_val = [];
var mtq_timer_on = [];
var mtq_autoadvance = [];
var mtq_autosubmit = [];
var mtq_scoring_option = [];
var mtq_vform = [];

//Not dependent on mtqid
var mtq_quizzes_present = [];
var mtq_current_window_width;
var	mtq_have_completed_string = "";
var	mtq_questions_string = "";
var	mtq_your_score_is_string = "";
var mtq_correct_string = "Correct";
var mtq_wrong_string = "Wrong";
var mtq_partial_string = "Partial-Credit";
var mtq_exit_warning_string ="You have not finished your quiz. If you leave this page, your progress will be lost.";
var mtq_correct_answer_string='Correct Answer';
var mtq_you_selected_string='You Selected';
var mtq_not_attempted_string='Not Attempted';
var mtq_final_score_on_quiz_string='Final Score on Quiz';
var mtq_attempted_questions_correct_string='Attempted Questions Correct';
var mtq_attempted_questions_wrong_string='Attempted Questions Wrong';
var mtq_questions_not_attempted_string='Questions Not Attempted';
var mtq_total_questions_on_quiz_string='Total Questions on Quiz';
var mtq_question_details_string='Question Details';
var mtq_quiz_results_string='Results';
var mtq_date_string='Date';
var mtq_question_string='Question';
var mtq_score_string='Score';
var mtq_time_allowed_string='Time allowed';
var mtq_minutes_string='minutes';
var mtq_seconds_string='seconds';
var mtq_time_used_string='Time used';
var mtq_answer_choices_selected_string='Answer Choice(s) Selected';
var mtq_question_text_string='Question Text';
var mtq_hint_string='Hint';


window.onbeforeunload = function() {
	var N = mtq_quizzes_present.length;
  	var count;
	var triggered = false;
	for(count=0;count<N;count++){
		if (mtq_exit_warning[N] && mtq_quiz_started[N] && ! mtq_quiz_finished[N] && !triggered) {
    		return mtq_exit_warning_string;
			triggered=true;
  		}
	}
}

function mtq_scroll_anchor(mtqid){
	
	if ( mtq_view_anchor[mtqid] ){
		var whereTo=jQuery("#mtq_view_anchor-"+mtqid).offset().top;
		jQuery('html,body').animate({scrollTop: whereTo},'fast');
	}
    
}

function mtq_start_timer(mtqid){
	if ( mtq_timer_on[mtqid] ) {
		mtq_timer_val[mtqid] = parseInt(jQuery("#mtq_timer_val-"+mtqid).val());
		mtq_timer_val[mtqid] = mtq_timer_val[mtqid] -1;
		min = Math.floor(mtq_timer_val[mtqid]/60);
		sec = mtq_timer_val[mtqid]-min*60;
		if ( sec <= 9 ) {
			sec = "0"+sec;	
		}
		jQuery("#mtq_timer_box-"+mtqid).html(min + ":"+sec);
		jQuery("#mtq_timer_val-"+mtqid).val(mtq_timer_val[mtqid])
		if ( mtq_timer_val[mtqid] > 0 ) {
			t=setTimeout("mtq_start_timer("+mtqid+")",1000);
		} else {
			mtq_get_results(mtqid);
		}
	}
}


function mtq_resize(){
   if (mtq_current_window_width != window.innerWidth ) {
   		mtq_current_window_width = window.innerWidth;
		mtq_resize_quizzes();
   		//alert("Resized");
   }
};

function mtq_resize_one_quiz(mtqid) {
	if ( ! mtq_single_page[mtqid] ){
		var newWidth =jQuery("#mtq_quiz_area-"+mtqid).parent().width();
		jQuery("div.mtq_scroll_item-"+mtqid).css('width',newWidth);
		mtq_jump_question(mtq_current_question[mtqid],mtqid);
	}
	//var TheApi = jQuery(".mtqscrollable:eq("+mtqid+")");
	//jQuery("#mtq_scroll_container-"+mtqid).data("mtqscrollable").mtq_seekTo(TheApi.data("mtqscrollable").getIndex(),0);
}

function mtq_resize_quizzes(){
	
	var N = mtq_quizzes_present.length;
	//jQuery("input:hidden[name=mtq_id_value]").each(function(){
    //	mtq_quizzes_present.push(jQuery(this).val());
	//	N++;
	//});
	
	var count;
	
	for (count=0;count<N;count++){
		if ( ! mtq_single_page[mtq_quizzes_present[count]] ){
			var newWidth =jQuery("#mtq_quiz_area-"+mtq_quizzes_present[count]).parent().width();
			jQuery("div.mtq_scroll_item-"+mtq_quizzes_present[count]).css('width',newWidth);
			//var TheApi = jQuery(".mtqscrollable:eq("+count+")");
			//jQuery("#mtq_scroll_container-"+mtq_quizzes_present[count]).data("mtqscrollable").mtq_seekTo(TheApi.data("mtqscrollable").getIndex(),0);
			mtq_resize_one_quiz(mtq_quizzes_present[count]);
		}
	}
	
}

function mtq_init() {
	mtq_current_window_width=window.innerWidth;
	jQuery(window).resize(function(e) {
		mtq_resize();
	});
	jQuery(function() {
		//var api = jQuery(".mtqscrollable").mtqscrollable({ circular: false, touch: false });
		//var StartIndex;
		//var StopIndex;
		//var mtqid;
		
		//var count;
		//for (count=0;count<api.length;count++) {
//			var TheApi = jQuery(".mtqscrollable:eq("+count+")");
//			TheApi.bind("mtq_onBeforeSeek",function() {
//				StartIndex=TheApi.data("mtqscrollable").getIndex();
//			});
//			
//			TheApi.bind("mtq_onBeforeSeek",function(targetIndex) {
//				StopIndex=targetIndex;//=TheApi.data("mtqscrollable").getIndex();
//			});
//		}
			
		//api.bind("mtq_onSeek",function() {
//			var StopQuestion=StopIndex.target.getIndex()+1;
//			var NewHeight;
//			var divName=StopIndex.target.getItemWrap().context.id;
//			var lastHyphen = divName.lastIndexOf("-");
//			var theLength = divName.length;
//			mtqid = divName.substr(lastHyphen+1,theLength);	
//			//var currHeight = jQuery("#mtq_scroll_container-"+mtqid).height();
//			if ( StopQuestion <= mtq_total_questions[1] ){
//				NewHeight=jQuery("#mtq_question-"+StopQuestion+"-"+mtqid).height()+5;
//			} else {
//				NewHeight=jQuery("#mtq_results_request-"+mtqid).height()+5;
//			}
//			
//			jQuery("#mtq_scroll_container-"+mtqid).animate({height:NewHeight});
//			mtq_scroll_anchor(mtqid);
//			
//		});
	});

	var N = 0;
	jQuery("input:hidden[name=mtq_id_value]").each(function(){
    	mtq_quizzes_present.push(jQuery(this).val());
		N++;
	});
	
	if ( N>=1 ) {
		mtq_have_completed_string = jQuery("#mtq_have_completed_string").html();
		mtq_question_string = jQuery("#mtq_question_string").html();
		mtq_questions_string = jQuery("#mtq_questions_string").html();
		mtq_your_score_is_string = jQuery("#mtq_your_score_is_string").html();
		mtq_correct_string = jQuery("#mtq_correct_string").html();
		mtq_wrong_string = jQuery("#mtq_wrong_string").html();
		mtq_partial_string = jQuery("#mtq_partial_string").html();
		mtq_exit_warning_string = jQuery("#mtq_exit_warning_string").html();
		mtq_correct_answer_string=jQuery('#mtq_correct_answer_string').html();
		mtq_you_selected_string=jQuery('#mtq_you_selected_string').html();
		mtq_not_attempted_string=jQuery('#mtq_not_attempted_string').html();
		mtq_final_score_on_quiz_string=jQuery('#mtq_final_score_on_quiz_string').html();
		mtq_attempted_questions_correct_string=jQuery('#mtq_attempted_questions_correct_string').html();
		mtq_attempted_questions_wrong_string=jQuery('#mtq_attempted_questions_wrong_string').html();
		mtq_questions_not_attempted_string=jQuery('#mtq_questions_not_attempted_string').html();
		mtq_total_questions_on_quiz_string=jQuery('#mtq_total_questions_on_quiz_string').html();
		mtq_question_details_string=jQuery('#mtq_question_details_string').html();
		mtq_quiz_results_string=jQuery('#mtq_quiz_results_string').html();
		mtq_date_string=jQuery('#mtq_date_string').html();
		mtq_time_allowed_string=jQuery('#mtq_time_allowed_string').html();
		mtq_minutes_string=jQuery('#mtq_minutes_string').html();
		mtq_seconds_string=jQuery('#mtq_seconds_string').html();
		mtq_time_used_string=jQuery('#mtq_time_used_string').html();
		mtq_answer_choices_selected_string=jQuery('#mtq_answer_choices_selected_string').html();
		mtq_question_text_string=jQuery('#mtq_question_text_string').html();
		mtq_question_hint_string=jQuery('#mtq_hint_string').html();
		
		mtq_correct_answer_string=mtq_correct_answer_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_you_selected_string=mtq_you_selected_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_not_attempted_string=mtq_not_attempted_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_final_score_on_quiz_string=mtq_final_score_on_quiz_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_attempted_questions_correct_string=mtq_attempted_questions_correct_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_attempted_questions_wrong_string=mtq_attempted_questions_wrong_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_questions_not_attempted_string=mtq_questions_not_attempted_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_total_questions_on_quiz_string=mtq_total_questions_on_quiz_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_question_details_string=mtq_question_details_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_quiz_results_string=mtq_quiz_results_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_date_string=mtq_date_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_question_string=mtq_question_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_score_string=mtq_score_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_time_allowed_string=mtq_time_allowed_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_minutes_string=mtq_minutes_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_seconds_string=mtq_seconds_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_time_used_string=mtq_time_used_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_answer_choices_selected_string=mtq_answer_choices_selected_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_question_text_string=mtq_question_text_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
		mtq_question_hint_string=mtq_question_hint_string.replace(/(\r\n|\n|\r)/gm,'').replace(/^\s+|\s+$/g,'');
	}

	var j;
	for (j = 0; j<= N-1; j++){
		//alert(parseInt(mtq_quizzes_present[j]));
		mtq_start_one(parseInt(mtq_quizzes_present[j]));
		
	}
}

function mtq_set_height(q,mtqid) {
	//var OldHeight =jQuery("#mtq_scroll_container-"+mtqid).height();
	var NewHeight;
	if(mtq_total_questions[mtqid]< mtq_ui_questions[mtqid] &&  q == mtq_ui_questions[mtqid] ) {
		NewHeight=jQuery("#mtq_results_request-"+mtqid).height();
	} else {
	 	NewHeight=jQuery("#mtq_question-"+q+"-"+mtqid).height();
	}
	jQuery("#mtq_scroll_container-"+mtqid).animate({height:NewHeight});
}

function mtq_start_one(mtqid) {
	var newWidth =jQuery("#mtq_quiz_area-"+mtqid).parent().width();
	jQuery("div.mtq_scroll_item-"+mtqid).css('width',newWidth);
	jQuery("#mtq_quiz_results_bubble-"+mtqid).css('display','none');
	
	mtq_set_height(1,mtqid);		
	mtq_current_question[mtqid] = 1;
	mtq_total_questions[mtqid] = 0;
	mtq_ui_questions[mtqid] = 0;
	mtq_current_score[mtqid] = 0;
	mtq_max_score[mtqid] = 0;
	mtq_score_percent[mtqid] = 0;
	mtq_questions_answered[mtqid] = 0;
	mtq_questions_correct[mtqid] = 0;
	mtq_problems_attempted[mtqid] = 0;
	mtq_questions_wrong[mtqid] = 0;
	mtq_questions_not_attempted[mtqid]=0;

	mtq_quiz_finished[mtqid] = false;
	mtq_exit_warning[mtqid] = false;
	mtq_quiz_started[mtqid] = false;
	mtq_first_show[mtqid] = true;
	mtq_view_anchor[mtqid] = jQuery("#mtq_view_anchor-"+mtqid).length;

	jQuery("#mtq_javawarning-"+mtqid).css('display','none');
	mtq_answer_display[mtqid] = parseInt(jQuery("#mtq_answer_display-"+mtqid).val());
	mtq_single_page[mtqid] = parseInt(jQuery("#mtq_single_page-"+mtqid).val());
	mtq_show_hints[mtqid] = parseInt(jQuery("#mtq_show_hints-"+mtqid).val());
	mtq_show_start[mtqid] = parseInt(jQuery("#mtq_show_start-"+mtqid).val());
	mtq_show_final[mtqid] = parseInt(jQuery("#mtq_show_final-"+mtqid).val());
	mtq_show_stamps[mtqid]= parseInt(jQuery("#mtq_show_stamps-"+mtqid).val());
	mtq_exit_warning[mtqid] = parseInt(jQuery("#mtq_show_alerts-"+mtqid).val());
	mtq_multiple_chances[mtqid] = parseInt(jQuery("#mtq_multiple_chances-"+mtqid).val());
	mtq_total_questions[mtqid] = parseInt(jQuery("#mtq_total_questions-"+mtqid).val()); //jQuery(".mtq_question").length;
	mtq_ui_questions[mtqid]=mtq_total_questions[mtqid];
	mtq_display_number[mtqid]  = parseInt(jQuery("#mtq_display_number-"+mtqid).val());
	var mtq_proofread  = parseInt(jQuery("#mtq_proofread-"+mtqid).val());
	mtq_show_list[mtqid] =  parseInt(jQuery("#mtq_show_list_option-"+mtqid).val());
	mtq_autoadvance[mtqid] = parseInt(jQuery("#mtq_autoadvance-"+mtqid).val());
	mtq_autosubmit[mtqid] = parseInt(jQuery("#mtq_autosubmit-"+mtqid).val());
	mtq_scoring_option[mtqid] = parseInt(jQuery("#mtq_scoring-"+mtqid).val());
	mtq_vform[mtqid] = parseInt(jQuery("#mtq_vform-"+mtqid).val());
	//mtq_extra_page[mtqid] = 0;
	mtq_timer_on[mtqid] = 0;
	if ( mtq_show_final[mtqid] || mtq_answer_display[mtqid] != 0 ) {
		//mtq_extra_page[mtqid] = 1;
		mtq_ui_questions[mtqid]++;
	}
	
	if (! mtq_show_start[mtqid] || mtq_proofread ){
		mtq_start_quiz(mtqid);	
	} else
	{
		jQuery("#mtq_instructions-"+mtqid).css('display','block');
		jQuery("#mtq_start_button-"+mtqid).css('display','block');	
	}
		
		mtq_gf_present[mtqid]=parseInt(jQuery("#mtq_gf_present-"+mtqid).val());
		mtq_cf7_present[mtqid]=parseInt(jQuery("#mtq_cf7_present-"+mtqid).val());
		mtq_quiz_in_form[mtqid]=parseInt(jQuery("#mtq_quiz_in_form-"+mtqid).val());
}

function mtq_animate_question(q,mtqid) {
	wid=jQuery("#mtq_question-1-"+mtqid).width();
	pos= (q-1)* wid * -1;
	jQuery("#mtq_scroll_items_container-"+mtqid).animate({left: pos +'px'});	
	mtq_current_question[mtqid] = q;
	mtq_set_height(q,mtqid);
	mtq_check_arrows(mtqid);
	mtq_scroll_anchor(mtqid);
}

function mtq_jump_question(q,mtqid) {
	wid=jQuery("#mtq_question-1-"+mtqid).width();
	pos= (q-1)* wid * -1;
	jQuery("#mtq_scroll_items_container-"+mtqid).css({left: pos +'px'});	
	mtq_current_question[mtqid] = q;
	mtq_set_height(q,mtqid);
	mtq_check_arrows(mtqid);
	mtq_scroll_anchor(mtqid);
}

function mtq_check_arrows(mtqid) {
	if (mtq_current_question[mtqid]+1 <= mtq_ui_questions[mtqid]) {
		jQuery("#mtq_next_button-"+mtqid).show();
	} else {
		jQuery("#mtq_next_button-"+mtqid).hide();
	}
	
	if (mtq_current_question[mtqid]-1 >=1) {
		jQuery("#mtq_back_button-"+mtqid).show();
	} else {
		jQuery("#mtq_back_button-"+mtqid).hide();
	}
}

function mtq_next_nav(mtqid) {
	if (mtq_current_question[mtqid]+1 <= mtq_ui_questions[mtqid]) {
		mtq_animate_question(mtq_current_question[mtqid]+1,mtqid);
	}
}

function mtq_back_nav(mtqid) {
	if (mtq_current_question[mtqid]-1 >=1) {
		mtq_animate_question(mtq_current_question[mtqid]-1,mtqid);
	}
}

function mtq_start_quiz(mtqid){
		mtq_current_question[mtqid] = 1;
		jQuery("#mtq_instructions-"+mtqid).css('display','none');
		jQuery("#mtq_start_button-"+mtqid).css('display','none');
		jQuery("#mtq_quiz_status-"+mtqid).css('display','block');
		jQuery("#mtq_listrow-"+mtqid).css('display','block');
		jQuery("#mtq_question_container-"+mtqid).css('display','block');
		
		if ( mtq_show_start[mtqid] && !mtq_single_page[mtqid] ){
			//jQuery("#mtq_scroll_container-"+mtqid).data("mtqscrollable").mtq_seekTo(0,0);
			q1_height=jQuery("#mtq_question-1-"+mtqid).height();
			jQuery("#mtq_scroll_container-"+mtqid).animate({height: q1_height +'px'});//animate("height",500);
			//mtq_jump_question(1,mtqid);
		}
		//mtq_resize_one_quiz(mtqid);
		mtq_quiz_started[mtqid] = true;
		if ( parseInt(jQuery("#mtq_timer_val-"+mtqid).val()) > 0 ) {
			mtq_timer_on[mtqid] = 1;
			mtq_timer_initial_val[mtqid]=parseInt(jQuery("#mtq_timer_val-"+mtqid).val());
			mtq_start_timer(mtqid);	
		}
		mtq_check_arrows(mtqid);
		//mtq_ShowBatch(mtqid);
}

function mtq_show_nav(mtqid) {
	jQuery("#mtq_question_container-"+mtqid).css('display','none');
	//jQuery("#mtq_navigator-"+mtqid).slideDown();
	jQuery("#mtq_navigator-"+mtqid).css('display','block');
		
}

function mtq_nav_click(q,mtqid) {
	jQuery("#mtq_navigator-"+mtqid).css('display','none');
	//jQuery("#mtq_navigator-"+mtqid).slideUp();
	jQuery("#mtq_question_container-"+mtqid).css('display','block');
	//jQuery("#mtq_scroll_container-"+mtqid).data("mtqscrollable").mtq_seekTo(q-1,0);
	if ( q> 0 ) {
		mtq_jump_question(q,mtqid);	
	} else {
		mtq_jump_question(mtq_current_question[mtqid],mtqid);
	}
}

function mtq_results_message(mtqid){
	
	//if ( mtq_gf_present[mtqid] || mtq_cf7_present[mtqid] ) {
	//	theClonedForm=jQuery("#mtq_contact_form-"+mtqid).clone(true);
	//} 
	
	var ResultsMsg = jQuery("#mtq_quiz_results-"+mtqid).html();
	var numRatings = parseInt(jQuery("#mtq_num_ratings-"+mtqid).val());
	//var safeRating = '';
	var j=1;
	for(j=numRatings;j>0;j--){
		var rating_score = parseInt(jQuery("#mtq_ratingval-"+j+"-"+mtqid).val());
		if (mtq_score_percent[mtqid].toFixed(0) >= rating_score ) {
			var rating_message = jQuery("#mtq_rating-"+j+"-"+mtqid).html();
			ResultsMsg = ResultsMsg.replace(/%%RATING%%/gi,rating_message); // gotta do this
			break;
		}
	}
	var mtq_quiz_name;
	mtq_quiz_name=jQuery("#mtq_quiztitle-"+mtqid).text();
	ResultsMsg=ResultsMsg.replace(/%%QUIZ_NAME%%/gi,mtq_quiz_name);
	
	ResultsMsg=ResultsMsg.replace(/%%SCORE%%/gi,mtq_questions_correct[mtqid]);
	ResultsMsg=ResultsMsg.replace(/%%TOTAL%%/gi,mtq_total_questions[mtqid]);
	ResultsMsg=ResultsMsg.replace(/%%WRONG_ANSWERS%%/gi,mtq_total_questions[mtqid]-mtq_questions_correct[mtqid]);
	ResultsMsg=ResultsMsg.replace(/%%PERCENTAGE%%/gi,mtq_score_percent[mtqid].toFixed(0)+"%");
	
	ResultsMsg=ResultsMsg.replace(/%%TIME_USED%%/gi,mtq_timer_initial_val[mtqid]-mtq_timer_val[mtqid]);
	ResultsMsg=ResultsMsg.replace(/%%TIME_ALLOWED%%/gi,mtq_timer_initial_val[mtqid]);
	
	//Determine if a form should be added
	var mtq_addForm = false;
	if ( ResultsMsg.search(/%%FORM%%/i) != -1 ) {
		if ( mtq_gf_present[mtqid] || mtq_cf7_present[mtqid] ) {
			ResultsMsg=ResultsMsg.replace(/%%FORM%%/gi,'');
			mtq_addForm= true;
			
		} else {
			ResultsMsg=ResultsMsg.replace(/%%FORM%%/gi,"*** mTouch Quiz Forms Addon Not Properly Configured ***");
			//jQuery("#mtq_contact_form-"+mtqid).remove();
		}
	} else {
		jQuery("#mtq_contact_form-"+mtqid).remove();	
	}
	
	jQuery("#mtq_quiz_results-"+mtqid).html(ResultsMsg);
	//if (mtq_addForm ) {
	//	if ( mtq_gf_present[mtqid] || mtq_cf7_present[mtqid] ) {
	//		jQuery("#mtq_quiz_results-"+mtqid).append(theClonedForm);
	//	}
	//}
}

function mtq_gf_fill_form(results_message,mtqid){
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq').find('textarea').val(results_message);
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_score').find('input').val(mtq_questions_correct[mtqid]);
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_total').find('input').val(mtq_total_questions[mtqid]);
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_percentage').find('input').val(mtq_score_percent[mtqid].toFixed(0));
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_wrong_answers').find('input').val(mtq_total_questions[mtqid]-mtq_questions_correct[mtqid]);
	if (mtq_timer_initial_val[mtqid] >0 ) {
		jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_time_allowed').find('input').val(mtq_timer_initial_val[mtqid]);
		jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_time_used').find('input').val(mtq_timer_initial_val[mtqid]-mtq_timer_val[mtqid]);
	} else {
		jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_time_allowed').find('input').val(1);
		jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_time_used').find('input').val(1);
	}
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_quiz_name').find('input').val(jQuery("#mtq_quiztitle-"+mtqid).text());
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_auto').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_score').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_total').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_percentage').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_wrong_answers').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_time_allowed').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_time_used').css('display','none');
	jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq_quiz_name').css('display','none');
}

function mtq_get_results(mtqid){
	
	mtq_quiz_finished[mtqid] = true;
	mtq_timer_on[mtqid] = 0;
	mtq_time_allowed_message='';
	mtq_time_used_message='';
	mtq_time_used_val='';
	mtq_time_message='';
	if (mtq_timer_initial_val[mtqid] > 0 ) {
		mtq_time_used_val=mtq_timer_initial_val[mtqid]-mtq_timer_val[mtqid];
		
		min = Math.floor(mtq_time_used_val/60);
		sec = mtq_time_used_val-min*60;

		mtq_time_used_message=mtq_time_used_string+ ": " + min + " "+mtq_minutes_string+", " + sec + " "+mtq_seconds_string+".\n";
		
		min = Math.floor(mtq_timer_initial_val[mtqid]/60);
		sec = mtq_timer_initial_val[mtqid]-min*60;

		mtq_time_allowed_message= mtq_time_allowed_string+": " + min + " "+mtq_minutes_string+", " + sec + " "+mtq_seconds_string+".\n";
		mtq_time_message= mtq_time_allowed_message+ mtq_time_used_message;
	}
	
	
	mtq_email_results = '';
	mtq_email_results_itemized = '';
	mtq_email_results_verbose = '';
	mtq_email_results_correct_answer='';
	mtq_email_results_selected_answer='';
	//Hide a bunch of stuff
	//jQuery("#mtq_next_button-"+mtqid).css('display','none');
	//jQuery("#mtq_back_button-"+mtqid).css('display','none');
	//jQuery("#mtq_start_button-"+mtqid).css('display','none');
	jQuery("#mtq_quiz_status-"+mtqid).css('display','none');
	//jQuery("#mtq_instructions-"+mtqid).css('display','none');
	if ( !mtq_single_page[mtqid] ) {
		//jQuery("#mtq_scroll_container-"+mtqid).data("mtqscrollable").mtq_seekTo(0,0);
		mtq_ui_questions[mtqid]=mtq_total_questions[mtqid];
		jQuery("#mtq_list_item-end-"+mtqid).css('display','none');
		jQuery("#mtq_shaded_item_msg-"+mtqid).css('display','none');
		mtq_jump_question(1,mtqid);
	}
	jQuery("#mtq_results_request-"+mtqid).remove();//css('display','none');
	//jQuery("#mtq_listrow-"+mtqid).css('display','none');
	//jQuery("#mtq_results_request-"+mtqid).css('display','none');

	var q=1;
	mtq_problems_attempted[mtqid]=0;
	for (q = 1; q <= mtq_total_questions[mtqid]; q++) // Mark every problem as complete
	{
		jQuery("#mtq_is_answered-"+q+"-"+mtqid).val(1);
		var number_answers =parseInt(jQuery("#mtq_num_ans-"+q+"-"+mtqid).val());
		var N = parseInt(number_answers);
		var attempted_this_one = 0;
		var a=1;
		var mtq_explanation_text='';
		mtq_explanation_text=jQuery("#mtq_question_explanation-"+q+"-"+mtqid).text()+"\n";;
		mtq_email_results_itemized += mtq_question_string.substr(0,1).toUpperCase()+mtq_question_string.substr(1)+" "+q+" "+mtq_score_string+": ";
		mtq_email_results_correct_answer='';
		mtq_email_results_selected_answer='';
		answer_order = [];
		var multi_answer_select_count = 0;
		for (a = 1; a<= N; a++){
			var ever_selected = parseInt(jQuery("#mtq_was_ever_selected-"+q+"-"+a+"-"+mtqid).val());
			var end_selected = parseInt(jQuery("#mtq_was_selected-"+q+"-"+a+"-"+mtqid).val());
			var is_correct_answer = parseInt(jQuery("#mtq_is_correct-"+q+"-"+a+"-"+mtqid).val());
			if ( number_answers==1 ) {
				answer_order[ever_selected] = a;
			} else {
				if (ever_selected || end_selected ) {
				multi_answer_select_count++;
				answer_order[multi_answer_select_count] = a;	
				}
			}
			if ( ( ever_selected || end_selected ) && mtq_answer_display[mtqid] == 2 )	{
				jQuery("#mtq_row-"+q+"-"+a+"-"+mtqid).addClass("mtq_selected_row");
				attempted_this_one = 1;
			} else if ( end_selected && mtq_answer_display[mtqid] != 2 ) {
				jQuery("#mtq_row-"+q+"-"+a+"-"+mtqid).addClass("mtq_selected_row");
				attempted_this_one = 1;
			}
			
			if ( is_correct_answer == 1) {
				mtq_email_results_correct_answer=mtq_email_results_correct_answer+mtq_correct_answer_string+": "+jQuery("#mtq_answer_text-"+q+"-"+a+"-"+mtqid).text()+"\n";
			}
			
			if ( mtq_answer_display[mtqid] != 0 ){
				jQuery("#mtq_marker-"+q+"-"+a+"-"+mtqid).css('display','block');
				jQuery("#mtq_button-"+q+"-"+a+"-"+mtqid).css('display','none');
			}
		}
		
		mtq_problems_attempted[mtqid]+=attempted_this_one;
		mtq_email_results_verbose=jQuery("#mtq_question_text-"+q+"-"+mtqid).text();
		answer_print = '';
		if ( attempted_this_one ) {
			
			for ( a = 1; a<answer_order.length; a++ ) {
				answer_print=answer_print+","+answer_order[a];
				mtq_email_results_selected_answer=mtq_email_results_selected_answer+mtq_you_selected_string+": " + jQuery("#mtq_answer_text-"+q+"-"+answer_order[a]+"-"+mtqid).text()+"\n";
				if (parseInt(jQuery("#mtq_has_hint-"+q+"-"+answer_order[a]+"-"+mtqid).val())==1 ) {
					mtq_email_results_selected_answer=mtq_email_results_selected_answer+ jQuery("#mtq_hint-"+q+"-"+answer_order[a]+"-"+mtqid).text()+"\n";
				}
			}
			answer_print = answer_print.substr(1);
			
		} else {
			answer_print = mtq_not_attempted_string;
		}
		
		
		
		jQuery("#mtq_question-" + q+"-"+mtqid).css('display','block');
		var points_possible = parseInt(jQuery("#mtq_is_worth-"+q+"-"+mtqid).val());
		var points_awarded = parseInt(jQuery("#mtq_points_awarded-"+q+"-"+mtqid).val());
		mtq_email_results_itemized+=points_awarded+"/"+points_possible+"\n";
		mtq_email_results_itemized+=mtq_answer_choices_selected_string+": "+answer_print+"\n";
		if ( mtq_vform[mtqid] == 1) {
			mtq_email_results_itemized+=mtq_question_text_string+ ": "+mtq_email_results_verbose+"\n";
			mtq_email_results_itemized+=mtq_email_results_correct_answer;
			mtq_email_results_itemized+= mtq_email_results_selected_answer;
			mtq_email_results_itemized+=mtq_explanation_text;
		}
		
		mtq_email_results_itemized+="----------\n";
		if ( points_awarded == points_possible ) {
			mtq_questions_correct[mtqid]++;
		}
		mtq_stamp(q,mtqid);		
		//var has_explanation = parseInt(jQuery("#mtq_has_explanation-"+q+"-"+mtqid).val());
		if ( mtq_answer_display[mtqid] != 0 )  {
			jQuery("#mtq_question_explanation-"+q+"-"+mtqid).css('display','block');
			
		}
	}
	
	//mtq_MarkSelectedRows(); // Mark the answer rows that were selected
	if ( mtq_answer_display[mtqid] != 2 ){ // Calculate final grade
		mtq_score_blindly(mtqid);	
	} else {
		mtq_update_status(mtqid);	
	}
	
	//Set a bunch of values
	jQuery("#mtq_total_questions-"+mtqid).val(mtq_total_questions[mtqid]);
	jQuery("#mtq_current_score-"+mtqid).val(mtq_current_score[mtqid]);
	jQuery("#mtq_max_score-"+mtqid).val(mtq_max_score[mtqid]);
	jQuery("#mtq_questions_attempted-"+mtqid).val(mtq_problems_attempted[mtqid]);
	jQuery("#mtq_questions_correct-"+mtqid).val(mtq_questions_correct[mtqid]);
	mtq_questions_wrong[mtqid] = mtq_problems_attempted[mtqid] - mtq_questions_correct[mtqid];
	jQuery("#mtq_questions_wrong-"+mtqid).val(mtq_questions_wrong[mtqid]);

	mtq_questions_not_attempted[mtqid]=mtq_total_questions[mtqid] -mtq_problems_attempted[mtqid];
	jQuery("#mtq_questions_not_attempted-"+mtqid).val(mtq_questions_not_attempted[mtqid]);
	

	
	mtq_results_message(mtqid);
	
	jQuery("#mtq_quiz_results_bubble-"+mtqid).css('display','block');
	jQuery("#mtq_quiz_results_highlight-"+mtqid).css('display','block');
	if ( mtq_show_final[mtqid] ) {
		jQuery("#mtq_quiz_results-"+mtqid).css('display','block');
	}
	mtq_set_height(mtqid,1);
	var whereTo = jQuery("#mtq_quiz_results_bubble-"+mtqid).offset().top;
    jQuery('html,body').animate({scrollTop: whereTo},'fast');
	
	mtq_email_results+=mtq_final_score_on_quiz_string+": "+mtq_current_score[mtqid] +"/"+mtq_max_score[mtqid] + " (" + mtq_score_percent[mtqid].toFixed(0) + "%)" + "\n";
	mtq_email_results+=mtq_attempted_questions_correct_string+": "+mtq_questions_correct[mtqid] + "\n";
	mtq_email_results+=mtq_attempted_questions_wrong_string+": "+mtq_questions_wrong[mtqid] + "\n";
	mtq_email_results+=mtq_questions_not_attempted_string+": "+mtq_questions_not_attempted[mtqid] + "\n";
	mtq_email_results+=mtq_total_questions_on_quiz_string+": "+mtq_total_questions[mtqid] + "\n";
	mtq_email_results+=mtq_time_message;
	mtq_email_results+="\n**********\n"+mtq_question_details_string+"\n"+"---------\n";
	mtq_email_results+=mtq_email_results_itemized;
	quiz_title=jQuery("#mtq_quiztitle-"+mtqid).find('h2').text() + " "+mtq_quiz_results_string+"\n"+mtq_date_string+": "+Date(); // Fix this line for title problem
		mtq_email_results=quiz_title+"\n"+mtq_email_results;
	if ( mtq_gf_present[mtqid] ) {
		if (! mtq_quiz_in_form[mtqid] ) {
			jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq').find('textarea').css('display','none');
			mtq_gf_fill_form(mtq_email_results,mtqid);
		} else {
			mtq_gf_fill_in_form(mtq_email_results,mtqid);
			
		}
		if (mtq_autosubmit[mtqid]) {
			jQuery("#gform_"+parseInt(jQuery("#mtq_gf_formid_number-"+mtqid).val())).submit();
		}
	}
	
	if ( mtq_cf7_present[mtqid] ) {
		if (! mtq_quiz_in_form[mtqid] ) {
			jQuery("#mtq_quiz_area-"+mtqid).find('.mtq').css('display','none');
			mtq_cf7_fill_form(mtq_email_results,mtqid);
		} else {
			
		}
	}
	mtq_set_height(1,mtqid);
}


function mtq_gf_fill_in_form(results_message,mtqid){
	jQuery('#content').find('li.mtq').find('textarea').val(results_message);
		//jQuery("#mtq_quiz_area-"+mtqid).find('li.mtq').find('textarea').val(results_message);
		jQuery('#content').find('li.mtq_score').find('input').val(mtq_questions_correct[mtqid]);
		jQuery('#content').find('li.mtq_total').find('input').val(mtq_total_questions[mtqid]);
		jQuery('#content').find('li.mtq_percentage').find('input').val(mtq_score_percent[mtqid].toFixed(0));
		jQuery('#content').find('li.mtq_wrong_answers').find('input').val(mtq_total_questions[mtqid]-mtq_questions_correct[mtqid]);
		if (mtq_timer_initial_val[mtqid] >0 ) {
			jQuery('#content').find('li.mtq_time_allowed').find('input').val(mtq_timer_initial_val[mtqid]);
			jQuery('#content').find('li.mtq_time_used').find('input').val(mtq_timer_initial_val[mtqid]-mtq_timer_val[mtqid]);
		} else {
			jQuery('#content').find('li.mtq_time_allowed').find('input').val(1);
			jQuery('#content').find('li.mtq_time_used').find('input').val(1);
		}
		jQuery('#content').find('li.mtq_quiz_name').find('input').val(jQuery("#mtq_quiztitle-"+mtqid).text());
		jQuery('#content').find('li.mtq').css('display','none');
		jQuery('#content').find('li.mtq_score').css('display','none');
		jQuery('#content').find('li.mtq_total').css('display','none');
		jQuery('#content').find('li.mtq_percentage').css('display','none');
		jQuery('#content').find('li.mtq_wrong_answers').css('display','none');
		jQuery('#content').find('li.mtq_time_allowed').css('display','none');
		jQuery('#content').find('li.mtq_time_used').css('display','none');
		jQuery('#content').find('li.mtq_quiz_name').css('display','none');
	$mtq_use_gf = 1;
}



function mtq_show_all_markers(mtqid){
	var q;
	for (q = 1; q <= mtq_total_questions[mtqid]; q++)
	{
		var number_answers =parseInt(jQuery("#mtq_num_ans-"+q+"-"+mtqid).val());
		var N = parseInt(number_answers)
		var a=1;
		for (a =1; a<= N; a++){
			if (mtq_answer_display[mtqid] != 0){
				jQuery("#mtq_marker-"+q+"-"+a+"-"+mtqid).css('display','block');
				jQuery("#mtq_button-"+q+"-"+a+"-"+mtqid).css('display','none');
			}
		}
		
		var points_possible = parseInt(jQuery("#mtq_is_worth-"+q+"-"+mtqid).val());
		var points_awarded = parseInt(jQuery("#mtq_points_awarded-"+q+"-"+mtqid).val());
		if ( points_awarded == points_possible ) {
			mtq_questions_correct[mtqid]++;
		}
		mtq_stamp(q,mtqid);
		
		
	}
}



function mtq_update_status(mtqid){
	
	mtq_current_score[mtqid] = 0;
	mtq_max_score[mtqid] = 0;
	mtq_questions_answered[mtqid] = 0;
	mtq_questions_correct[mtqid] = 0;
	var q = 1;
	for (q = 1; q <= mtq_total_questions[mtqid]; q++)
	{
		var number_answers =parseInt(jQuery("#mtq_num_ans-"+q+"-"+mtqid).val());
		var N = parseInt(number_answers);
		var is_answered = parseInt(jQuery("#mtq_is_answered-"+q+"-"+mtqid).val());
		var is_correct = parseInt(jQuery("#mtq_is_correct-"+q+"-"+mtqid).val());
		var num_attempts = parseInt(jQuery("#mtq_num_attempts-"+q+"-"+mtqid).val());
		var T = parseInt(num_attempts);
		var points_possible = parseInt(jQuery("#mtq_is_worth-"+q+"-"+mtqid).val());
		var P = parseInt(points_possible);
		var points_awarded = 0;
		if ( is_answered && is_correct) {
			if ( number_answers > 1 ) {
				points_awarded = P*(N-T)/(N-1);
				if ( points_awarded < 0) {
					points_awarded = 0;
				}
			} else {
				points_awarded = P;
			}
		}
		if ( mtq_scoring_option[mtqid] ==1 && points_awarded < points_possible ) {
			points_awarded=0;
		}
		mtq_current_score[mtqid] += points_awarded;
		jQuery("#mtq_points_awarded-"+q+"-"+mtqid).val(points_awarded)
		if ( is_correct ) {
			mtq_questions_correct[mtqid]++;
		}
		
		if ( is_answered ) {
			mtq_questions_answered[mtqid]++;
		}
		
		if ( T > 0 || is_answered)
		{
			mtq_max_score[mtqid]+=P;
		}
	}
	mtq_score_percent[mtqid] = 0;
	if( mtq_max_score[mtqid] > 0) {
		mtq_score_percent[mtqid] = mtq_current_score[mtqid] / mtq_max_score[mtqid]*100;
	}
	
	
	var status_msg= mtq_have_completed_string + " " + mtq_questions_answered[mtqid] + "/"+ mtq_total_questions[mtqid] + " " + mtq_questions_string + "." ;
	if ( mtq_total_questions[mtqid] == 1 ) {
		status_msg= mtq_have_completed_string + " " + mtq_questions_answered[mtqid] + "/"+ mtq_total_questions[mtqid] + " " + mtq_question_string + "." ;
	}
	
	if ( mtq_answer_display[mtqid] == 2 ){
		status_msg+="<br>"+ mtq_your_score_is_string + " " +mtq_score_percent[mtqid].toFixed(0)+"%.";	
	}
	
	if ( mtq_questions_answered[mtqid] == mtq_total_questions[mtqid] && ! mtq_show_final[mtqid]) {
		mtq_quiz_finished[mtqid] = true;	
	}
	jQuery("#mtq_quiz_status-"+mtqid).html(status_msg);
}

function mtq_stamp(q,mtqid) {
	if (mtq_answer_display[mtqid] != 0 || (mtq_show_stamps[mtqid]==2 && mtq_quiz_finished[mtqid] ) ){
		
		if ( mtq_answer_display[mtqid] == 2 || mtq_quiz_finished[mtqid] ){
			var points_possible = parseInt(jQuery("#mtq_is_worth-"+q+"-"+mtqid).val());
			var points_awarded = parseInt(jQuery("#mtq_points_awarded-"+q+"-"+mtqid).val());
	
			jQuery("#mtq_stamp-"+q+"-"+mtqid).removeClass('mtq_wrong_stamp');
			jQuery("#mtq_stamp-"+q+"-"+mtqid).removeClass('mtq_partial_stamp');
			jQuery("#mtq_stamp-"+q+"-"+mtqid).removeClass('mtq_correct_stamp');
			jQuery("#mtq_list_item-"+q+"-"+mtqid).removeClass('mtq_list_item-wrong');
			jQuery("#mtq_list_item-"+q+"-"+mtqid).removeClass('mtq_list_item-correct');
			jQuery("#mtq_list_item-"+q+"-"+mtqid).removeClass('mtq_list_item-partial');
			jQuery("#mtq_stamp-"+q+"-"+mtqid).html('');
			if ( points_awarded > 0 && points_awarded < points_possible ){
				jQuery("#mtq_stamp-"+q+"-"+mtqid).addClass('mtq_partial_stamp');
				jQuery("#mtq_stamp-"+q+"-"+mtqid).html(mtq_partial_string);
				jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item_complete');
				jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item-partial');	
			} else if ( points_awarded == points_possible ) {
				jQuery("#mtq_stamp-"+q+"-"+mtqid).addClass('mtq_correct_stamp');
				jQuery("#mtq_stamp-"+q+"-"+mtqid).html(mtq_correct_string);
				jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item_complete');
				jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item-correct');
			} else {
				jQuery("#mtq_stamp-"+q+"-"+mtqid).addClass('mtq_wrong_stamp');
				jQuery("#mtq_stamp-"+q+"-"+mtqid).html(mtq_wrong_string);
				jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item_complete');
				jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item-wrong');
			}
		}
	}
}





function mtq_single_page(mtqid)
{
	//if ( mtq_extra_page[mtqid] ) {
		//jQuery("#mtq_results_request-"+mtqid).css('display','block');
		//jQuery("#mtq_results_button-"+mtqid).css('display','block');
	//}
	
	if (mtq_show_start[mtqid]) {
		jQuery("#mtq_instructions-"+mtqid).css('display','block');
	}
	jQuery("#mtq_quiz_status-"+mtqid).css('display','block');
	var j;
	for (j=1;j<=mtq_total_questions[mtqid];j++){
		
		jQuery("#mtq_question-" + j+"-"+mtqid).css('display','block');
	}
	
	mtq_quiz_started[mtqid] = true;
}

function mtq_reveal_answer(q,mtqid) {
	var number_answers = parseInt(jQuery("#mtq_num_ans-"+q+"-"+mtqid).val());
	var a=1;
	for (a=1;a<=number_answers;a++){
		var is_correct = parseInt(jQuery("#mtq_is_correct-"+q+"-"+a+"-"+mtqid).val());
		if (is_correct){
			jQuery("#mtq_marker-"+q+"-"+a+"-"+mtqid).css('display','block');
			jQuery("#mtq_button-"+q+"-"+a+"-"+mtqid).css('display','none');
		}
	}
}

function mtq_button_click (q,a,mtqid)
{
	var is_answered = parseInt(jQuery("#mtq_is_answered-"+q+"-"+mtqid).val());
	var is_correct = parseInt(jQuery("#mtq_is_correct-"+q+"-"+a+"-"+mtqid).val());
	var num_attempts = parseInt(jQuery("#mtq_num_attempts-"+q+"-"+mtqid).val());
	var points_possible = parseInt(jQuery("#mtq_is_worth-"+q+"-"+mtqid).val());
	var number_correct = parseInt(jQuery("#mtq_num_correct-"+q+"-"+mtqid).val());
	var was_selected = parseInt(jQuery("#mtq_was_selected-"+q+"-"+a+"-"+mtqid).val());
	var number_answers = parseInt(jQuery("#mtq_num_ans-"+q+"-"+mtqid).val());
	
	if (  number_correct == 1 && ! mtq_quiz_finished[mtqid]  ) {// If there is only one answer, we will not allow multiple selects to be nice, even though it's a hint!
		//mtq_answer_display[mtqid] != 2 &&
		var j=1;
		for (j=1; j<=number_answers; j++ ){
			if (j != a) {
				jQuery("#mtq_button-"+q+"-"+j+"-"+mtqid).removeClass('mtq_css_letter_selected');
				jQuery("#mtq_button-"+q+"-"+j+"-"+mtqid).removeClass('mtq_letter_selected-'+q+"-"+mtqid);
				jQuery("#mtq_was_selected-"+q+"-"+j+"-"+mtqid).val('0');
				jQuery("#mtq_was_ever_selected-"+q+"-"+j+"-"+mtqid).val('0'); // does this defeat purpose of was_ever_selected? Don't think so.
			} //else if( ! was_selected ) {
			//	jQuery("#mtq_button-"+q+"-"+j+"-"+mtqid).addClass('mtq_css_letter_selected');
			//	jQuery("#mtq_button-"+q+"-"+j+"-"+mtqid).addClass('mtq_letter_selected-'+q+"-"+mtqid);
			//}
		}
	}
	
	
	//var has_explanation = parseInt(jQuery("#mtq_has_explanation-"+q+"-"+mtqid).val());
	//var choices_remain = number_answers;
	
	if( ( (! is_answered) || mtq_answer_display[mtqid] != 2 ) && ! mtq_quiz_finished[mtqid] ) { // 
		if ( was_selected ) {
			jQuery("#mtq_was_selected-"+q+"-"+a+"-"+mtqid).val('0');
			jQuery("#mtq_was_ever_selected-"+q+"-"+a+"-"+mtqid).val('0');
			jQuery("#mtq_button-"+q+"-"+a+"-"+mtqid).removeClass('mtq_css_letter_selected');
			jQuery("#mtq_button-"+q+"-"+a+"-"+mtqid).removeClass('mtq_letter_selected-'+q+"-"+mtqid);
		} 
		else
		{
			jQuery("#mtq_was_selected-"+q+"-"+a+"-"+mtqid).val('1');
			jQuery("#mtq_button-"+q+"-"+a+"-"+mtqid).addClass('mtq_css_letter_selected');
			jQuery("#mtq_button-"+q+"-"+a+"-"+mtqid).addClass('mtq_letter_selected-'+q+"-"+mtqid);
		}
	}
	
	var number_selected = jQuery(".mtq_letter_selected-"+q+"-"+mtqid).length;
	
	if (! is_answered && number_selected >= number_correct && ! was_selected  ) { //Inc attempts if the q is not complete, enough items selected and the user is selecting an item rather than removing a selection.
		num_attempts++;		
		jQuery("#mtq_num_attempts-"+q+"-"+mtqid).val(num_attempts);
	}
	
	var question_correct = 1;
	if (number_selected == number_correct) { // If the correct number are selected, see if correct ones are selected
		if (! mtq_multiple_chances[mtqid] ) {//if you only get one shot, mark this question as done!
			jQuery("#mtq_is_answered-"+q+"-"+mtqid).val('1');
			jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item_complete');
			if (mtq_answer_display[mtqid] == 2){
				mtq_reveal_answer(q,mtqid);
			}
			is_answered = 1;
		}
		for (j=1;j<=number_answers;j++){
			if ( parseInt(jQuery("#mtq_is_correct-"+q+"-"+j+"-"+mtqid).val()) ) { // This choice is correct
				if ( ! parseInt(jQuery("#mtq_was_selected-"+q+"-"+j+"-"+mtqid).val()) ) { // But it was not selected
					question_correct = 0;
				}
			}
		}
	} else { // Wrong number selected so there's no way it's correct
		question_correct = 0;	
	}
	
	jQuery("#mtq_is_correct-"+q+"-"+mtqid).val(question_correct);

	
	if ( mtq_show_hints[mtqid] ) { // Wrong answer, but sufficient number to show hints.
		for (j=1;j<=number_answers;j++){
			//scroll var has_hint = parseInt(jQuery("#mtq_has_hint-"+q+"-"+j+"-"+mtqid).val());
			if(  parseInt(jQuery("#mtq_was_selected-"+q+"-"+j+"-"+mtqid).val()) ) { //has_hint &&
				jQuery("#mtq_hint-"+q+"-"+j+"-"+mtqid).css('display','block');
			 }
		}
	}
	
	//scroll var has_hint = parseInt(jQuery("#mtq_has_hint-"+q+"-"+a+"-"+mtqid).val()); // Clicked answer has hint? This is for after the question is correct, but hints can still be revealed
	
	if ( is_answered && mtq_show_hints[mtqid] ){ // Question is complete, but still display hint of clicked value. && has_hint
		jQuery("#mtq_hint-"+q+"-"+a+"-"+mtqid).css('display','block');
	}
	var how_many_left = number_answers;
	if ( number_selected >= number_correct  ) { // Sufficiently many choices have been selected to trigger grading. Mark correct and wrong choices
		for (j=1; j<=number_answers; j++ ){
			if ( parseInt(jQuery("#mtq_was_selected-"+q+"-"+j+"-"+mtqid).val() ) ){
				if (mtq_answer_display[mtqid] == 2 ){
					jQuery("#mtq_marker-"+q+"-"+j+"-"+mtqid).css('display','block');
					jQuery("#mtq_button-"+q+"-"+j+"-"+mtqid).css('display','none');
				}
				
				if ( ! parseInt(jQuery("#mtq_was_ever_selected-"+q+"-"+j+"-"+mtqid).val()) ) { // If this is the first time it is selected, keep track of when it was selected
					if ( (num_attempts == 1 || mtq_multiple_chances[mtqid]) ){
						jQuery("#mtq_was_ever_selected-"+q+"-"+j+"-"+mtqid).val(num_attempts);
					}
				} else {
					how_many_left--;
				}
				
				if (( ! parseInt(jQuery("#mtq_is_correct-"+q+"-"+j+"-"+mtqid).val()) ) && (mtq_answer_display[mtqid] == 2) ) { //Unselect the wrong answers automatically since they will be hidden and user cannot do it
					jQuery("#mtq_button-"+q+"-"+j+"-"+mtqid).removeClass('mtq_css_letter_selected');
					jQuery("#mtq_button-"+q+"-"+j+"-"+mtqid).removeClass('mtq_letter_selected-'+q+"-"+mtqid);
				}
			}
		}
	}
	
	if ( mtq_answer_display[mtqid] == 2 ){
		if ( question_correct ) {
			jQuery("#mtq_is_answered-"+q+"-"+mtqid).val('1');
			jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item_complete');
		}
		
		if ( how_many_left == 0) { //Nothing left which is unselected so it's over!
			jQuery("#mtq_list_item-"+q+"-"+mtqid).addClass('mtq_list_item_complete');
		}
		if(  is_answered || question_correct ){
				jQuery("#mtq_question_explanation-"+q+"-"+mtqid).css('display','block');
		}
	}
	
	if ( number_selected >= number_correct || was_selected ) {//don't update or stamp unless enough answers are chosen already!
		mtq_update_status(mtqid);
		mtq_stamp(q,mtqid); // Must follow status update where points are calculated

	}
	
	if (mtq_autoadvance[mtqid]) {
		if( is_answered || question_correct ){
			setTimeout("mtq_next_nav("+mtqid+")",1000);
		}
	}
	
	mtq_set_height(q,mtqid);

	return;
}

function mtq_score_blindly(mtqid){ // This assumes that there was only one attempt for each problem and ignores number of attempts. 
	mtq_current_score[mtqid] = 0;
	mtq_max_score[mtqid] = 0;
	mtq_questions_answered[mtqid] = mtq_total_questions[mtqid];
	mtq_questions_correct[mtqid] = 0;
	var q = 1;
	for (q = 1; q <= mtq_total_questions[mtqid]; q++)
	{
		var number_answers =parseInt(jQuery("#mtq_num_ans-"+q+"-"+mtqid).val());
		var N = parseInt(number_answers);
		var points_possible = parseInt(jQuery("#mtq_is_worth-"+q+"-"+mtqid).val());
		var P = parseInt(points_possible);
		var number_correct = parseInt(jQuery("#mtq_num_correct-"+q+"-"+mtqid).val());
		var points_awarded = 0;

		
		var parts_correct = 0;
		var selected_something = 0; // To ensure partial credit isn'__ given for doing nothing!
		var a=1;
		for ( a=1; a<=number_answers; a++) 
		{
			if (parseInt(jQuery("#mtq_was_selected-"+q+"-"+a+"-"+mtqid).val()) == parseInt(jQuery("#mtq_is_correct-"+q+"-"+a+"-"+mtqid).val())) 
			{
				parts_correct++;	
			}
			
			if ( parseInt(jQuery("#mtq_was_selected-"+q+"-"+a+"-"+mtqid).val())) 
			{
				selected_something = 1;
			}
		}
		
		if ( number_correct == 1 && parts_correct == number_answers ) 
		{
				points_awarded = P;
		} else if ( number_correct > 1 ) 
		{
			points_awarded = selected_something *P * parts_correct / N;
		}
			
		mtq_current_score[mtqid] += points_awarded;
		jQuery("#mtq_points_awarded-"+q+"-"+mtqid).val(points_awarded);
		if ( points_awarded == points_possible ){
			mtq_questions_correct[mtqid]++;
			jQuery("#mtq_is_correct-"+q+"-"+mtqid).val(1);
		}
		mtq_stamp(q,mtqid);
		
		mtq_max_score[mtqid]+=P;
	}
	mtq_score_percent[mtqid] = 0;
	if( mtq_max_score[mtqid] > 0) {
		mtq_score_percent[mtqid] = mtq_current_score[mtqid] / mtq_max_score[mtqid]*100;
	}
}



jQuery(document).ready(mtq_init);