function highlightlink(){var currentLocation = window.location.href;var n = currentLocation.search("com");var linkurl=currentLocation.slice(n+4);
var anchors = document.querySelectorAll('.leftmenu > a');for (var i = 0; i < anchors.length; i++) { if(anchors[i].attributes['href'].value==linkurl){anchors[i].innerHTML="<strong>"+anchors[i].textContent+"</strong>"+"";anchors[i].style.color="black";}}}var dp={sh:{Toolbar:{},Utils:{},RegexLib:{},Brushes:{},Strings:{AboutDialog:'<html><head><title>About...</title></head><body class="dp-about"><table cellspacing="0"><tr><td class="copy"><p class="title">dp.SyntaxHighlighter</div><div class="para">Version: {V}</p><p><a href="http://www.dreamprojections.com/syntaxhighlighter/?ref=about" target="_blank">http://www.dreamprojections.com/syntaxhighlighter</a></p>&copy;2004-2007 Alex Gorbatchev.</td></tr><tr><td class="footer"><input type="button" class="close" value="OK" onClick="window.close()"/></td></tr></table></body></html>'},ClipboardSwf:null,Version:'1.5.1'}};dp.SyntaxHighlighter=dp.sh;dp.sh.Toolbar.Commands={ExpandSource:{label:'+ expand source',check:function(highlighter){return highlighter.collapse;},func:function(sender,highlighter)
{sender.parentNode.removeChild(sender);highlighter.div.className=highlighter.div.className.replace('collapsed','');}},ViewSource:{label:'',func:function(sender,highlighter)
{var code=dp.sh.Utils.FixForBlogger(highlighter.originalCode).replace(/</g,'&lt;');var wnd=window.open('','_blank','width=750, height=400, location=0, resizable=1, menubar=0, scrollbars=0');wnd.document.write('<textarea style="width:99%;height:99%">'+code+'</textarea>');wnd.document.close();}},CopyToClipboard:{label:'copy to clipboard',check:function(){return window.clipboardData!=null||dp.sh.ClipboardSwf!=null;},func:function(sender,highlighter)
{var code=dp.sh.Utils.FixForBlogger(highlighter.originalCode).replace(/&lt;/g,'<').replace(/&gt;/g,'>').replace(/&amp;/g,'&');if(window.clipboardData)
{window.clipboardData.setData('text',code);}
else if(dp.sh.ClipboardSwf!=null)
{var flashcopier=highlighter.flashCopier;if(flashcopier==null)
{flashcopier=document.createElement('div');highlighter.flashCopier=flashcopier;highlighter.div.appendChild(flashcopier);}
flashcopier.innerHTML='<embed src="'+dp.sh.ClipboardSwf+'" FlashVars="clipboard='+encodeURIComponent(code)+'" width="0" height="0" type="application/x-shockwave-flash"></embed>';}
alert('The code is in your clipboard now');}},PrintSource:{label:'',func:function(sender,highlighter)
{var iframe=document.createElement('IFRAME');var doc=null;iframe.style.cssText='position:absolute;width:0px;height:0px;left:-500px;top:-500px;';document.body.appendChild(iframe);doc=iframe.contentWindow.document;dp.sh.Utils.CopyStyles(doc,window.document);doc.write('<div class="'+highlighter.div.className.replace('collapsed','')+' printing">'+highlighter.div.innerHTML+'</div>');doc.close();iframe.contentWindow.focus();iframe.contentWindow.print();alert('Printing...');document.body.removeChild(iframe);}},About:{label:'',func:function(highlighter)
{var wnd=window.open('','_blank','dialog,width=300,height=150,scrollbars=0');var doc=wnd.document;dp.sh.Utils.CopyStyles(doc,window.document);doc.write(dp.sh.Strings.AboutDialog.replace('{V}',dp.sh.Version));doc.close();wnd.focus();}}};dp.sh.Toolbar.Create=function(highlighter)
{var div=document.createElement('DIV');div.className='tools';for(var name in dp.sh.Toolbar.Commands)
{var cmd=dp.sh.Toolbar.Commands[name];if(cmd.check!=null&&!cmd.check(highlighter))
continue;div.innerHTML+='<a href="#" onclick="dp.sh.Toolbar.Command(\''+name+'\',this);return false;">'+cmd.label+'</a>';}
return div;}
dp.sh.Toolbar.Command=function(name,sender)
{var n=sender;while(n!=null&&n.className.indexOf('dp-highlighter')==-1)
n=n.parentNode;if(n!=null)
dp.sh.Toolbar.Commands[name].func(sender,n.highlighter);}
dp.sh.Utils.CopyStyles=function(destDoc,sourceDoc)
{var links=sourceDoc.getElementsByTagName('link');for(var i=0;i<links.length;i++)
if(links[i].rel.toLowerCase()=='stylesheet')
destDoc.write('<link type="text/css" rel="stylesheet" href="'+links[i].href+'"></link>');}
dp.sh.Utils.FixForBlogger=function(str)
{return(dp.sh.isBloggerMode==true)?str.replace(/<br\s*\/?>|&lt;br\s*\/?&gt;/gi,'\n'):str;}
dp.sh.RegexLib={MultiLineCComments:new RegExp('/\\*[\\s\\S]*?\\*/','gm'),SingleLineCComments:new RegExp('//.*$','gm'),SingleLinePerlComments:new RegExp('#.*$','gm'),DoubleQuotedString:new RegExp('"(?:\\.|(\\\\\\")|[^\\""\\n])*"','g'),SingleQuotedString:new RegExp("'(?:\\.|(\\\\\\')|[^\\''\\n])*'",'g')};dp.sh.Match=function(value,index,css)
{this.value=value;this.index=index;this.length=value.length;this.css=css;}
dp.sh.Highlighter=function()
{this.noGutter=false;this.addControls=true;this.collapse=false;this.tabsToSpaces=true;this.wrapColumn=80;this.showColumns=true;}
dp.sh.Highlighter.SortCallback=function(m1,m2)
{if(m1.index<m2.index)
return-1;else if(m1.index>m2.index)
return 1;else
{if(m1.length<m2.length)
return-1;else if(m1.length>m2.length)
return 1;}
return 0;}
dp.sh.Highlighter.prototype.CreateElement=function(name)
{var result=document.createElement(name);result.highlighter=this;return result;}
dp.sh.Highlighter.prototype.GetMatches=function(regex,css)
{var index=0;var match=null;while((match=regex.exec(this.code))!=null)
this.matches[this.matches.length]=new dp.sh.Match(match[0],match.index,css);}
dp.sh.Highlighter.prototype.AddBit=function(str,css)
{if(str==null||str.length==0)
return;var span=this.CreateElement('SPAN');str=str.replace(/ /g,'&nbsp;');str=str.replace(/</g,'&lt;');str=str.replace(/\n/gm,'&nbsp;<br>');if(css!=null)
{if((/br/gi).test(str))
{var lines=str.split('&nbsp;<br>');for(var i=0;i<lines.length;i++)
{span=this.CreateElement('SPAN');span.className=css;span.innerHTML=lines[i];this.div.appendChild(span);if(i+1<lines.length)
this.div.appendChild(this.CreateElement('BR'));}}
else
{span.className=css;span.innerHTML=str;this.div.appendChild(span);}}
else
{span.innerHTML=str;this.div.appendChild(span);}}
dp.sh.Highlighter.prototype.IsInside=function(match)
{if(match==null||match.length==0)
return false;for(var i=0;i<this.matches.length;i++)
{var c=this.matches[i];if(c==null)
continue;if((match.index>c.index)&&(match.index<c.index+c.length))
return true;}
return false;}
dp.sh.Highlighter.prototype.ProcessRegexList=function()
{for(var i=0;i<this.regexList.length;i++)
this.GetMatches(this.regexList[i].regex,this.regexList[i].css);}
dp.sh.Highlighter.prototype.ProcessSmartTabs=function(code)
{var lines=code.split('\n');var result='';var tabSize=4;var tab='\t';function InsertSpaces(line,pos,count)
{var left=line.substr(0,pos);var right=line.substr(pos+1,line.length);var spaces='';for(var i=0;i<count;i++)
spaces+=' ';return left+spaces+right;}
function ProcessLine(line,tabSize)
{if(line.indexOf(tab)==-1)
return line;var pos=0;while((pos=line.indexOf(tab))!=-1)
{var spaces=tabSize-pos%tabSize;line=InsertSpaces(line,pos,spaces);}
return line;}
for(var i=0;i<lines.length;i++)
result+=ProcessLine(lines[i],tabSize)+'\n';return result;}
dp.sh.Highlighter.prototype.SwitchToList=function()
{var html=this.div.innerHTML.replace(/<(br)\/?>/gi,'\n');var lines=html.split('\n');if(this.addControls==true)
this.bar.appendChild(dp.sh.Toolbar.Create(this));if(this.showColumns)
{var div=this.CreateElement('div');var columns=this.CreateElement('div');var showEvery=10;var i=1;while(i<=150)
{if(i%showEvery==0)
{div.innerHTML+=i;i+=(i+'').length;}
else
{div.innerHTML+='&middot;';i++;}}
columns.className='columns';columns.appendChild(div);this.bar.appendChild(columns);}
for(var i=0,lineIndex=this.firstLine;i<lines.length-1;i++,lineIndex++)
{var li=this.CreateElement('LI');var span=this.CreateElement('SPAN');li.className=(i%2==0)?'alt':'';span.innerHTML=lines[i]+'&nbsp;';li.appendChild(span);this.ol.appendChild(li);}
this.div.innerHTML='';}
dp.sh.Highlighter.prototype.Highlight=function(code)
{function Trim(str)
{return str.replace(/^\s*(.*?)[\s\n]*$/g,'$1');}
function Chop(str)
{return str.replace(/\n*$/,'').replace(/^\n*/,'');}
function Unindent(str)
{var lines=dp.sh.Utils.FixForBlogger(str).split('\n');var indents=new Array();var regex=new RegExp('^\\s*','g');var min=1000;for(var i=0;i<lines.length&&min>0;i++)
{if(Trim(lines[i]).length==0)
continue;var matches=regex.exec(lines[i]);if(matches!=null&&matches.length>0)
min=Math.min(matches[0].length,min);}
if(min>0)
for(var i=0;i<lines.length;i++)
lines[i]=lines[i].substr(min);return lines.join('\n');}
function Copy(string,pos1,pos2)
{return string.substr(pos1,pos2-pos1);}
var pos=0;if(code==null)
code='';this.originalCode=code;this.code=Chop(Unindent(code));this.div=this.CreateElement('DIV');this.bar=this.CreateElement('DIV');this.ol=this.CreateElement('OL');this.matches=new Array();this.div.className='dp-highlighter';this.div.highlighter=this;this.bar.className='bar';this.ol.start=this.firstLine;if(this.CssClass!=null)
this.ol.className=this.CssClass;if(this.collapse)
this.div.className+=' collapsed';if(this.noGutter)
this.div.className+=' nogutter';if(this.tabsToSpaces==true)
this.code=this.ProcessSmartTabs(this.code);this.ProcessRegexList();if(this.matches.length==0)
{this.AddBit(this.code,null);this.SwitchToList();this.div.appendChild(this.bar);this.div.appendChild(this.ol);return;}
this.matches=this.matches.sort(dp.sh.Highlighter.SortCallback);for(var i=0;i<this.matches.length;i++)
if(this.IsInside(this.matches[i]))
this.matches[i]=null;for(var i=0;i<this.matches.length;i++)
{var match=this.matches[i];if(match==null||match.length==0)
continue;this.AddBit(Copy(this.code,pos,match.index),null);this.AddBit(match.value,match.css);pos=match.index+match.length;}
this.AddBit(this.code.substr(pos),null);this.SwitchToList();this.div.appendChild(this.bar);this.div.appendChild(this.ol);}
dp.sh.Highlighter.prototype.GetKeywords=function(str)
{return'\\b'+str.replace(/ /g,'\\b|\\b')+'\\b';}
dp.sh.BloggerMode=function()
{dp.sh.isBloggerMode=true;}
dp.sh.HighlightAll=function(name,showGutter,showControls,collapseAll,firstLine,showColumns)
{function FindValue()
{var a=arguments;for(var i=0;i<a.length;i++)
{if(a[i]==null)
continue;if(typeof(a[i])=='string'&&a[i]!='')
return a[i]+'';if(typeof(a[i])=='object'&&a[i].value!='')
return a[i].value+'';}
return null;}
function IsOptionSet(value,list)
{for(var i=0;i<list.length;i++)
if(list[i]==value)
return true;return false;}
function GetOptionValue(name,list,defaultValue)
{var regex=new RegExp('^'+name+'\\[(\\w+)\\]$','gi');var matches=null;for(var i=0;i<list.length;i++)
if((matches=regex.exec(list[i]))!=null)
return matches[1];return defaultValue;}
function FindTagsByName(list,name,tagName)
{var tags=document.getElementsByTagName(tagName);for(var i=0;i<tags.length;i++)
if(tags[i].getAttribute('name')==name)
list.push(tags[i]);}
var elements=[];var highlighter=null;var registered={};var propertyName='innerHTML';FindTagsByName(elements,name,'pre');FindTagsByName(elements,name,'textarea');if(elements.length==0)
return;for(var brush in dp.sh.Brushes)
{var aliases=dp.sh.Brushes[brush].Aliases;if(aliases==null)
continue;for(var i=0;i<aliases.length;i++)
registered[aliases[i]]=brush;}
for(var i=0;i<elements.length;i++)
{var element=elements[i];var options=FindValue(element.attributes['class'],element.className,element.attributes['language'],element.language);var language='';if(options==null)
continue;options=options.split(':');language=options[0].toLowerCase();if(registered[language]==null)
continue;highlighter=new dp.sh.Brushes[registered[language]]();element.style.display='none';highlighter.noGutter=(showGutter==null)?IsOptionSet('nogutter',options):!showGutter;highlighter.addControls=(showControls==null)?!IsOptionSet('nocontrols',options):showControls;highlighter.collapse=(collapseAll==null)?IsOptionSet('collapse',options):collapseAll;highlighter.showColumns=(showColumns==null)?IsOptionSet('showcolumns',options):showColumns;var headNode=document.getElementsByTagName('head')[0];if(highlighter.Style&&headNode)
{var styleNode=document.createElement('style');styleNode.setAttribute('type','text/css');if(styleNode.styleSheet)
{styleNode.styleSheet.cssText=highlighter.Style;}
else
{var textNode=document.createTextNode(highlighter.Style);styleNode.appendChild(textNode);}
headNode.appendChild(styleNode);}
highlighter.firstLine=(firstLine==null)?parseInt(GetOptionValue('firstline',options,1)):firstLine;highlighter.Highlight(element[propertyName]);highlighter.source=element;element.parentNode.insertBefore(highlighter.div,element);}}


