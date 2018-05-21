window.onload = init;

function init() {
   // Print Header
   document.getElementById("header").innerHTML = '<p>yet another insignificant programming notes... &nbsp;&nbsp;| &nbsp;&nbsp;<a href="../index.html">HOME</a></p>';

   // Print Footer
   document.getElementById("footer").innerHTML = '<p>Feedback, comments, corrections, and errata can be sent to Chua Hock-Chuan (ehchua@ntu.edu.sg) &nbsp;&nbsp;|&nbsp;&nbsp; <a href="../index.html">HOME</a></p>';

   // Generate Table of Content
   if (document.getElementById("toc") != null) {
      // Generate TOC on <div id="toc">
      generateTOC();
      // Attach onclick handler to <a id="show-toc">
      document.getElementById("show-toc").onclick = toggleTOC;
   }
}

/*
 * Generate Table of Content (TOC)
 * Scan the document's first-level childs for heading tags
 * and build the TOC on <div id="toc">
 * Use an <a> with id="show-toc" to toggle the TOC display
 */
var showToc = true;  // Showing TOC now, init to true

// Need an <a> with id="show-toc" to toggle the <div id="toc">'s
//   display="none|block" (init to "none").
function toggleTOC() {
   var elm = document.getElementById("show-toc");
   if (showToc) {
      document.getElementById("toc").style.display = "none";
      elm.innerHTML = "(SHOW)";
   } else {
      document.getElementById("toc").style.display = "block";
      elm.innerHTML = "(HIDE)";
   }
   showToc = !showToc; // toggle the flag
   return false;       // don't follow the link
}

// Scan the level-1 childs for headings and place them in
// <div id="toc">
// Create a anchor point at each heading with id="zzNum"
var ANCHOR_PREFIX = "zz-";
function generateTOC() {
   var currentH3 = 0;  // current section number
   var currentH4 = 0;  // current sub-section number
   var previousTag = "H3";  // need this flag to reset sub-section number
   var anchorText;
   var sectionHeading;
   var tocInnerHTML = "";

   var level1Childs = document.getElementById("content-main").childNodes;
   for (var i = 0; i < level1Childs.length; i++) {
      var node = level1Childs[i];
      var tagName = node.nodeName;
      if (tagName == "H3" || tagName == "H4") {
         if (tagName == "H3") {
            currentH3++;
            sectionHeading = currentH3 + ".";
            previousTag = "H3";
         } else if (tagName == "H4") {
            if (previousTag == "H3") {
               currentH4 = 1;
            } else {
               currentH4++;
            }
            sectionHeading = currentH3 + "." + currentH4;
            previousTag = "H4";
         }
         anchorText = sectionHeading + "&nbsp;&nbsp;" + node.innerHTML;
         tocInnerHTML += "<a class='toc-" + tagName 
                + "' href='#" + ANCHOR_PREFIX + sectionHeading + "'>" + anchorText + "</a><br />";
         // Create an anchor name and attach to the heading
         var newAnchorNode = document.createElement("A");
         newAnchorNode.id = ANCHOR_PREFIX + sectionHeading;
         node.appendChild(newAnchorNode);
		 node.innerHTML = sectionHeading + "&nbsp;&nbsp;" + node.innerHTML
      }
   }
   tocInnerHTML += "<br />";
   document.getElementById("toc").innerHTML = tocInnerHTML;
}
