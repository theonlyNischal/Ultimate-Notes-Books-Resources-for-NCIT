if(!window.console){window.console={}
}if(typeof window.console.log!=="function"){window.console.log=function(){}
}if(typeof window.console.warn!=="function"){window.console.warn=function(){}
}(function(){var S={"bootstrapInit":+new Date()},p=document,m=(/^https?:\/\/.*?linkedin.*?\/in\.js.*?$/),b=(/async=true/),D=(/^https:\/\//),J=(/\/\*((?:.|[\s])*?)\*\//m),F=(/\r/g),j=(/[\s]/g),g=(/^[\s]*(.*?)[\s]*:[\s]*(.*)[\s]*$/),x=(/_([a-z])/gi),A=(/^[\s]+|[\s]+$/g),u=(/^[a-z]{2}(_)[A-Z]{2}$/),C=(/suppress(Warnings|_warnings):true/gi),d=(/^api(Key|_key)$/gi),k="\n",G=",",n="",I="@",o="extensions",Z="on",w="onDOMReady",ac="onOnce",aa="script",L="https://www.linkedin.com/uas/js/userspace?v=0.0.2000-RC8.48101-1428",h="https://platform.linkedin.com/js/secureAnonymousFramework?v=0.0.2000-RC8.48101-1428",H="http://platform.linkedin.com/js/nonSecureAnonymousFramework?v=0.0.2000-RC8.48101-1428",P="http://platform.linkedin.com/js/frameworkV2?v=0.0.2000-RC8.48101-1428",B=p.getElementsByTagName("head")[0],t=p.getElementsByTagName(aa),X=[],a=[],O=["lang"],R={},c=false,ad,l,W,r,K,E,ab;
if(window.IN&&IN.ENV&&IN.ENV.js){if(!IN.ENV.js.suppressWarnings){console.warn("duplicate in.js loaded, any parameters will be ignored")
}return
}window.IN=window.IN||{};
IN.ENV={};
IN.ENV.js={};
IN.ENV.js.extensions={};
statsQueue=IN.ENV.statsQueue=[];
statsQueue.push(S);
ad=IN.ENV.evtQueue=[];
IN.Event={on:function(){ad.push({type:Z,args:arguments})
},onDOMReady:function(){ad.push({type:w,args:arguments})
},onOnce:function(){ad.push({type:ac,args:arguments})
}};
IN.$extensions=function(ag){var aj,i,af,ai,ah=IN.ENV.js.extensions;
aj=ag.split(G);
for(var ae=0,e=aj.length;
ae<e;
ae++){i=V(aj[ae],I,2);
af=i[0].replace(A,n);
ai=i[1];
if(!ah[af]){ah[af]={src:(ai)?ai.replace(A,n):n,loaded:false}
}}};
function V(ag,ae,e){var ah=ag.split(ae);
if(!e){return ah
}if(ah.length<e){return ah
}var af=ah.splice(0,e-1);
var i=ah.join(ae);
af.push(i);
return af
}function v(e,i){if(e===o){IN.$extensions(i);
return null
}if(d.test(e)){i=i.replace(j,n)
}if(i===""){return null
}return i
}function N(af,ag){ag=v(af,ag);
if(ag){af=af.replace(x,function(){return arguments[1].toUpperCase()
});
if(af==="lang"&&!u.test(ag)){try{var ae=ag.replace("-","_").split("_");
ae=[ae[0].substr(0,2).toLowerCase(),ae[1].substr(0,2).toUpperCase()].join("_");
if(!u.test(ae)){throw new Error()
}else{ag=ae
}}catch(ah){if(!(ab||IN.ENV.js.suppressWarnings)&&ag){console.warn("'"+ag+"' is not a supported language, defaulting to 'en_US'")
}ag="en_US"
}}else{if(af==="noAuth"||af==="noApi"){ag=/^(?:true|yes|1)$/i.test(ag)
}}IN.ENV.js[af]=ag;
var ai=[encodeURIComponent(af),encodeURIComponent(ag)].join("=");
for(var i in O){if(O.hasOwnProperty(i)&&O[i]===af){a.push(ai);
return
}}X.push(ai)
}}l="";
for(U=0,q=t.length;
U<q;
U++){var f=t[U];
if(!m.test(f.src)){continue
}if(b.test(f.src)){c=true
}try{l=f.innerHTML.replace(A,n)
}catch(z){try{l=f.text.replace(A,n)
}catch(y){}}}l=l.replace(J,"$1").replace(A,n).replace(F,n);
ab=C.test(l.replace(j,n));
for(var U=0,T=l.split(k),q=T.length;
U<q;
U++){var s=T[U];
if(!s||s.replace(j,n).length<=0){continue
}try{W=s.match(g);
r=W[1].replace(A,n);
K=W[2].replace(A,n)
}catch(Y){if(!ab){console.warn("script tag contents must be key/value pairs separated by a colon. Source: "+Y)
}continue
}N(r,K)
}N("secure",1);
function M(e,i){return e+((/\?/.test(e))?"&":"?")+i.join("&")
}IN.init=function Q(i){var e=IN.ENV.js,ae,af;
i=i||{};
for(ae in i){if(i.hasOwnProperty(ae)){N(ae,i[ae])
}}E=p.createElement(aa);
if(e.v2){af=M(P,X)
}else{if(e.apiKey&&!e.noAuth){af=M(L,X)
}else{af=e.secure?h:H
}}E.src=M(af,a);
B.appendChild(E);
statsQueue.push({"userspaceRequested":+new Date()});
IN.init=function(){}
};
statsQueue.push({"bootstrapLoaded":+new Date()});
if(!c){IN.init()
}})();