dp.sh.Brushes.Xml=function()
{this.CssClass='dp-xml';this.Style='.dp-xml .cdata { color: #ff1493; }'+'.dp-xml .tag, .dp-xml .tag-name { color: #069; font-weight: bold; }'+'.dp-xml .attribute { color: red; }'+'.dp-xml .attribute-value { color: blue; }';}
dp.sh.Brushes.Xml.prototype=new dp.sh.Highlighter();dp.sh.Brushes.Xml.Aliases=['xml','xhtml','xslt','html','xhtml'];dp.sh.Brushes.Xml.prototype.ProcessRegexList=function()
{function push(array,value)
{array[array.length]=value;}
var index=0;var match=null;var regex=null;this.GetMatches(new RegExp('(\&lt;|<)\\!\\[[\\w\\s]*?\\[(.|\\s)*?\\]\\](\&gt;|>)','gm'),'cdata');this.GetMatches(new RegExp('(\&lt;|<)!--\\s*.*?\\s*--(\&gt;|>)','gm'),'comments');regex=new RegExp('([:\\w-\.]+)\\s*=\\s*(".*?"|\'.*?\'|\\w+)*|(\\w+)','gm');while((match=regex.exec(this.code))!=null)
{if(match[1]==null)
{continue;}
push(this.matches,new dp.sh.Match(match[1],match.index,'attribute'));if(match[2]!=undefined)
{push(this.matches,new dp.sh.Match(match[2],match.index+match[0].indexOf(match[2]),'attribute-value'));}}
this.GetMatches(new RegExp('(\&lt;|<)/*\\?*(?!\\!)|/*\\?*(\&gt;|>)','gm'),'tag');regex=new RegExp('(?:\&lt;|<)/*\\?*\\s*([:\\w-\.]+)','gm');while((match=regex.exec(this.code))!=null)
{push(this.matches,new dp.sh.Match(match[1],match.index+match[0].indexOf(match[1]),'tag-name'));}}

