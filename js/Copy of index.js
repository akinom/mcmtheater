// =======================================================================
// Modified Copy of TechTSP's MASTER_FILES/index.js
// =======================================================================
// global state/variables: must be set before calling qs_start_doc
// most are kept the same for all page sets 
//
// CONVENTIONS: 
// -----------
// IMAGES: 
//   img directory for images 
//   img/trans.gif: transparent one pixel image 
//   img/qsbg.jpg: height 1px, width=real wide, 2pixel in color scheme color
//   img/qslogo.jpg:  logo adapted to color scheme 
//
// COLOR VARIABLES 
//   var qs_page_color: scheme's foreground color 
//   var qs_link_color: scheme's foreground color
//   var qs_link_hover: color sufficiently diffent from foregound color
//   var qs_background_color: color scheme foreground color 
//   var qs_background:  color used for off white background in bckground image
// img/qspagecolor.jpg 1 pixel in color scheme color 
//
// MENU
//   the menu is build on the basis of the global qs_menu_target array variable
//   the function qs_build_menu_table builds the main menu on the left of the 
//   web page, qs_menu_across builds the menu references at the bottom of the 
//   page.  qs_location and qs_location_ref are helper fcts. All these functions//   are specific to page sets 
// 
// A minimal web page with menu is build as follows: 
//    1) include this file 
//    2) add script section with: 
//            qs_path = <PATH to this file";
//            qs_doc_start('Menu Item', 'Submenuitem');
//            qs_body_start(true);
//            html();
//    3) page contents 
//    4) script section with 
//            qs_doc_finish("DATE"); 
//            html(); 
// 
// A minimal web page without menu is build as follows: 
//    1) include this file 
//    2) add script section with: 
//            qs_path = <PATH to this file";
//            qs_img_doc_start('Menu Item', 'Submenuitem', 'headline');
//            html();
//    3) page contents 
//    4) script section with 
//            qs_img_doc_finish("DATE");
//            html(); 
//
// optionally the following functions may be called: 
//   qs_doc_title(text)   == set the title to text instead of default string
//   qs_doc_headline(text) == underline headline at beginning of page contents
//
//   qs_row_spacer(w, h) == add a transparent spacer row, sizes are in pixels
//                          maybe called just before qs_doc_finish
//   qs_menu_set_bling_html(html) == insert html above menu 
// ---------------------------------------------------------------------


// ---------------------------------------------------------------------
// these variables are rarely changed 
var qs_trans_img = 'img/trans.gif'; 
var qs_page_width = 800;
var qs_body_width = 632;
var qs_spacer_dist = 12; 

// qspath the path to this file relative to the including file 
var qs_path = '.'; 
var qs_mcmTheater_jar = "jar/mcmTheater.jar"; 

// these vars are the same for whole sets of pages 
// paths are givemn relative to this_location/qs_path
var qs_dot_img = 'img/qsdot.png'; 
var qs_background_img = 'img/qsbg.jpg'; 
var qs_background_color = '#f7f2f6';
var qs_color_img = 'img/qspagecolor.jpg'; 

var qs_link_hover = '#8c2633'; // concorde red 
var qs_link_hover = '#ff8e05'; // orangy 

var qs_page_color = '#336799'; 
var qs_link_color = qs_page_color;
var qs_link_visited = qs_page_color; 
var qs_link_hover = '#ef791f'; 

var qs_code_color = "#e6e6e6";
var qs_lesson_code_padding = 8; 
var qs_line_size = 14;

var qs_my_location = "UNDEFINED MY LOCATION"; 
var qs_my_menu     = "UNDEFINED"; 
var qs_my_sub_menu = "UNDEFINED SUB MENU"; 

var qs_menu_bling_bling; 

function qs_init_vars(menu_loc, sub_menu_loc, tit)
{
   qs_dot_img = qs_path + '/' + qs_dot_img;
   qs_background_img = qs_path + '/' + qs_background_img;
   qs_color_img = qs_path + '/' + qs_color_img;
   qs_trans_img = qs_path + '/' + qs_trans_img;
   qs_mcmTheater_jar = qs_path + "/" + qs_mcmTheater_jar;
   qs_my_location = qs_location(menu_loc, sub_menu_loc);
   qs_my_menu = menu_loc; 
   qs_my_sub_menu = sub_menu_loc; 
}

// ---------------------------------------------------------------------
// Menu definition
// is the same for a whole set of pages 
// ---------------------------------------------------------------------
var qs_menu_target = new Array(); 
var qs_menu_image = new Array(); 

qs_menu_target[qs_location('MCM Theater Home', undefined)] = "index.html"; 

qs_menu_target[qs_location("MCM Basics", undefined)] = "basics/index.html"; 
qs_menu_target[qs_location("MCM Basics", 'Moving')] = "basics/move.html"; 
qs_menu_target[qs_location("MCM Basics", 'Movement Speed')] = "basics/moveSpeed.html"; 
qs_menu_target[qs_location("MCM Basics", 'Turning')] = "basics/turn.html"; 
qs_menu_target[qs_location("MCM Basics", 'Jumping')] = "basics/jump.html";
qs_menu_target[qs_location("MCM Basics", 'TrailColor/Width')] = "basics/colorWidth.html"; 
qs_menu_target[qs_location("MCM Basics", 'Shapes')] = "basics/shapes.html"; 
qs_menu_target[qs_location("MCM Basics", 'Time')] = "basics/time.html"; 
qs_menu_target[qs_location("MCM Basics", 'Multiple Actors')] = "basics/multiple.html"; 

qs_menu_target[qs_location("Step By Step", undefined)] = "stepByStep/index.html"; 
qs_menu_target[qs_location("Step By Step", 'A First Program')] = "stepByStep/sy/index.html"; 
qs_menu_target[qs_location("Step By Step", 'Bouncers')] = "stepByStep/bouncer/index.html"; 
qs_menu_target[qs_location("Step By Step", 'Triangles ...')] = "stepByStep/shapes/index.html"; 
qs_menu_target[qs_location("Step By Step", 'Jumpers')] = "stepByStep/jumpers/index.html"; 
qs_menu_target[qs_location("Step By Step", 'Generators')] = "stepByStep/generators/index.html"; 
qs_menu_target[qs_location("Step By Step", 'Draw Squares')] = "stepByStep/drawSquares/index.html"; 

