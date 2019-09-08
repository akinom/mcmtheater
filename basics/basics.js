qs_path=".."; 
qs_jar_path="."; 

var basics_width = 200;
var basics_stp = 1;
var basics_color = "#f7f7f7";
var basics_frame_color = qs_page_color;
var basics_debug = "true"; 

function basics_start(submenu, title) 
{
  qs_doc_start('MCM Basics', submenu, true); // don't do <HEAD> section
  qs_doc_headline(title);
  qs_body_start(true);
  html(); 
}

function basics_finish(date) 
{
   qs_doc_finish(date);
   html(); 
}

function basics_applet(cls, width, height, doSrc, noRestart)
{
   restart = "Restart"; 
   if (noRestart != undefined) 
      restart = undefined;
   var code = "simpleShapes." + cls; 
   var archive = "simpleShapes";
   var javaSrc; 
   if (doSrc != undefined) 
      javaSrc  = "simpleShapes/" + cls + ".java";

   var applet = qs_applet_src(code, javaSrc, archive, 
                              width, height, 
                              new Array( new Array("DEBUG", basics_debug)), 
                              restart, basics_frame_color, basics_color);
   wd(applet.getHtmlString()); 
}

function basics_lesson(title, cls, height, code) 
{
      var javaSrc = "simpleShapes/" + cls + ".java";
   applet_html = qs_applet_vert_code(
                    "simpleShapes." + cls, javaSrc, "simpleShapes", 
                    basics_width, height, 
                              new Array(
                                  new Array("DEBUG", basics_debug),
                                  new Array("STP", basics_stp) ), 
                    code, 'Restart', 
                    basics_frame_color, basics_color);

   if (title != undefined) {
       title = qs_font_color() + title + "</font>"; 
       applet_html = qs_vert_table(title, applet_html, 1); 
   } 
   wd(applet_html); 
}


function basics_indent() 
{
   wd(qs_indent()); 
}
function basics_unindent() 
{
   wd(qs_unindent()); 
}

function basics_horiz_lesson(cls, height, code, explain, restart) 
{
   var javaSrc = "simpleShapes/" + cls + ".java";
   var applet = "simpleShapes." + cls;
   var archive = "simpleShapes";
   
   wd("<p>"); 

   if (explain != undefined) { 
      basics_indent(); 
      wd("<p>" + qs_font_color() + explain + "</font></p>"); 
      basics_unindent(); 
   }

   basics_indent(); 
   var applet = qs_applet_horz_code(applet, javaSrc, archive, 
                             qs_body_width, basics_width, height, 
                             new Array(
                                  new Array("DEBUG", basics_debug),
                                  new Array("STP", basics_stp) 
                             ), 
                             code, 
			     restart, basics_frame_color, basics_color);
   wd(applet); 
   basics_unindent(); 
   wd("</p>"); 
}

function basics_img_lesson(cls, height, code, explain, restart) 
{
   var javaSrc = "simpleShapes/" + cls + ".java";
   var applet = "simpleShapes." + cls;
   
   wd("<p>"); 

   if (explain != undefined) { 
      basics_indent(); 
      wd("<p>" + qs_font_color() + explain + "</font></p>"); 
      basics_unindent(); 
   }

   basics_indent(); 
   var img = 'img/' + cls + "0.png";
   var lesson =  qs_img_horz_code(cls, javaSrc, img, 
                           qs_body_width, basics_width, height, code,
			   basics_frame_color); 
   wd(lesson); 
   basics_unindent(); 
   wd("</p>"); 
}

function basics_long_lesson_start(title) 
{
   wd("<p>" + qs_font_color() + title + "</font></p>");
   html();
}

function basics_long_lesson_finish(applet, height, code, restart)
{
   basics_horiz_lesson(applet, height, code, undefined, restart); 
   html();
}