dp.sh.Brushes.Sql=function()
{var funcs='abs avg case cast coalesce convert count current_timestamp '+'current_user day isnull left lower month nullif replace right '+'session_user space substring sum system_user upper user year';var keywords='absolute action add after alter as asc at authorization begin bigint '+'binary bit by cascade char character check checkpoint close collate '+'column commit committed connect connection constraint contains continue '+'create cube current current_date current_time cursor database date '+'deallocate dec decimal declare default delete desc distinct double drop '+'dynamic else end end-exec escape except exec execute false fetch first '+'float for force foreign forward free from full function global goto grant '+'group grouping having hour ignore index inner insensitive insert instead '+'int integer intersect into is isolation key last level load local max min '+'minute modify move name national nchar next no numeric of off on only '+'open option order out output partial password precision prepare primary '+'prior privileges procedure public read real references relative repeatable '+'restrict return returns revoke rollback rollup rows rule schema scroll '+'second section select sequence serializable set size smallint static '+'statistics table temp temporary then time timestamp to top transaction '+'translation trigger true truncate uncommitted union unique update values '+'varchar varying view when where with work';var operators='all and any between cross in join like not null or outer some';this.regexList=[{regex:new RegExp('--(.*)$','gm'),css:'comment'},{regex:dp.sh.RegexLib.DoubleQuotedString,css:'string'},{regex:dp.sh.RegexLib.SingleQuotedString,css:'string'},{regex:new RegExp(this.GetKeywords(funcs),'gmi'),css:'func'},{regex:new RegExp(this.GetKeywords(operators),'gmi'),css:'op'},{regex:new RegExp(this.GetKeywords(keywords),'gmi'),css:'keyword'}];this.CssClass='dp-sql';this.Style='.dp-sql .func { color: #ff1493; }'+'.dp-sql .op { color: #808080; }';}
dp.sh.Brushes.Sql.prototype=new dp.sh.Highlighter();dp.sh.Brushes.Sql.Aliases=['sql'];

