/*!CK:393339304!*//*1450069351,*/

if (self.CavalryLogger) { CavalryLogger.start_js(["WLvgd"]); }

__d('DimensionTracking',['Cookie','Event','debounce','getViewportDimensions','isInIframe'],function a(b,c,d,e,f,g,h,i,j,k,l){if(c.__markCompiled)c.__markCompiled();function m(){var n=k();h.set('wd',n.width+'x'+n.height);}if(!l()){setTimeout(m,100);i.listen(window,'resize',j(m,250));i.listen(window,'focus',m);}},null);