qs_menu_target[qs_location("Gallery", undefined)] = "gallery/index.html"; 
qs_menu_target[qs_location("Gallery", 'Attraction')] = "gallery/attraction.html"; 
qs_menu_target[qs_location("Gallery", 'Follow The Leader')] = "gallery/follower.html"; 
qs_menu_target[qs_location("Gallery", 'Spirals')] = "gallery/spirals.html"; 
qs_menu_target[qs_location("Gallery", 'Growing Shapes')] = "gallery/growAndClone.html"; 
qs_menu_target[qs_location("Gallery", 'Marching Blocks')] = "gallery/marching.html"; 
qs_menu_target[qs_location("Gallery", 'Mona Lisa')] = "gallery/monaLisa.html"; 
qs_menu_target[qs_location("Gallery", 'Falling Leafs')] = "gallery/leafs.html"; 
qs_menu_target[qs_location("Gallery", 'Boat Collage')] = "gallery/boat.html"; 
qs_menu_target[qs_location("Gallery", 'Pulsing Circle')] = "gallery/jumpMove.html"; 
qs_menu_target[qs_location("Gallery", 'Circle Segments')] = "gallery/shootLines.html"; 
qs_menu_target[qs_location("Gallery", 'Exponential Growth')] = "gallery/exponential.html"; 
qs_menu_target[qs_location("Gallery", 'Galloway')] = "class/2006.galloway/index.html"; 

qs_menu_target[qs_location("Games", undefined)] = "games/index.html"; 
qs_menu_target[qs_location("JavaDoc", undefined)] = "javadoc/index.html"; 

qs_menu_target[qs_location("Downloads", undefined)] = "downloads/index.html"; 

qs_menu_target[qs_location("DrJava", undefined)] = "drJava/index.html"; 

qs_menu_target[qs_location("Contact", undefined)] = "contact/index.html"; 

qs_menu_image[qs_location('MCM Theater Home', undefined)] = "spiralToss"; 
qs_menu_image[qs_location("MCM Basics", undefined)] = "rectangles"; 
qs_menu_image[qs_location("MCM Basics", 'Moving')] = "followTheLeader"; 
qs_menu_image[qs_location("MCM Basics", 'Movement Speed')] = "wheel"; 
qs_menu_image[qs_location("MCM Basics", 'Turning')] = "spiralToss"; 
qs_menu_image[qs_location("MCM Basics", 'Jumping')] = "spiralJump"; 
qs_menu_image[qs_location("MCM Basics", 'TrailColor/Width')] = "widthColorSquareJump";
qs_menu_image[qs_location("MCM Basics", 'Shapes')] = "balloons";
qs_menu_image[qs_location("MCM Basics", 'Time')] = "HalfCircles17";
qs_menu_image[qs_location("MCM Basics", 'Multiple Actors')] = "MarchingLine"; 

qs_menu_image[qs_location("Step By Step", undefined)] = "HalfCircles5"; 
//qs_menu_image[qs_location("Step By Step", 'Bouncers')] = "balloons"; 
//qs_menu_image[qs_location("Step By Step", 'Triangles ...')] = "balloons"; 
//qs_menu_image[qs_location("Step By Step", 'Jumpers')] = "growSquares"; 
//qs_menu_image[qs_location("Step By Step", 'Generators')] = "balloons"; 
//qs_menu_image[qs_location("Step By Step", 'Draw Squares')] = "rectangles"; 

qs_menu_image[qs_location("Gallery", undefined)] = "bubbles"; 
qs_menu_image[qs_location("Gallery", "Attraction")] = "followTheLeader"; 
qs_menu_image[qs_location("Gallery", "Follow The Leader")] = "followTheLeader"; 
qs_menu_image[qs_location("Gallery", "Boat Collage")] = "balloons"; 
qs_menu_image[qs_location("Gallery", "Pulsing Circle")] = "HalfCircles10"; 
qs_menu_image[qs_location("Gallery", "Circle Segments")] = "cornerShooter"; 
qs_menu_image[qs_location("Gallery", "Spirals")] = "spiralToss"; 
qs_menu_image[qs_location("Gallery", "Growing Shapes")] = "growSquares"; 
qs_menu_image[qs_location("Gallery", "Marching Blocks")] = "bubblesSolid"; 
qs_menu_image[qs_location("Gallery", "Mona Lisa")] = "HalfCircles8"; 
qs_menu_image[qs_location("Gallery", "Falling Leafs")] = "HalfCircles17"; 
qs_menu_image[qs_location("Gallery", 'Exponential Growth')] = "bubbles"; 
qs_menu_image[qs_location("Gallery", 'Galloway')] = "rectangles"; 

qs_menu_image[qs_location("Games", undefined)] = "bubbles"; 

qs_menu_image[qs_location("Downloads", undefined)] = "widthColorSquareJump"; 

qs_menu_image[qs_location("DrJava", undefined)] = "widthColorSquareJump"; 

qs_menu_image[qs_location("Contact", undefined)] = "widthColorSquareJump"; 

function qs_ref_menu_item(txt, menu, sub_menu) 
{
   return qs_menu_ref(qs_my_location, qs_location(menu, sub_menu), txt); 
}

