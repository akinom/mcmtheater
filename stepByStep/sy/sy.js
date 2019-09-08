applet_width = qs_body_width - qs_spacer_dist; 

step_list[step_list_n++] = 'index'; 
step_list[step_list_n++] = 'Square'; 
step_list[step_list_n++] = 'RectangleFirst'; 
step_list[step_list_n++] = 'Rectangle'; 
step_list[step_list_n++] = 'Start2Initial'; 
step_list[step_list_n++] = 'Start2First'; 
step_list[step_list_n++] = 'Start2'; 
step_list[step_list_n++] = 'Start2Colored'; 
step_list[step_list_n++] = 'Start2TrailWidth'; 
step_list[step_list_n++] = 'Start5'; 
step_list[step_list_n++] = 'Start5Shape'; 
step_list[step_list_n++] = 'Start5For'; 
 

function sy_start(title, cls) 
{
   list_start(title, 'A First Program', cls, "HalfCircles"); 
}

function sy_next(txt) 
{
   list_ref_next(txt);
}

function sy_applet() {
}
function sy_code(code) {
   applet = 'sy.' + step_list[list_num]; 
   applet_with_code('theaterEx', applet, undefined, code, 'vert');
}

//alert("loaded sy.js"); 
