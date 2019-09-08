var applet_width = 180;
var applet_height = 474;
//var applet_code_width = qs_body_width - list_applet_width - 2 * qs_spacer_dist;
// var list_total_width = qs_body_width - qs_spacer_dist;
var local_debug = "true"; 

step_list[step_list_n++] = 'index'; 
step_list[step_list_n++] = 'OneBounce'; 
step_list[step_list_n++] = 'FourGreenYellow'; 
step_list[step_list_n++] = 'ManyGreenYellow'; 
step_list[step_list_n++] = 'ManyNoTrail'; 
step_list[step_list_n++] = 'ManyNoTrailSpeed'; 

function local_start(title, cls) 
{
   list_start(title, 'Bouncers', cls, "HalfCircles"); 
}

function local_next(refTxt)
{
   list_ref_next(refTxt);
}

function local_ref(txt, file) 
{
   wd(qs_ref(txt, file, txt)); 
}

function local_java_ref(cls) {
   return java_src_ref("theaterEx/bouncer/" + cls + ".java");
}

function local_applet_plain(cls) 
{
      applet_plain('theaterEx', 'bouncer.' + cls, 
                    new Array(new Array("DEBUG", "false")));
}

function local_indent() 
{
   list_indent(); 
}
function local_unindent() 
{
   list_unindent(); 
}

function local_applet(cls, code)
{
   local_indent(); 
   applet_with_code('theaterEx', 'bouncer.' + cls, 
                    new Array(new Array("DEBUG", "false")),
                    code, undefined, 'NoRestart'); 
   local_unindent(); 
}


function local_menu_ref(txt, menu, sub_menu)
{ 
   return qs_ref_menu_item(txt, menu, sub_menu) 
}
//alert("loaded local.js"); 