// PRIVATE (specific to page set)  
function qs_build_menu_table(menu_loc, sub_menu_loc) 
{
   wd(qs_table_start(0, undefined)); 
   if (qs_menu_bling_bling != undefined) { 
      qs_menu_insert_bling_bling(qs_menu_bling_bling); 
      wd(qs_row_spacer(4)); 
      qs_menu_separator(qs_color_img)
   }
   qs_menu_item(menu_loc, sub_menu_loc, 'MCM Theater Home', undefined); 
   qs_menu_separator(qs_color_img)

   if (qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', undefined)) {
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'Moving');
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'Movement Speed');
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'Turning');
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'Jumping');
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'TrailColor/Width');
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'Shapes');
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'Time');
        qs_menu_item(menu_loc, sub_menu_loc, 'MCM Basics', 'Multiple Actors');
   }
   qs_menu_separator(qs_color_img)

   if (qs_menu_item(menu_loc, sub_menu_loc, 'Step By Step', undefined)) {
   	qs_menu_item(menu_loc, sub_menu_loc, 'Step By Step', 'Bouncers');
   	qs_menu_item(menu_loc, sub_menu_loc, 'Step By Step', 'Draw Squares');
   	qs_menu_item(menu_loc, sub_menu_loc, 'Step By Step', 'Triangles ...');
   	qs_menu_item(menu_loc, sub_menu_loc, 'Step By Step', 'A First Program');
   	qs_menu_item(menu_loc, sub_menu_loc, 'Step By Step', 'Jumpers');
   	qs_menu_item(menu_loc, sub_menu_loc, 'Step By Step', 'Generators');
   }
   qs_menu_separator(qs_color_img)

   if (qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', undefined)) {
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Falling Leafs'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Mona Lisa'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Boat Collage'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Galloway'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Pulsing Circle'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Circle Segments'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Spirals'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Growing Shapes'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Marching Blocks'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Attraction'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Follow The Leader'); 
      qs_menu_item(menu_loc, sub_menu_loc, 'Gallery', 'Exponential Growth'); 
   }
   qs_menu_separator(qs_color_img)

   qs_menu_item(menu_loc, sub_menu_loc, 'Games', undefined); 
   qs_menu_separator(qs_color_img)

   qs_menu_item(menu_loc, sub_menu_loc, 'JavaDoc', undefined); 
   qs_menu_separator(qs_color_img)

   qs_menu_item(menu_loc, sub_menu_loc, 'DrJava', undefined); 
   qs_menu_separator(qs_color_img)

   qs_menu_item(menu_loc, sub_menu_loc, 'Downloads', undefined); 
   qs_menu_separator(qs_color_img)

   qs_menu_item(menu_loc, sub_menu_loc, 'Contact', undefined); 

   wd(qs_table_finish()); 
}

// PRIVATE (specific to page set)  
function qs_menu_across() 
{
   cur_loc = qs_location(qs_my_menu, qs_my_sub_menu); 
   wd(qs_menu_ref(cur_loc, qs_location('MCM Theater Home', undefined), 
	       'MCM Theater Home')); 
}

// PRIVATE (specific to page set)  
function qs_dot() 
{
   return '<img src=' + qs_dot_img + " align=middle>"; 
}

function qs_location(item_text, sub_item_text ) 
{
   loc = 'MCM Theater Home';
   if (item_text != 'MCM Theater Home')  {
      loc +=  ' > ' + item_text;
   }
   if (sub_item_text != undefined)  {
      loc += ' > ' + sub_item_text; 
   } 
   return loc; 
}

// PRIVATE (specific to page set)  
function qs_location_ref(item_text, sub_item_text, color) 
{
   loc = qs_location('MCM Theater Home', undefined); 
   s = qs_menu_ref(qs_my_location, loc, 'MCM Theater Home', color); 

   if (item_text != 'MCM Theater Home')  {
      loc = qs_location(item_text, undefined); 
      s += ' > ' + qs_menu_ref(qs_my_location, loc, item_text, color); 
   }
   if (sub_item_text != undefined) { 
      loc = qs_location(item_text, sub_item_text); 
      s += ' > ' + qs_menu_ref(qs_my_location, loc, sub_item_text, color);
   }
   if (color != undefined) {
      s = '<font color=' + color + '>' + s + '</font>'; 
   }
   return s;
}

// =======================================================================
// =======================================================================
// =======================================================================
// from here on it's the same for all page sets 
// -----------------------------------------------------------------------

// -----------------------------------------------------------------------
// always need an undefined 
// -----------------------------------------------------------------------
var undefined; 

// ---------------------------------------------------------------------------
// table 
// ---------------------------------------------------------------------------
var number_of_open_tables = 0; 

// table with colored background 
function qs_colored_table_start(padding, framecolor, tableWidth, extra)
{
   if (extra == undefined) 
      extra = " "; 
   if (framecolor == undefined) 
      framecolor = qs_page_color; 
   if (tableWidth == undefined)  {
      tableWidth = ""; 
   } else {
      tableWidth=" width=" + tableWidth; 
   }
   number_of_open_tables = number_of_open_tables + 1;
   return ('<TABLE cellpadding=' + padding + ' cellspacing=0 border=0 bgcolor=' +
       framecolor + tableWidth + " " + extra + '>'); 
}

function qs_framed_table_start(frameWidth, framecolor, tableColor,
                               tableWidth, tableHeight, extra)
{
   if (extra == undefined) 
      extra = " "; 
   if (tableHeight == undefined) {
      tableHeight=" ";
   } else {
      tableHeight=" height=" + tableHeight +  " " ;
   }
   tableSmallWidth = tableWidth; 
   if (tableWidth != undefined) 
      tableSmallWidth= tableWidth - 2;
   s = qs_colored_table_start(frameWidth, framecolor, 
                                 tableWidth, tableHeight + extra) + 
          "<TR><TD>" +
          qs_table_start(0, tableSmallWidth, 'bgcolor=' + tableColor +
                     ' height=100%');
   return s;
}

function qs_framed_table_finish()
{
   return qs_table_finish() + 
          "</TD></TR>" +  
          qs_table_finish(); 
}
   

function qs_table_start(b, w, extra) 
{
   number_of_open_tables = number_of_open_tables + 1;
   width = ""; 
   if (w != undefined) {
      width = " width=" + w ;
   }
   if (extra == undefined) { extra = ""; }
   s = '<table cellpadding=0 cellspacing=0 vspace=0 hspace=0' +
       ' border=' + b + 'px ' + width + " " + extra + ">";
   return s; 
}

