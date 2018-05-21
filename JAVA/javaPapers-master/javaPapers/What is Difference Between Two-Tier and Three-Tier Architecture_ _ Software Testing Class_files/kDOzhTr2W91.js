/*!CK:1946050702!*//*1439303798,*/

if (self.CavalryLogger) { CavalryLogger.start_js(["sgZDr"]); }

__d('DetectBrokenProxyCache',['AsyncSignal','Cookie','URI'],function a(b,c,d,e,f,g,h,i,j){if(c.__markCompiled)c.__markCompiled();function k(l,m){var n=i.get(m);if(n!=l&&n!=null&&l!='0'){var o={c:'si_detect_broken_proxy_cache',m:m+' '+l+' '+n},p=new j('/common/scribe_endpoint.php').getQualifiedURI().toString();new h(p,o).send();}}f.exports={run:k};},null);