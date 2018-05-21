var imageNames = [
    ["www.dell.com.png", "http://www.dell.com"],
    ["www.hp.com.png", "http://www.hp.com"],
    ["www.toyota-europe.com.jpg", "http://www.toyota-europe.com"],
    ["www.microsoft.pl.jpg", "http://www.microsoft.pl"],
    ["www.jnj.com.jpg", "http://www.jnj.com"],
    ["us.playstation.com.png", "http://us.playstation.com"],
    ["www.nasdaq.com.png", "http://www.nasdaq.com"],
    ["www.morganstanley.com.png", "http://www.morganstanley.com"],
    ["www.accenture.com.png", "http://www.accenture.com"],
    ["www.harrisinteractive.com.jpg", "http://www.harrisinteractive.com"],
    ["www.godaddy.com.jpg", "http://www.godaddy.com"],
    ["www.intuit.com.png", "http://www.intuit.com"],
    ["www.navy.mil.jpg", "http://www.navy.mil"],
    ["www.state.gov.jpg", "http://www.state.gov"],
    ["www.supremecourt.gov.png", "http://www.supremecourt.gov"],
    ["bank.hangseng.com.jpg", "http://bank.hangseng.com"],
    ["emea.trendmicro.com.jpg", "http://emea.trendmicro.com"],
    ["www.telekom.de.png", "http://www.telekom.de"],
    ["www.webmoney.ru.png", "http://www.webmoney.ru"],
    ["www.westernunion.com.png", "http://www.westernunion.com"],
    ["en.swisscom.ch.jpg", "http://en.swisscom.ch"],
    ["www.emimusic.ca.jpg", "http://www.emimusic.ca"],
    ["www.eurocontrol.int.jpg", "http://www.eurocontrol.int"],
    ["www.buecher.de.jpg", "http://www.buecher.de"],
    ["www.christies.com.jpg", "http://www.christies.com"],
    ["www.coned.com.jpg", "http://www.coned.com"],
    ["www.commbank.com.au.jpg", "http://www.commbank.com.au"],
    ["www.codeproject.com.jpg", "http://www.codeproject.com"]
];

var imagePath = ((("https:" == document.location.protocol) ? "https://" : "http://")) + "captcha.com/images/references/";
var container = "references_movie_container";
var interval = 3000;

//init
var imagesToLoad = new Array;
var loadedImages = new Array;

var currentImageIndex = 0;
var oldImageIndex = 0;

function rotateImages() {
  container = document.id(container);
  oldImage = container.getElement('a');
  containerSize = container.getSize();

  if (currentImageIndex >= (loadedImages.length - 1)) {
    currentImageIndex = 0;
    oldImageIndex = loadedImages.length - 1;
  } else {
    oldImageIndex = currentImageIndex;
    currentImageIndex++;
  }

  if (oldImage != null){
    loadedImages[currentImageIndex].replaces(oldImage);
    loadedImages[oldImageIndex] = oldImage;
  }
}

if ( (typeof(window) !== 'undefined') && (window !== null) && (typeof(window.addEvent) === 'function') )
    window.addEvent('domready', function() { // dom dependent setup
    container = document.id(container);
    image = container.getElement('a');
    
    Array.each(imageNames,
      function(name, index) { // image preload
        imagesToLoad[index] = new Element('img', { 'alt': name[1], 'class' : 'references_movie_logo' });
        imagesToLoad[index].addEvent('load', function(){
            imageLink = new Element('a', { 'href': name[1], 'target': '_blank', 'rel': 'nofollow', 'class' : 'references_movie_link' });
            imagesToLoad[index].removeEvents('load');
            loadedImages.push(imageLink.adopt(imagesToLoad[index]));
            document.id(container).fireEvent('ready');
          }
        );
        imagesToLoad[index].set('src', imagePath + name[0]);
      }
    );

    container.addEvent('ready', function() { // loop
      if (image == null) {
        container.appendChild(loadedImages[currentImageIndex].clone());
      }
      setInterval(function(){
        container.tween('opacity', 0).get('tween').chain( function() { rotateImages(); container.tween('opacity', 1) } );
      }
      , interval);
      container.removeEvents('ready');
    });
  });