function qs_table_finish() 
{
   number_of_open_tables--; 
   return "</table>"; 
}

function qs_tr(html, extra) 
{
   if (extra == undefined) extra = ""; 
   s =  "<TR " + extra + "> " + html + "</TR>"; 
   return s;
}

function qs_td(html, extra) 
{
   if (extra == undefined) extra = ""; 
   s = "<TD " + extra + "> " + html + "</TD>"; 
   return s;
}

function qs_row_spacer(height) 
{
   if (height == undefined) {
      height = qs_spacer_dist; 
   }
   return '<tr><td ' + qs_debug_color() + '>' + 
      qs_spacer_img(1, height, qs_trans_img) + 
      '</td></tr>';
}

function qs_col_spacer(w, h, colsp, extra)
{
   var span = ''; 
   if (extra == undefined) extra = ""; 
   if (colsp != undefined && colsp != 1) span = ' colspan=' + colsp; 
   return('<td ' + span + ' ' + extra + ' width=' + w + 'px height=' + h + 'px>' + 
            qs_spacer_img(w, h, qs_trans_img)  + '</td>');
}

function qs_horz_table(left_html, right_html, spacing, extra) 
{
   if (spacing == undefined) spacing = 24; 
   return (qs_table_start(0, extra)) + 
           (qs_tr(qs_td(left_html, 'valign=top') + 
                  qs_col_spacer(spacing, 1) + 
	          qs_td(right_html, 'valign=top'))) + 
           (qs_table_finish()); 
}

function qs_vert_table(top_html, bottom_html, spacing, extra) 
{
   if (spacing == undefined) spacing = 24; 
   return (qs_table_start(0, extra)) + 
          (qs_tr(qs_td(top_html))) + 
          (qs_row_spacer(spacing)) + 
          (qs_tr(qs_td(bottom_html))) + 
          (qs_table_finish()); 
}


// ----------------------------------------------------------------------------
// generators for <a href= ....
// ----------------------------------------------------------------------------
function qs_goto_link(location) {
    try {
          document.location.href=location; 
    } catch (e) {;}
}

function qs_reload(txt) 
{
    return qs_ref(txt, "JavaScript:window.location.reload()", "Reload"); 
}

function qs_go_back_ref(txt) 
{
  return "<a href=javascript:history.back();>" + txt + "</a>"; 
} 

function qs_ref(text, target, status) 
{
   if (target == undefined) 
      return "&nbsp;"; 
   s = "<a href='" + target + "'";
   if (status == undefined) {   
     status = target;
   }
   s += ' onMouseOver="window.status=\'' + status + '\'; return true;" ' +
	' onMouseOut="window.status=\'' + qs_my_location + '\'; return true;"';
   s += ">" + text + "</a>"; 
   return s;
} 

// ----------------------------------------------------------------------------
// utility fcts 
// ----------------------------------------------------------------------------
function qs_spacer_img(w, h, img) 
{
      return '<img src=' + img + ' height=' + h + 'px ' + 
			 'width=' + w + 'px>'; 
}

function qs_color_txt(html) 
{
    return qs_font_color() + html + "</font>"; 
} 

function qs_font_color(sz) 
{
   if (sz != undefined) {
      size = 'size=' + sz; 
   } else {
      size = ''; 
   } 
   //return '<font ' + size + '>'; 
   return '<font ' + size + ' color=' + qs_page_color + '>'; 
}

function qs_indent(pix) 
{
   if (pix == undefined) 
      pix = qs_spacer_dist; 
   qs_body_width -= pix; 
   return qs_table_start(0) + "<TR>" + qs_col_spacer(pix, 1) + "<TD>";  
}

function qs_unindent(pix) 
{
   if (pix == undefined) 
      pix = qs_spacer_dist; 
   qs_body_width += pix; 
   return "</TD></TR>" + qs_table_finish();
}
// ---------------------------------------------------------------------------
// support for qs_menu function 
// ---------------------------------------------------------------------------
function qs_menu_ref(cur_loc, item_loc, text, color)
{
   if (color == undefined)  {
       precolor = ''; 
       postcolor = ''; 
   } else  { 
       precolor = '<font color=' + color + '>'; 
       postcolor = '</font>'; 
   }
   var href = new String(qs_menu_target[item_loc]); 
   if (href.match(/^http:/)) {
      target_file = href; 
   } else {
      target_file = qs_path + "/" + qs_menu_target[item_loc]; 
   } 
   s = ('<a href=' + target_file + ' ' +
         'onMouseOver="window.status=\'' + item_loc + '\'; return true;" ' +
	 'onMouseOut="window.status=\'' + cur_loc + '\'; return true;">' +
	 precolor + text + postcolor + '</a>'); 
   return s;
}

function qs_menu_item(cur_menu, cur_sub_menu, item_text, sub_item_text)
{
   cur_loc = qs_location(cur_menu, cur_sub_menu); 
   item_loc = qs_location(item_text, sub_item_text); 
   target_file = qs_path + "/" + qs_menu_target[item_loc]; 
   subitem  = (sub_item_text != undefined); 
   istext = (item_loc == cur_loc); 
   color = qs_page_color; 
   if (subitem) {
      text = sub_item_text; 
   } else {
      text = item_text;
   }
   if (istext) {
     ptr = '>&nbsp;';  
     //ptr = qs_dot() + "&nbsp;"
   } else {
     ptr = '&nbsp'; 
   }
   wd('<tr>'); 
   wd(qs_col_spacer(8,1, 1)); 
   wd(qs_col_spacer(8,1, 1)); 
   wd('<td width=16px><font color=' + color + '>' + ptr + '</font></td>');
   if (subitem) {
       wd(qs_col_spacer(16,1, 1)); 
       wd('<td align=left>'); 
   } else {
       wd('<td colspan=2 align=left>'); 
   } 
   wd(qs_menu_ref(cur_loc, item_loc, text));
   wd('</td></tr>'); 
   return (cur_menu == item_text);
}

