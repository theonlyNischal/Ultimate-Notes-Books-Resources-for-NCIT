function show() {
    if (1 == 100) {
        curHeight = 366 + 1;
    } else {
        curHeight += 2;
    }
    if (curHeight > maxHeight) {
        clearInterval(IntervalId);
        if (autoHide == 1 && (curHeight == maxHeight)) {
            popTimeout();
        }
    }
    popupBalloon.style.height = curHeight + "px";
}

function hide() {
    if (1 == 100) {
        curHeight = 18 - 1;
    } else {
        curHeight -= 3;
    }
    if (curHeight < minHeight) {
        clearInterval(IntervalId);
    }
    popupBalloon.style.height = curHeight + "px";
    clearPopTimeout();
}
function hideAll() {
    popupContent.style.display = "none";
    document.getElementById("popup_hide").style.display = "none";
    document.getElementById("popup_show").style.display = "inline"
}
function clickhide() {
    document.getElementById("popup_hide").style.display = "none";
    document.getElementById("popup_show").style.display = "inline";
    IntervalId = setInterval("hide()", popSpeed);
}

function clickshow() {
    popupContent.style.display = "block";
    document.getElementById("popup_hide").style.display = "inline";
    document.getElementById("popup_show").style.display = "none";
    IntervalId = setInterval("show()", popSpeed);
}

function clickclose() {
    document.body.style.marginBottom = "0px";
    popupBalloon.style.display = "none";
}

function popTimeout() {
    autoHidePop = window.setTimeout("clickhide()", timeOut);
}

function clearPopTimeout() {
    window.clearTimeout(autoHidePop);
}
function showPopup() {
    clickshow();
}
hideAll();
if (popupShow) {
    window.setTimeout("showPopup()", popupDelay);
}
(function ($) {
    $(document).ready(function () {
        var form = $("form#news-letter");
        form.submit(function () {
            clickhide();
        });
    });
})(jQuery);