function l_RegisterHandler(target, eventType, functionRef, capture) {
  if (typeof target.addEventListener != "undefined") {
    target.addEventListener(eventType, functionRef, capture);
  } else if (typeof target.attachEvent != "undefined") {
    target.attachEvent("on" + eventType, functionRef);
  } else {
    eventType = "on" + eventType;
    if (typeof target[eventType] == "function") {
      var oldListener = target[eventType];
      target[eventType] = function() {
        oldListener();
        return functionRef();
      };
    } else {target[eventType] = functionRef;
    }
  }
}

function l_SetCookie(name, value, days) {
  if (days) {
    var date = new Date();
    date.setTime(date.getTime() + (days *24*60*60*1000));
    var expires = "; expires=" + date.toGMTString();
  } else {
    var expires = "";
  }
  document.cookie = name + "=" + value + expires + "; path=/";
}

function l_GetCookie(name) {
  var nameEQ = name + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1, c.length);
    }
    if (c.indexOf(nameEQ) == 0) {
      return c.substring(nameEQ.length, c.length);
    }
  }
  return null;
}

function l_EraseCookie(name) {
  l_SetCookie(name, "", -1);
}

function l_GetScrollPosition() {
  var position = [0, 0];
  if (typeof window.pageYOffset != 'undefined') {
    position = [window.pageXOffset, window.pageYOffset];
  } else if (typeof document.documentElement.scrollTop != 'undefined' && document.documentElement.scrollTop > 0) {
    position = [document.documentElement.scrollLeft, document.documentElement.scrollTop];
  } else if (typeof document.body.scrollTop != 'undefined') {
    position = [document.body.scrollLeft, document.body.scrollTop];
  }
  return position;
}

function l_SaveScrollPosition() {
  position = l_GetScrollPosition();
  value = window.location + ',' + position[0] + ',' + position[1];
  l_SetCookie('scroll', value, 7);
}

function l_RestoreScrollPosition() {
  currentPosition = l_GetScrollPosition();
  if (0 != currentPosition[0] || 0 != currentPosition[1]) {
    return;
  }
  savedPosition = l_GetCookie('scroll');
  if (savedPosition) {
    savedPosition = savedPosition.split(',');
    if (window.location.toString() == savedPosition[0].toString()) {
      window.scrollTo(savedPosition[1], savedPosition[2]);
    }
  }
}

function l_HighlightFragment() {
  if (window.location && window.location.hash && (typeof document.getElementById != "undefined")) {
    var id = window.location.hash.replace('#', '');
    if (id) {
      var element = document.getElementById(id);
      if (element && !element.className) {
        element.className = 'highlighted';
      }
    }
  }
}

function l_TypeOf(value) {
  var s = typeof value;
  if (s === 'object') {
    if (value) {
      if (typeof value.length === 'number' &&
          !(value.propertyIsEnumerable('length')) &&
          typeof value.splice === 'function') {
        s = 'array';
      }
    } else {
      s = 'null';
    }
  }
  return s;
}

function l_GetQuerystring(name) {
  name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
  var regexS = "[\\?&]"+name+"=([^&#]*)";
  var regex = new RegExp(regexS);
  var results = regex.exec(window.location.href);
  if (results == null) {
    return "unknown";
  } else {
    return results[1];
  }
}

function l_PrintPage() {
  window.print();

  if ('undefined' != typeof(_gat)) {
    var pageTracker = _gat._getTracker("UA-221733-4");
    pageTracker._setDomainName("captcha.biz");
    pageTracker._setAllowHash(false);
    pageTracker._setAllowLinker(true);
    pageTracker._initData();
    pageTracker._trackPageview('print');
  }
}

function l_MovePreloaded(elementId, targetPlaceholderId) {
  var loaded = document.getElementById(elementId);
  var container = document.getElementById(targetPlaceholderId);
  if(!loaded || !container) { return; }
  try {
    loaded.style.visibility = 'visible';
    container.appendChild(loaded);
  } catch(e) { /*ignore errors */ }
}