dp.sh.Brushes.Python=function()
{var keywords='and assert break class continue def del elif else '+'except exec finally for from global if import in is '+'lambda not or pass print raise return try yield while';var special='None True False self cls class_'
this.regexList=[{regex:dp.sh.RegexLib.SingleLinePerlComments,css:'comment'},{regex:new RegExp("^\\s*@\\w+",'gm'),css:'decorator'},{regex:new RegExp("(['\"]{3})([^\\1])*?\\1",'gm'),css:'comment'},{regex:new RegExp('"(?!")(?:\\.|\\\\\\"|[^\\""\\n\\r])*"','gm'),css:'string'},{regex:new RegExp("'(?!')*(?:\\.|(\\\\\\')|[^\\''\\n\\r])*'",'gm'),css:'string'},{regex:new RegExp("\\b\\d+\\.?\\w*",'g'),css:'number'},{regex:new RegExp(this.GetKeywords(keywords),'gm'),css:'keyword'},{regex:new RegExp(this.GetKeywords(special),'gm'),css:'special'}];this.CssClass='dp-py';this.Style='.dp-py .builtins { color: #ff1493; }'+'.dp-py .magicmethods { color: #808080; }'+'.dp-py .exceptions { color: brown; }'+'.dp-py .types { color: brown; font-style: italic; }'+'.dp-py .commonlibs { color: #8A2BE2; font-style: italic; }';}
dp.sh.Brushes.Python.prototype=new dp.sh.Highlighter();dp.sh.Brushes.Python.Aliases=['py','python'];

