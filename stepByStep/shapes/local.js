var applet_width = 200;
var applet_height = 200;
var local_debug = "false";

step_list[step_list_n++] = 'index'; 
step_list[step_list_n++] = 'ShapeOnce'; 
step_list[step_list_n++] = 'ShapeSize'; 
step_list[step_list_n++] = 'ShapeMultiple'; 
step_list[step_list_n++] = 'ShapeRotations'; 
step_list[step_list_n++] = 'ShapeThree'; 
step_list[step_list_n++] = 'ShapeLine'; 
step_list[step_list_n++] = 'ShapeMultiLine'; 
step_list[step_list_n++] = 'ShapeJump'; 
step_list[step_list_n++] = 'ShapeMoveClean'; 
step_list[step_list_n++] = 'ListShapeMoveClean'; 

function local_start(title, cls) 
{
   list_start(title, 'Triangles ...', cls, "HalfCircles"); 
}

function local_next(refTxt, paragraph)
{
   list_ref_next(refTxt, paragraph);
}

function local_prev(refTxt, paragraph) {
   list_ref_prev(refTxt, paragraph);
}

function local_ref(txt, file) 
{
   wd(qs_ref(txt, file, txt)); 
}

function local_java_ref(cls, txt) {
   return java_src_ref("theaterEx/shapes/triangle/" + cls + ".java", txt);
}

function local_applet_example(cls, title) 
{
   if (title != undefined) { 
      wd(qs_font_color() + title + "</font><BR>") ; 
   }
   applet_plain('theaterEx', 'shapes.triangle.' + cls, 
                    new Array(new Array("DEBUG", local_debug ) ), 
                    'withSrc', 'restart'); 
}

function local_applet_plain(cls) 
{
   applet_plain('theaterEx', 'shapes.triangle.' + cls, 
                    new Array(new Array("DEBUG", local_debug ) ), 
                    undefined, undefined); 
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

function local_applet(cls, code)
{
   local_indent(); 
   applet_with_code('theaterEx', 'shapes.triangle.' + cls, 
                    new Array(new Array("DEBUG", local_debug ) ), 
                    code, undefined, undefined); 
   local_unindent(); 
}

function local_vert_applet(cls, code)
{
   applet_with_code('theaterEx', 'shapes.triangle.' + cls, 
                    new Array(new Array("DEBUG", local_debug ) ), 
                    code, 'vert', undefined); 
}

function local_menu_ref(txt, menu, sub_menu)
{ 
   return qs_ref_menu_item(txt, menu, sub_menu) 
}
//alert("loaded local.js"); 
