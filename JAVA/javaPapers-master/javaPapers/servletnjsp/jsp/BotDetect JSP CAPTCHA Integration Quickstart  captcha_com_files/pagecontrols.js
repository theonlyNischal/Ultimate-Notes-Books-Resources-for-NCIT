if ( (typeof(window) !== 'undefined') && (window !== null) && (typeof(window.addEvent) === 'function') )
  window.addEvent('domready', function() {
    var searchQuery = '';
    var pos = window.location.href.indexOf('q=');
    if ( pos != -1 )
    {
      searchQuery = unescape(window.location.href.substr(pos+2));
      var searchQueryTemp = searchQuery;
       
      do {
        searchQueryTemp = searchQuery;
        searchQuery = searchQuery.replace('+',' ');
      } while (searchQuery != searchQueryTemp);      
    }
    
    var searchField = document.id('query');
    searchField.setProperty('value', searchQuery);	

    if (searchField.value != ''){
      searchField.removeClass('searchInactive');
      searchField.addClass('searchActive');
    }		

    searchField.addEvent('focus', function(){
      this.removeClass('searchInactive');
      this.addClass('searchActive');
    });

    searchField.addEvent('blur', function(){
      if (this.getProperty('value') == ''){
        this.removeClass('searchActive');
        this.addClass('searchInactive');
      }
    });		
  });

  (function() {
    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
    po.src = 'https://apis.google.com/js/plusone.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
  })();