function qs_menu_separator(color_img)
{
   wd('<tr>'); 
   wd(qs_col_spacer(8,1, 1));  
   wd('<td colspan=4 height=16px>' + 
      '<img src=' + color_img + ' width=144px height=2px>' + 
      '</td>');
   wd('</tr>'); 
}

function qs_menu_insert_bling_bling(html) 
{
   wd('<tr>'); 
   wd(qs_col_spacer(8,1, 1)); 
   wd('<td colspan=4 width=144px>');
   wd(html); 
   wd('</td></tr>'); 
} 

// --------------------------------------------------------------------------
// fcts used in page building 
// --------------------------------------------------------------------------
var qs_do_head = true; 

// EXPORTED; used in pages that request non default title 
function qs_doc_title(str) 
{
   if (qs_do_head) {
      wd('<meta content="text/html; charset=ISO-8859-1 ' + 
         'http-equiv="content-type">' + 
         '<title>' + str + '</title>' + 
         '</head>'); 
      qs_do_head = false;
   }
}

// EXPORTED 
function qs_menu_set_bling_html(html) 
{
    qs_menu_bling_bling = html; 
}

// EXPORTED
var qs_header_image; 
function qs_set_header_image(img) {
   qs_header_image = img; 
}
function qs_get_header_image() {
   if (qs_header_image == undefined)  
       qs_header_image =  qs_menu_image[qs_my_location]; 
   if (qs_header_image != undefined)  
      s =  '<img src=' + qs_path + '/img/header/' + qs_header_image  + '.png>'; 
   else
      s =  '<img src=' + qs_color_img + " width=792px height=12px>"; 
   return s;
}

function qs_doc_start(menu_loc, sub_menu_loc, dotitle, tit) {
   // init vars and build top of page 
   qs_determine_browser(); 
   qs_doc_setup(menu_loc, sub_menu_loc, true, dotitle, tit);

   wd(qs_table_start(0, undefined));
   qs_doc_row(1, qs_page_color);
   wd(qs_row_spacer(6)); 
   // setup doc line 
   // menu in first 2 cols on left,  page content in 2 cols on right 

   wd('<tr>'); 
   wd('<td valign=top ' + qs_debug_color() + 'colspan=2 rowspan=100>');
   qs_build_menu_table(qs_my_menu, qs_my_sub_menu); 
   wd('</td>'); 
   wd('<td rowspan=100 width=16px ' + qs_debug_color() + '>'+ 
		   '<img src=' + qs_trans_img + '></td>'); 
   // page content in its on table 
   wd('<td colspan=2>' + qs_table_start(0, qs_body_width, qs_debug_color())); 

   html();
}
   
// EXPOERTED
function qs_doc_headline(left)
{
   if (left != undefined) { 
      wd('<tr><td align=left>' + qs_font_color() + left + '</font></td></tr>'); 
   } 
   html(); 
}

// EXPORTED
function qs_body_start(with_underline)
{
  if (with_underline) { 
     qs_line(true); 
     wd('<tr><td height=8px>' + 
        qs_spacer_img(qs_body_width, 2, qs_trans_img) + 
        '</td></tr>'); 
  } 

  wd('<tr><td width=100%  valign=top>'); 
  wd(qs_indent(8)); 
  html();  // spit out HTML before  <SCRIPT> section is ended 
  // main page content lives in one table element 
}

// EXPORTED
function qs_doc_finish(date, spacing) 
{
   //wd('</td></tr>' + qs_table_finish()); // end of main page contents 
   wd(qs_unindent(8)); 
   wd('</td></tr>');
   if (spacing == undefined) {
      spacing = 36; 
   } 
   if (spacing < 0) {
      spacing = 36; 
   }
   wd(qs_row_spacer( spacing)); 
   qs_line(true); 

   wd('<TR><TD>'); 
      wd(qs_table_start(0, qs_body_width)); 
      wd('<tr><td align=left ' + qs_debug_color() + '>'); 
         qs_menu_across(); 
         wd('</td>'); 
         wd('<td align=right' + qs_debug_color() + '>'); 
         wd(qs_go_back_ref("Back")); 
         wd('</td>'); 
      wd('</tr>'); 
      if (date != undefined) { 
         wd(qs_row_spacer(4)); 
         wd('<tr' + qs_debug_color() + '>' + 
            '<td colspan=2 align=right>' + qs_font_color(-2) + 
                 ' Last Updated: ' +   date + 
                 '</font></td></tr>');
      }
      wd(qs_table_finish(0)); 
   wd('</TD></TR>'); 

   wd(qs_row_spacer( 8)); 
   wd(qs_table_finish()); 

   wd(qs_table_finish()); 

   wd('</body>');
//alert("open table=" + number_of_open_tables);
   html();
}

