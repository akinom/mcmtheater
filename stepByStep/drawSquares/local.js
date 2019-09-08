var applet_width = 180;
var applet_height = 200;
var local_debug = "true"; 

step_list[step_list_n++] = 'index'; 
step_list[step_list_n++] = 'Square'; 
step_list[step_list_n++] = 'While'; 
step_list[step_list_n++] = 'Turn90'; 
step_list[step_list_n++] = 'Size2Turn180'; 
step_list[step_list_n++] = 'Size4Turn180'; 
step_list[step_list_n++] = 'ForExtend10_80'; 
step_list[step_list_n++] = 'ForColor'; 
step_list[step_list_n++] = 'Image'; 

function local_start(title, cls) 
{
   list_start(title, 'Draw Squares', cls, "HalfCircles"); 
}

function local_next(refTxt)
{
   list_ref_next(refTxt);
}

function local_ref(txt, file) 
{
   wd(qs_ref(txt, file, txt)); 
}

function local_applet_plain(cls) 
{
      applet_plain('theaterEx', 'drawSquares.' + cls, 
                    new Array( new Array("SH", "true"),
                               new Array("DEBUG", "false")));
}

function local_applet(cls, code, doRestart) 
{
   local_indent(); 
   applet_with_code('theaterEx', 'drawSquares.' + cls, 
                    new Array( new Array("SH", "true"),
                               new Array("DEBUG", local_debug)),
                    code, undefined, doRestart); 
   local_unindent(); 
}

function local_replace(c1, word,  c2) 
{
   wd("<p>"); 
   list_indent(applet_width + 2 * qs_spacer_dist); 
   applet_replace(c1, word, c2); 
   list_unindent(applet_width + 2 * qs_spacer_dist); 
   wd("</p>"); 
}

function local_snippet(code)
{
   wd("<p>"); 
   list_indent(applet_width + 2 * qs_spacer_dist); 
   wd(qs_code_html(code, undefined, qs_body_width - applet_width)); 
   list_unindent(applet_width + 2 * qs_spacer_dist); 
   wd("</p>"); 
}
    

function local_indent() 
{
   list_indent();
}
function local_unindent() 
{
   list_unindent();
}

//alert("loaded local.js"); 
