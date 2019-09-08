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

function local_applet_plain(cls, params) 
{
   if (params == undefined) {
      params = new Array(); 
   } 
   params[params.length] = new Array("DEBUG", "false"); 
   applet_plain(local_pkg, cls, params); 
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


function local_student(subsection, starterClass, helperClass, params) 
{
   wd(qs_table_start(0)); 
   wd("<TR><TD>"); 
   local_applet_plain(starterClass, params); 
   wd(local_java_ref(starterClass));
   if (helperClass != undefined) { 
      wd("<BR>"); 
      wd(local_java_ref('alex.TryMe', 'TryMe'));
   }
   wd("</TD></TR>");
   wd(qs_table_finish()); 

}

// alert("loaded local.js"); 
