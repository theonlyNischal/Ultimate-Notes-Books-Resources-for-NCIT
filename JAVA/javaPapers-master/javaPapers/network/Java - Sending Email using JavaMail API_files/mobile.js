$(function() {
   var visible     = false;
   var menu        = $('#leftcol');
   var menuWidth   = menu.width();
   var menuHeight  = menu.height();

   $('#pull').unbind('click').on('click', function(e) {
      e.preventDefault();
      e.stopPropagation();
      //menu.slideToggle( "fast", function() {
      if( !(visible) ){
          visible = true;
          menu.css( "display", "block" );
          $("#middlecol").css( "width", window.innerWidth-menuWidth + "px" );
       }else{
          visible = false;
          menu.css( "display", "none" );
          $("#middlecol").css( "width", window.innerWidth + "px" );
       }
      //});
   });

   var resizeTimer;
   var window_size = $(window).width();
   $(window).resize(function(){
      clearTimeout( resizeTimer );
      resizeTimer = setTimeout(function(){
         var window_changed = $(window).width() != window_size;
         window_size = $(window).width();
         if(window_changed){
            if( window.innerWidth <= 768){
                  visible = false;
                  menu.css( "display", "none" );
            }else{
                  visible = true;
                  menu.css( "display", "block" );
                  $("#middlecol").css( "width", "575px" );
            }
         }
      }, 500);
   });
   function setMaxWidth() {
      if( window.innerWidth <= 768 ){
         if( /iPhone|iPod|iPad/i.test(navigator.userAgent) ){
            $("#middlecol").css( "fontSize", "9px" );
         }
         $("#middlecol").css( "font-size", "14px" );
         $("#header .wrapper h1").css( "maxWidth", window.innerWidth + "px" );
         $("#middlecol").css( "width", window.innerWidth + "px" );
         $("#topmenu .wrapper #mobileright").css("left", window.innerWidth - 40 );
/*
         if( window.innerWidth < 468 ){
            $(".topgooglead").css( "display", "none");
         }else{
            $(".topgooglead").css( "display", "block");
         }
*/
      }
   }
   setMaxWidth();
   $( window ).bind( "orientationchange", setMaxWidth );
   $( window ).bind( "resize", setMaxWidth );
});
