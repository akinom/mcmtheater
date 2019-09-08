var applet_width = qs_body_width - qs_spacer_dist;
var applet_height = 450;
var local_pkg = 'gallery';  

function local_start(title, submenu) 
{
   qs_doc_start('Gallery', submenu, true); 
   qs_doc_headline(title);
   qs_body_start(true);
   html();
}

function local_ref(txt, file) 
{
   wd(qs_ref(txt, file, txt)); 
}

function local_java_ref(cls, txt, mode) {
   if (mode == undefined) {
      prefix = 'JavaSource: '; 
   } else {
      prefix = '';
   }
   if (txt == undefined) {
      txt = prefix  + 'Initial Actor'; 
   } else {
      txt = prefix  + txt;
   }
   return java_src_ref(local_pkg + "/" + cls + ".java", txt);
}

function local_applet_plain(cls) 
{
      applet_plain(local_pkg, cls,
                        new Array(new Array("DEBUG", "false"))); 
}

function local_indent() 
{
   wd(qs_indent());
}
function local_unindent() 
{
   wd(qs_unindent());
}

function local_applet(cls, code)
{
   local_indent(); 
   list_applet_code(local_pkg, cls, 
                    "<PARAM NAME=DEBUG VALUE=false>", 
                    code, undefined, undefined); 
   local_unindent(); 
}


function local_menu_ref(txt, menu, sub_menu)
{ 
   return qs_ref_menu_item(txt, menu, sub_menu) 
}

function list_indent(delta) 
{
   wd(qs_indent(delta)); 
}

function list_unindent(delta) 
{
   wd(qs_unindent(delta)); 
}


function local_student(zip, starterClass, helperClass, params) 
{
   wd('<p>' + 
       'After a brief course, spread over 7 periods, 7 and 8th ' + 
       'grade students at ' + 
       qs_ref('Galloay', 'http://www.gallowayschool.org') + 
       ' programmed these screensavers. ' + 
       '</p>'); 

   wd('<p>'); 
   wd('To download the screensavers click'); 
   wd('<a href=' + zip + '> here</a>.'); 
   wd('</p>'); 

   wd('<p>'); 
   wd(qs_table_start(0)); 
   wd("<TR><TD>"); 
   local_applet_plain(starterClass, params); 
   wd(local_java_ref(starterClass));
   if (helperClass != undefined) { 
      wd("<BR>"); 
      wd(local_java_ref(helperClass, 'TryMe'));
   }
   wd("</TD></TR>");
   wd(qs_table_finish()); 
   wd('</p>'); 
}

// alert("loaded local.js"); 
