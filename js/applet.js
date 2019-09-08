function Applet(name, code, archives, width, height) {
	this._name = name;
	this._code = code; 
	this._archives = archives; 
	this._params = new Array(); 
	this._htmlTags = ""; 
	this._width = width; 
	this._height = height; 
}

Applet.prototype._name;
Applet.prototype._code;
Applet.prototype._archives; 
Applet.prototype._params ;
Applet.prototype._width;
Applet.prototype._height;

Applet.prototype.addParam = function(name, value) {
	i = this._params.length; 
	this._params[i] = new Array(name, value); 
}

Applet.prototype.getHtmlString = function() {
   if (_ns) { 
      return this.geEmbedString(); 
   } 
   if (_ie) { 
      return this.getObjectString(); 
   }
   return this.geAppletString(); 
}

Applet.prototype.geAppletString = function() {
   s = ""; 
   s += '<APPLET name=' + this._name + ' ' + this._htmlTags + ' ' ; 
   s += '        CODE=' + this._code + ' ';
   s += '        ARCHIVE="' + this._archives + '"\n' ;  
   s += '        WIDTH=' + this._width + ' ' ; 
   s += '        HEIGHT=' + this._height + ' ' ; 
   s += '\n';
   s += '        ALT="If you could run this applet, ' + 
                  'you would see some animation">\n'; 
   for (i = 0; i < this._params.length; i++) {
        s += '        <PARAM name=' + this._params[i][0] + " value=" + this._params[i][1] + ">\n"; 
   }
   s += '        Your browser is completely ignoring the &lt;APPLET&gt; tag!\n'; 
   s += '</APPLET>\n';  
   return s; 
}

Applet.prototype.geEmbedString = function() {
   s = ""; 
   s += '<EMBED  name="' + this._name + '" type="application/x-java-applet;version=1.3" '; 
   s += '       code="' + this._code + '" '; 
   s += '       java_archive="' + this._archives + '" ' ; 
   s += '       width="' + this._width + '" ' ; 
   s += '       height="' + this._height + '" '; 
   s += '   ' + this._htmlTags + '\n'; 
   for (i = 0; i < this._params.length; i++) {
        s += '        ' + this._params[i][0] + '="' + this._params[i][1] + '"\n'
   }
   s += '      pluginspage="http://java.sun.com">\n';
   s += '<NOEMBED>\n'; 
   s += '    No Java 2 SDK, Standard Edition v 1.3 support for APPLET!!\n'; 
   s += '</NOEMBED>\n'; 
   s += '</EMBED>\n'; 
return s;
} 

Applet.prototype.getObjectString = function() {
   s = '<OBJECT name="' + this._name + ' "classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"\n'; 
   s += '       width="' + this._width + '" ' ; 
   s += '       height="' + this._height + '" '; 
   s += '   ' + this._htmlTags + '\n'; 
   s+= '        codebase="http://java.sun.com">\n';
   s += '<PARAM NAME="code" VALUE="' + applet._code + '">\n'; 
   s += '<PARAM NAME="archive" VALUE="' + applet._archives + '">\n'; 
   s += '<PARAM NAME="type" VALUE="application/x-java-applet;version=1.3">\n'; 
   s += '<PARAM NAME="scriptable" VALUE="false">\n'; 
   for (i = 0; i < this._params.length; i++) {
        s += '        <PARAM name=' + this._params[i][0] + " value=" + this._params[i][1] + ">\n"; 
   }
   s += '</OBJECT>'; 
   return s;
}
