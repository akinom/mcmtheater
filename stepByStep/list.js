
var list_num; 
var list_next; 
var list_prev; 

var step_list = new Array(); 
var step_list_n = 0;
 

function list_get_num(cls) 
{
    var i = 0; 
    for (i = 0; i < step_list_n; i++) {
     if (step_list[i] == cls) 
          return i; 
    }
    return undefined;
}

function list_start(title, submenu, cls, image) 
{
  if (cls != undefined) {
     list_num = list_get_num(cls); 
  }
  if (image != undefined && list_num != undefined) {
      qs_set_header_image(image + list_num);
  }
  qs_doc_start('Step By Step', submenu, true); 
  if (cls == undefined) {
     qs_doc_headline(title);
  } else {
     //alert("list_start: " + submenu + " " + cls + " ->" + list_num); 
     if (list_num != undefined) {
        if (list_num > 0) 
          list_prev = step_list[list_num-1] + ".html"; 
        if (list_num < step_list_n -1) 
          list_next = step_list[list_num+1] + ".html"; 
     }
     html(); 
     wd(qs_table_start(0, 632));  
        wd("<TR><TD align=left width=120px>"); 
           wd(qs_ref("Prev", list_prev, 'Previous Step'));
        wd("</TD><TD align=center>"); 
        wd(qs_font_color() + title + "</font>") ; 
        wd("</TD><TD align=right width=120px>"); 
           wd(qs_ref("Next", list_next, 'Next Step'));
        wd("</TD></TR>"); 
     wd(qs_table_finish()); 
     var table = html_get(); 
     qs_doc_headline(table);
  }
  qs_body_start(true);
}

function list_ref_next(txt, paragraph) 
{
   if (list_next != undefined) { 
      if (txt == undefined) {
         txt = "See next step.";
      }
      if (paragraph == undefined) {
          wd("<p>"); 
      }
      wd(qs_ref(txt, list_next, 'Next Step'));
      if (paragraph == undefined) {
         wd("</p>"); 
      }
   }
}

function list_ref_prev(txt, paragraph) 
{
   if (list_prev != undefined) { 
      if (txt == undefined) {
         txt = "See previous step.";
      }
      if (paragraph == undefined) {
          wd("<p>"); 
      }
      wd(qs_ref(txt, list_prev, 'Previous Step'));
      if (paragraph == undefined) {
         wd("</p>"); 
      }
   }
}


function list_row_spacer(delta) 
{
   wd(qs_row_spacer(delta)); 
}

function list_indent(delta) 
{
   wd(qs_indent(delta)); 
}

function list_unindent(delta) 
{
   wd(qs_unindent(delta)); 
}

//alert("loaded list.js"); 