dp.sh.Brushes.Java=function()
{var keywords='abstract assert boolean break byte case catch char class const '+'continue default do double else enum extends '+'false final finally float for goto if implements import '+'instanceof int interface long native new null '+'package private protected public return '+'short static strictfp super switch synchronized this throw throws true '+'transient try void volatile while';this.regexList=[{regex:dp.sh.RegexLib.SingleLineCComments,css:'comment'},{regex:dp.sh.RegexLib.MultiLineCComments,css:'comment'},{regex:dp.sh.RegexLib.DoubleQuotedString,css:'string'},{regex:dp.sh.RegexLib.SingleQuotedString,css:'string'},{regex:new RegExp('\\b([\\d]+(\\.[\\d]+)?|0x[a-f0-9]+)\\b','gi'),css:'number'},{regex:new RegExp('(?!\\@interface\\b)\\@[\\$\\w]+\\b','g'),css:'annotation'},{regex:new RegExp('\\@interface\\b','g'),css:'keyword'},{regex:new RegExp(this.GetKeywords(keywords),'gm'),css:'keyword'}];this.CssClass='dp-j';this.Style='.dp-j .annotation { color: #646464; }'+'.dp-j .number { color: #C00000; }';}
dp.sh.Brushes.Java.prototype=new dp.sh.Highlighter();dp.sh.Brushes.Java.Aliases=['java'];