function l_NewWindow(src, width, height, title) {
  popup = window.open("","new",'resizable=yes,status=yes,scrollbars=no,width='+width+',height='+height);
  popup.document.open();
  popup.document.write('<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">');
  popup.document.write('<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en"><head><title>'+title+'<\/title><\/head>');
  popup.document.write("<body style='margin:0; text-align: center;'><div>");
  popup.document.write("<img src='"+src+"' alt='Close' style='border:0;' \/><\/div><\/body><\/html>");
  popup.document.close();
}


l_PlaySound = function(url, placeholderId) {
  if (!document.getElementById) { return; }
  
  var soundUrl = url;
  var placeholder = document.getElementById(placeholderId);
  
  placeholder.innerHTML = '';

  if (l_UseHtml5Audio()) { // html5 audio
    sound = new Audio(soundUrl);
    sound.id = 'LBD_CaptchaSoundAudio';
    sound.type = 'audio/wav';
    sound.autobuffer = false;
    sound.loop = false;
    placeholder.appendChild(sound);
    
    sound.play();
  } else { // xhtml embed + object
    var objectSrc = "<object id='LBD_CaptchaSoundObject' classid='clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95' height='0' width='0' style='width:0; height:0;'><param name='AutoStart' value='1' /><param name='Volume' value='0' /><param name='PlayCount' value='1' /><param name='FileName' value='" + soundUrl + "' /><embed id='LBD_CaptchaSoundEmbed' src='" + soundUrl + "' autoplay='true' hidden='true' volume='100' type='audio/wav' style='display:inline;' /></object>";

    placeholder.innerHTML = objectSrc;
  }
};

l_UseHtml5Audio = function() {
  var html5SoundSupported = false;
  if (l_DetectAndroid() || l_DetectIOS()) {
    html5SoundSupported = true;  // Android says it can't play audio even when it can; assuming iOS uses Html5 simplifies further browser checks
  } else {
    var browserCompatibilityCheck = document.createElement('audio');
    html5SoundSupported = (
      !!(browserCompatibilityCheck.canPlayType) &&
      !!(browserCompatibilityCheck.canPlayType("audio/wav")) &&
      !l_DetectIncompetentBrowsers() // some browsers say they support the audio even when they have issues playing it
    );
  }
  return html5SoundSupported;
};

l_DetectIncompetentBrowsers = function() {
  return l_DetectFirefox3() || l_DetectSafariSsl() || l_DetectSafariMac();
};

l_DetectAndroid = function() {
  var detected = false;
  if (navigator && navigator.userAgent) {
    var matches = navigator.userAgent.match(/Linux; U; Android/);
    if (matches) {
      detected = true;
    }
  }
  return detected;
};

l_DetectIOS = function() {
  var detected = false;
  if (navigator && navigator.userAgent) {
    var matches = navigator.userAgent.match(/like Mac OS/);
    if (matches) {
      detected = true;
    }
  }
  return detected;
};

l_DetectIncompetentBrowsers = function() {
  return (l_DetectFirefox3() || l_DetectSafariSsl() || l_DetectSafariMac());
};

l_DetectFirefox3 = function() {
  var detected = false;
  if (navigator && navigator.userAgent) {
    var matches = navigator.userAgent.match(/(Firefox)\/(3\.6\.[^;\+,\/\s]+)/);
    if (matches) {
      detected = true;
    }
  }
  return detected;
};

l_DetectSafariSsl = function() {
  var detected = false;
  if (navigator && navigator.userAgent) {
    var matches = navigator.userAgent.match(/Safari/);
    if (matches) {
      matches = navigator.userAgent.match(/Chrome/);
      if (!matches && document.location.protocol === "https:") {
        detected = true;
      }
    }
  }
  return detected;
};

l_DetectSafariMac = function() {
  var detected = false;
  if (navigator && navigator.userAgent) {
    var matches = navigator.userAgent.match(/Safari/);
    if (matches) {
      matches = navigator.userAgent.match(/Chrome/);
      if (!matches && navigator.userAgent.match(/Macintosh/)) {
        detected = true;
      }
    }
  }
  return detected;
};



l_RegisterHandler(window, 'load', l_HighlightFragment, false);
l_RegisterHandler(window, 'unload', l_SaveScrollPosition, false);
l_RegisterHandler(window, 'load', l_RestoreScrollPosition, false);

