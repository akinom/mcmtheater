var applet_width = 200;
var applet_height = 200;

step_list[step_list_n++] = 'index'; 
step_list[step_list_n++] = 'center'; 
step_list[step_list_n++] = 'square'; 

function local_start(title, cls) 
{
   list_start(title, 'Generators', cls, "HalfCircles"); 
}

function local_next(refTxt, para)
{
   list_ref_next(refTxt, para);
}

function local_ref(txt, file) 
{
   wd(qs_ref(txt, file, txt)); 
}

function local_java_ref(cls, txt) {
   return java_src_ref("theaterEx/generators/" + cls + ".java", txt);
}

function local_applet_plain(cls) 
{
   applet_plain('theaterEx', 'generators.' + cls, 
                    new Array(new Array("DEBUG", "false" ) ), 
                    undefined, undefined); 
}

function local_applet_example(cls, title) 
{
   wd(qs_font_color() + title + "</font><BR>") ; 
   applet_plain('theaterEx', 'generators.'  + cls, 
                    new Array(new Array("DEBUG", "false" ) ), 
                    'withSrc', 'restart'); 
}

function local_indent() 
{
   list_indent(); 
}
function local_unindent() 
{
   list_unindent(); 
}
function local_row_spacer() 
{
   list_row_spacer();
}

function local_applet(cls, code, title) 
{
   if (title != undefined) 
      wd("<p>" + qs_font_color() + title + "</font></p>") ; 
   local_indent();
   applet_with_code('theaterEx', 'generators.' + cls, 
                    new Array(new Array("DEBUG", "false" ) ), 
                    code, undefined, undefined); 
   local_unindent();
}

function local_applet_start(title)
{
   if (title != undefined) 
      wd("<p>" + qs_font_color() + title + "</font></p>") ; 
   local_indent(); 
   html();
}

function local_applet_finish(cls, code)
{
   applet_with_code('theaterEx', 'generators.' + cls, 
                    new Array(new Array("DEBUG", "false" ) ), 
                    code, undefined, undefined); 
   local_unindent(); 
   html();
}


function local_menu_ref(txt, menu, sub_menu)
{ 
   return qs_ref_menu_item(txt, menu, sub_menu) 
}
//alert("loaded local.js"); 