function qs_doc_setup(menu_loc, sub_menu_loc, dobg, dohead, tit) 
{
   if ((dohead != undefined) && (dohead != true)) {
      qs_do_head = false; 
   }
//   alert(menu_loc + '\n' + 
//        sub_menu_loc + '\n' +
//        'bg=' + dobg + '\n' + 
//        'head=' + dohead + '\n' +
//        'dohead=' + qs_do_head + '\n' +
//        'tit=' + tit);

   qs_init_vars(menu_loc, sub_menu_loc, tit); 
   window.status = qs_my_location; 

   if (tit != undefined) {
      tit = '&nbsp;&nbsp;  ' + tit ; 
   } else {
      tit = '';
   }
   qs_doc_title(qs_my_location + tit); 
   bgimg = ''; 
   if (dobg) { 
      bgimg = 'background=' + qs_background_img;
   } else {
      bgimg = 'bgcolor=' + qs_background_color; 
   }
   wd('<body ' + bgimg + 
      ' link=' + qs_link_color +
      ' alink=' + qs_link_hover +
      ' vlink=' + qs_link_visited +
      ' leftmargin=0 topmargin=0' +
   ' marginheight=0 marginwidth=0 >');
   // The Page is a table: with the following row layout
   // | 8 | 144       | 16 | 616=qs_body_width over 2 cols                
   //  the logo takes up col 1,2,3 over two rows 
   //  the color bar extends on the lower row next to the logo in col 4
   //  the menu takes up he first two columns
   // the document body is inside a table that takes up grid entry 4,4
   
   wd(qs_table_start(0, undefined, "width=" + qs_page_width)); 
   qs_doc_row(6, qs_page_color); 

   // shows current location
   wd('<tr bgcolor=' + qs_page_color + '>' );
      wd(qs_col_spacer(8, 1, 1) );  
      wd(qs_col_spacer(144, 1, 1) );
      wd(qs_col_spacer(16, 1, 1) );
      wd('<td width=' + qs_body_width + 'px align=right>' +
            qs_location_ref(qs_my_menu, qs_my_sub_menu, qs_background_color) + 
            qs_spacer_img(6, 1, qs_trans_img) + 
          '</td>');
   wd('</tr>');

   // page color row
   wd('<tr>' );
      wd(qs_col_spacer(1, 6, 4, 'bgcolor=' + qs_page_color) );  
   wd('</tr>');
   // background color row
   wd('<tr>' );
      wd(qs_col_spacer(1, 1, 4, 'bgcolor=' + qs_background_color) );  
   wd('</tr>');

   // page color row
   wd('<tr>' );
      wd(qs_col_spacer(1, 3, 4, 'bgcolor=' + qs_page_color) );  
   wd('</tr>');

   var header_img = qs_get_header_image(); 
   if (header_img != undefined) { 
      wd('<tr>' + 
         '<td colspan=4 bgcolor=red>' +
            qs_spacer_img(3, 1, qs_color_img) + 
            qs_spacer_img(qs_page_width - 6, 1, qs_background_img) + 
            qs_spacer_img(3, 1, qs_color_img) + 
         '<TD>' + 
      '</tr>');

      // the show applet image
      wd('<tr><td colspan=4 bgcolor=green>'); 
        wd(qs_table_start(0, undefined)); 
        wd('<tr bgcolor=' + qs_page_color + '>' + 
          qs_col_spacer(3, 1, 1) + 
          qs_col_spacer(1, 1, 1, 'bgcolor=' + qs_background_color) + 
	  '<td width=' + (qs_page_width - 8) + '>' + header_img + '</td>' + 
          qs_col_spacer(1, 1, 1, 'bgcolor=' + qs_background_color) + 
          qs_col_spacer(3, 1, 1) + 
         '</tr>'); 
        wd(qs_table_finish()); 
      wd('</td></tr>'); 

      wd('<tr>' + 
         '<td colspan=4 bgcolor=red>' +
            qs_spacer_img(3, 1, qs_color_img) + 
            qs_spacer_img(qs_page_width - 6, 1, qs_background_img) + 
            qs_spacer_img(3, 1, qs_color_img) + 
         '<TD>' + 
         '</tr>');
   }
   wd('<tr>' );
      wd(qs_col_spacer(1, 3, 4, 'bgcolor=' + qs_page_color) );  
   wd('</tr>');

   //wd(qs_row_spacer(8)); 
   wd(qs_table_finish()); 
}

function qs_doc_row(height, color) 
{
   // page color row and table setup 
   wd('<tr bgcolor=' + color + '>' );
      wd(qs_col_spacer(8, height, 1) );  
      wd(qs_col_spacer(144, height, 1) );
      wd(qs_col_spacer(16, height, 1) );
      wd(qs_col_spacer(qs_body_width, height, 1) );
   wd('</tr>'); 
} 


function qs_line(visible)
{
  img = qs_color_img;
  wd('<tr' + qs_debug_color() + '>' + 
     '<td height=16px><img width=' + qs_body_width + 'px height=2px src=' + img + '>' +
     '</td></tr>'); 
}


// -----------------------------------------------------------------------
// htm text gathering fcts 
// -----------------------------------------------------------------------
var html_text = ''; 

// EXPORTED
function wd(s)   { html_text += s + '\n'; }

// EXPORTED
function html_get()  { 
  s = html_text;
  html_text = '\n'; 
  return s; 
}

// EXPORTED
function alerthtml()  { 
  alert(html_text); 
  html(); 
}

// EXPOERTED
function html()  { 
  document.writeln(html_text);
  html_text = '\n'; 
}

// -----------------------------------------------------------------------
// debugging support
// -----------------------------------------------------------------------
function handle_error(msg, url) 
{
   file = new String(url); 
   if (file.length > 40) {
       file = "..." + file.substring(file.length-40); 
   } 
   alert(file + ": \n" + msg); 
}

window.onerror = handle_error; 

var debug_color_index = 0; 
var debug_color = new Array(); 
debug_color[0] = "red"; 
debug_color[1] = "green";
debug_color[2] = "blue"; 
debug_color[8] = "#777777"; 
debug_color[3] = "yellow"; 
debug_color[4] = "maroon"; 
debug_color[7] = "#555555"; 
debug_color[5] = "purple"; 
debug_color[6] = "orange"; 
debug_color[9] = "pink"; 

function qs_debug_color() 
{
   return ' ';
   // do return s when you want to debug 
   debug_color_index  = debug_color_index + 1;
   if (debug_color_index > 9) debug_color_index = 0; 
   s =  ' bgcolor=' + debug_color[debug_color_index] + ' '; 
   return s;
} 
// =======================================================================
// end of general purpose code
// =======================================================================

// =======================================================================
// SPECIFICS FOR TSP HOMEPAGE 
// --------------------------------------------------------------------------