dp.sh.Brushes.Cpp=function()
{var datatypes='ATOM BOOL BOOLEAN BYTE CHAR COLORREF DWORD DWORDLONG DWORD_PTR '+'DWORD32 DWORD64 FLOAT HACCEL HALF_PTR HANDLE HBITMAP HBRUSH '+'HCOLORSPACE HCONV HCONVLIST HCURSOR HDC HDDEDATA HDESK HDROP HDWP '+'HENHMETAFILE HFILE HFONT HGDIOBJ HGLOBAL HHOOK HICON HINSTANCE HKEY '+'HKL HLOCAL HMENU HMETAFILE HMODULE HMONITOR HPALETTE HPEN HRESULT '+'HRGN HRSRC HSZ HWINSTA HWND INT INT_PTR INT32 INT64 LANGID LCID LCTYPE '+'LGRPID LONG LONGLONG LONG_PTR LONG32 LONG64 LPARAM LPBOOL LPBYTE LPCOLORREF '+'LPCSTR LPCTSTR LPCVOID LPCWSTR LPDWORD LPHANDLE LPINT LPLONG LPSTR LPTSTR '+'LPVOID LPWORD LPWSTR LRESULT PBOOL PBOOLEAN PBYTE PCHAR PCSTR PCTSTR PCWSTR '+'PDWORDLONG PDWORD_PTR PDWORD32 PDWORD64 PFLOAT PHALF_PTR PHANDLE PHKEY PINT '+'PINT_PTR PINT32 PINT64 PLCID PLONG PLONGLONG PLONG_PTR PLONG32 PLONG64 POINTER_32 '+'POINTER_64 PSHORT PSIZE_T PSSIZE_T PSTR PTBYTE PTCHAR PTSTR PUCHAR PUHALF_PTR '+'PUINT PUINT_PTR PUINT32 PUINT64 PULONG PULONGLONG PULONG_PTR PULONG32 PULONG64 '+'PUSHORT PVOID PWCHAR PWORD PWSTR SC_HANDLE SC_LOCK SERVICE_STATUS_HANDLE SHORT '+'SIZE_T SSIZE_T TBYTE TCHAR UCHAR UHALF_PTR UINT UINT_PTR UINT32 UINT64 ULONG '+'ULONGLONG ULONG_PTR ULONG32 ULONG64 USHORT USN VOID WCHAR WORD WPARAM WPARAM WPARAM '+'char bool short int __int32 __int64 __int8 __int16 long float double __wchar_t '+'clock_t _complex _dev_t _diskfree_t div_t ldiv_t _exception _EXCEPTION_POINTERS '+'FILE _finddata_t _finddatai64_t _wfinddata_t _wfinddatai64_t __finddata64_t '+'__wfinddata64_t _FPIEEE_RECORD fpos_t _HEAPINFO _HFILE lconv intptr_t '+'jmp_buf mbstate_t _off_t _onexit_t _PNH ptrdiff_t _purecall_handler '+'sig_atomic_t size_t _stat __stat64 _stati64 terminate_function '+'time_t __time64_t _timeb __timeb64 tm uintptr_t _utimbuf '+'va_list wchar_t wctrans_t wctype_t wint_t signed';var keywords='break case catch class const __finally __exception __try '+'const_cast continue private public protected __declspec '+'default delete deprecated dllexport dllimport do dynamic_cast '+'else enum explicit extern if for friend goto inline '+'mutable naked namespace new noinline noreturn nothrow '+'register reinterpret_cast return selectany '+'sizeof static static_cast struct switch template this '+'thread throw true false try typedef typeid typename union '+'using uuid virtual void volatile whcar_t while';this.regexList=[{regex:dp.sh.RegexLib.SingleLineCComments,css:'comment'},{regex:dp.sh.RegexLib.MultiLineCComments,css:'comment'},{regex:dp.sh.RegexLib.DoubleQuotedString,css:'string'},{regex:dp.sh.RegexLib.SingleQuotedString,css:'string'},{regex:new RegExp('^ *#.*','gm'),css:'preprocessor'},{regex:new RegExp(this.GetKeywords(datatypes),'gm'),css:'datatypes'},{regex:new RegExp(this.GetKeywords(keywords),'gm'),css:'keyword'}];this.CssClass='dp-cpp';this.Style='.dp-cpp .datatypes { color: #2E8B57; font-weight: bold; }';}
dp.sh.Brushes.Cpp.prototype=new dp.sh.Highlighter();dp.sh.Brushes.Cpp.Aliases=['cpp','c','c++'];

function showmenu(){
document.getElementById("menu").style.width="100%";
document.getElementById("menu").style.display="block";
document.getElementById("leftad").style.display="none";
}