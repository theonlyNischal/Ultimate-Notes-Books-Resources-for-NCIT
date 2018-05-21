// hiding the vertical adsense ad
// for low resolution screens

$(document).ready(function() {
  if (screen.width <= 1024) {
    $('#wide_ad').hide();
    $('#new_ver').hide();
  } 
});