// pages style sheet
// 
function css_link() {
   return('\n<STYLE type="text/css">\n' + 
	'<!--\n' + 
  	'A { text-decoration: none }\n' + 
          'A:hover { color: ' + qs_link_hover + '; text-decoration: underline }\n' + 
          'A {font-family: Arial, Helvetica, Sans-serif; font-size: 12px;}\n' + 
          'body, P, td, ul, li  { font-family: Arial, Helvetica, Sans-serif; font-size: 12px; color: black}\n' + 
  	'\n' + 
  	'.navMenu { font-family: Arial, Helvetica, Sans-serif; font-size: 12px; font-weight: bold; color=white' + 
                     'text-decoration: none; }\n' + 
  	'\n' + 
          '.postcardLink { color: white; \n' +
          '	font-family: Arial, Helvetica, Sans-serif; \n' +
          '	font-size: 12px; font-weight: bold; }\n' +
  	'\n' +
          'a.postcardLink {text-decoration: none; }\n' +
          'a.postcardLink:link { color: white; }\n' +
          'a.postcardLink:visited { color: white; }\n' +
          'a.postcardLink:hover { color: white; text-decoration: underline; }\n' +
  	'\n-->\n' + 
  	'</STYLE>\n');  
}
  
//----------------------------------------------------------------------------
// applets and mcm lesson building fcts 
//----------------------------------------------------------------------------

var qs_applet_id = 0; 
var qs_applet_color = qs_background_color;
var qs_applet_frame_color = qs_page_color;
var qs_code_padding = 12;
var qs_jar_path = "."; 

function java_src_ref(javaSrc, refText) 
{

   if (javaSrc == undefined) 
      return "&nbsp;"; 
   var file = javaSrc;
   file = file.replace(/\./g, "/"); 
   file = file.replace(/\/java/g, ".java"); 
   cur_loc = qs_location(qs_my_menu, qs_my_sub_menu); 
   if (refText == undefined) {
      refText = "JavaSource"; 
   }
   return qs_ref(refText, file, file);
}

function qs_applet_restart(applet_name)
{
   if (applet_name == undefined) return "&nbsp;"; 
   return (qs_ref("Restart", 
      "JavaScript:document." + applet_name + ".stop();"  +
      //"JavaScript:document." + applet_name + ".init();" +
      "JavaScript:document." + applet_name + ".start();", 
      "Restart Applet")); 
}

// make a 2 element table row if 
//          at least one of javaSr or applet_name is undefined 
function qs_tr_src_restart(javaSrc, applet_name) 
{
   if ((javaSrc == undefined) && (applet_name == undefined)) 
      return "" 
   return qs_tr(qs_td(java_src_ref(javaSrc), "align=left") + 
                qs_td(qs_applet_restart(applet_name), "align=right"));
}

// applet framed by a colored table 
// return name 
// write html with wd fct
// height refers to tabel height
// returns objcte with html and name property
function qs_applet(cls, archive, width, height, params, framecolor, wincolor)
{
   var applet = new Object(); 
   if (wincolor == undefined) 
      wincolor =  qs_applet_color;
   if (framecolor == undefined) 
      framecolor =  qs_applet_frame_color;
   if (params == undefined) 
      params = '';
   applet.name = 'applet_' + qs_applet_id; 
   qs_applet_id++;

var applet = new Applet(applet_name, 
                        "mcm.theater.Play.class", 
                         "./krtek.jar", 
                         qs_mcmTheater_jar + ", "  + qs_jar_path + "/" + archive + ".jar", 
                         width - 6, height - 6);
applet.addParam("ACTOR", cls); 
applet.addParam("TRACENAMES", "true"); 
applet.addParam("BGCOLOR", wincolor); 
// params

   s = qs_colored_table_start(3, framecolor, width); 
   s += '<TR><TD>';
   s += '<APPLET name=' + applet.name + ' hspace=0 vspace=0 ';
   s += '        CODE=mcm.theater.Play.class ARCHIVE="' + 
	   qs_mcmTheater_jar + ", "  + 
           qs_jar_path + "/" + archive + ".jar" + '"\n' ;
   s += '        WIDTH=' + (width - 6) + ' HEIGHT=' + (height - 6) +  '\n';  
   s += '        ALT="If you could run this applet, ' + 
                  'you would see some animation">\n'; 
   s += '        <PARAM NAME=ACTOR VALUE="' + cls + '">' + '\n';  
   s += '        <PARAM NAME=TRACENAMES VALUE="true">' + '\n';
   s += '        <PARAM NAME=BG VALUE="' + wincolor + '">' +  '\n';  
   s += '        ' + params +  '\n';  
   s += '        Your browser is completely ignoring the &lt;APPLET&gt; tag!\n'; 
   s += '</APPLET>\n';  
   s += '</TD></TR>\n';  
   s += qs_table_finish(); 
   applet.html = s;
   return applet;
}


// write formmated code 
function qs_code(code, padding, width, height, framecolor) {
    wd(qs_code_html(code, padding, width, height, framecolor)); 
}

// return code formatted inside a framecolor table 
// height refers to height of outside table
function qs_code_html(code, padding, width, height, framecolor) {
   if (framecolor == undefined) 
      framecolor =  qs_applet_frame_color;
   if (padding == undefined) {
      padding = qs_code_padding; 
   }
   s = qs_framed_table_start(1, framecolor, qs_code_color, width, height) +
       qs_tr(
          qs_col_spacer(padding, 1) +
          qs_td('<pre>' + code + '</pre>', 'valign=top') +  
          qs_col_spacer(padding, 1)) + 
       qs_framed_table_finish();
   return s;
}


function qs_applet_src(applet, javaSrc, archive, 
                              width, height, params,
                              restart, framecolor, wincolor)
{
      applet = qs_applet(applet, archive, width, height, params, 
                         framecolor, wincolor); 
      if (restart != undefined) 
         restart = applet.name;
      applet.html =
             qs_table_start(0) + 
             qs_tr(qs_td(applet.html, "colspan=2")) + 
             qs_tr_src_restart(javaSrc,restart) + 
             qs_table_finish();
      return  applet;
}

function qs_applet_vert_code(applet, javaSrc, archive,  
                             width, height, params, code, 
                             restart, framecolor, wincolor)
{
   var applet = qs_applet_src(applet, javaSrc, archive, 
                              width, height, params, 
                              restart, framecolor, wincolor);
   applet_code = qs_code_html(code, undefined, width);

   return qs_vert_table(
      applet.html, //top
      applet_code, //bottom
      1);
}

function qs_img_horz_code(cls, javaSrc, img, 
                           total_width, img_width, height, code, 
                           restart, framecolor)
{
   var width; 
   if (total_width != undefined)  { 
         width = total_width -img_width - qs_spacer_dist; 
         if (width < 0) width = undefined; 
   }
   if (framecolor== undefined) {
      framecolor = qs_page_color;
   }
   var imgHtml = qs_colored_table_start(3, framecolor, img_width) +
                 qs_tr(qs_td("<img src=" + img + 
                             " alt='Image of " + cls + " execution'" + 
	                     " border=0px >")) +  
                 qs_table_finish();
   
   var html = qs_table_start(0) + 
                  qs_tr(qs_td(imgHtml)) + 
                  qs_tr(qs_td(java_src_ref(javaSrc))) + 
              qs_table_finish(); 

   applet_code = qs_code_html(code, undefined, width, height);

   return qs_horz_table(html, //top
                         applet_code, //bottom
                         qs_spacer_dist);
}

function qs_applet_horz_code(applet, javaSrc, archive, 
                           total_width, applet_width, height, params, code, 
                           restart, framecolor, wincolor)
{
   var width; 
   if (total_width != undefined)  { 
         width = total_width -applet_width - qs_spacer_dist; 
         if (width < 0) width = undefined; 
   }
   var applet = qs_applet_src(applet, javaSrc, archive, 
                              applet_width, height, params,
                              restart, framecolor, wincolor);
   applet_code = qs_code_html(code, undefined, width, height);

   return qs_horz_table(applet.html, //top
                         applet_code, //bottom
                         qs_spacer_dist);
}

function qs_applet_info() 
{
return "Each actor's statements are shown next to the " +
 "applet executing it. Click on the " + 
 "<font color=" + qs_link_color + ">Restart" + "</font> link under applets " +
 "to see them execute all over again. The links labeled " + 
 "<font color=" + qs_link_color + ">JavaSource</font> show the complete " +
 "Java source code file for the actors executing in this page's applets. "; 
}

// --------------------------------------------------------------------------
// applet made easier
// --------------------------------------------------------------------------
var applet_width = qs_body_width; 
var applet_height = 380; 
var applet_frame_color = qs_page_color; 
var applet_color = "#ffffff";

function applet_plain(pkg, cls, params, withSrcRef, restart) 
{
   var archive = pkg; 
   var applet  = pkg + "." + cls ;
   var javaSrc; 
   if (withSrcRef) {
      javaSrc = pkg + "/" + cls  + ".java";
   }
   wd(qs_applet_src(applet, javaSrc, archive, 
                        applet_width, applet_height, 
                        params, 
                        restart,
			applet_frame_color, applet_color).html);
}

function applet_with_code(pkg, cls, params, code, vert, noRestart) 
{
   var archive = pkg; 
   var javaSrc  = pkg + "/" + cls  + ".java";
   var applet  = pkg + "." + cls ;
   if (noRestart != undefined) 
       restart = undefined; 
   else 
       restart = "Restart";

   if (vert == undefined) 
      var applet = qs_applet_horz_code(
                        applet, javaSrc, archive, 
                        qs_body_width, applet_width, applet_height, 
                        params, code, restart,
			applet_frame_color, applet_color);
   else 
      var applet = qs_applet_vert_code(
                        applet, javaSrc, archive, 
                        applet_width, applet_height, 
                        params, code, restart,
			applet_frame_color, applet_color);

   wd(applet); 
}

   
function applet_code(code, width, height) {
   wd(qs_code_html(code, undefined, width, height)); 
}

function applet_replace(c1, word, c2, align)
{
   if (align == undefined) 
      align = ""; 
   wd(qs_table_start(0)); 
   wd("<TR><TD>"); 
   wd(qs_code_html(c1));
   wd("</TD>" + qs_col_spacer(4, 1) + "<TD " + align + ">"); 
   wd(word);
   wd("</TD>" + qs_col_spacer(4, 1) + "<TD>"); 
   wd(qs_code_html(c2));
   wd("</TD></TR>"); 
   wd(qs_table_finish()); 
}


function qs_determine_browser() {
   wd('<SCRIPT LANGUAGE="JavaScript"><!--'); 
       wd('var _info = navigator.userAgent; '); 
       wd('var _ns = false;'); 
       wd('var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0'); 
              wd('&& _info.indexOf("Windows 3.1") < 0);'); 
   wd('//--><\/SCRIPT>'); 
   wd('<COMMENT><SCRIPT LANGUAGE="JavaScript1.1"><!--'); 
       wd('var _ns = (navigator.appName.indexOf("Netscape") >= 0'); 
        wd('&& ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0'); 
        wd('&& java.lang.System.getProperty("os.version").indexOf("3.5") < 0)'); 
        wd('|| _info.indexOf("Sun") > 0));'); 
   wd('//--><\/SCRIPT></COMMENT>'); 
   wd('<SCRIPT LANGUAGE="JavaScript">'); 
   // wd('if (_ie != undefined) { alert("IE=" + _ie); }'); 
   // wd('if (_ns != undefined) { alert("NETSCAPE=" + _ns); }'); 
   wd('<\/SCRIPT>'); 
   html(); 
}
// --------------------------------------------------------------------------
// Applet tgeneration
// --------------------------------------------------------------------------
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

// --------------------------------------------------------------------------
// home page specific fcts 
// --------------------------------------------------------------------------

wd(css_link());
wd('<body bgcolor=white' + 
' link=' + qs_link_color +
' alink=' + qs_link_hover +
' vlink=' + qs_link_visited +
' leftmargin=0 topmargin=0' +
' marginheight=0 marginwidth=0 >');

html();
//alert("index.js loaded "); 
