var qs_anim_id = 0; 

function anim_src(pkg, cls, imgWidth, framecolor, withSrcRef) 
{
   var anim = new Object(); 
   anim.img = 'img/' + pkg + '/' + cls; 
   anim.name = 'anim_' + qs_anim_id;
   qs_anim_id++;

   var s = qs_colored_table_start(3, framecolor, imgWidth) +
               qs_tr(qs_td("<img src=" + anim.img + "0.png" + 
                             " name=" + anim.name + 
                             " alt='Image of " + cls + " execution'" + 
	                     " border=0px  >")) +  
               qs_table_finish(); 

   anim.html = s;

   return anim;
}

function do_anim(name, img, frame, nImg, delay, extraDelay) 
{
    document[name].src = 'img/' + img + frame + '.png'; 
    frame = (frame + 1) % nImg;
    if (delay == undefined) {
        delay = 100;
    } 
    if (extraDelay == undefined) {
        extraDelay = 0; 
    }
    if (frame == (nImg -1)) {
        del = delay + extraDelay; 
    } else {
        del = delay; 
    }
    timeout_id = setTimeout("do_anim('" + name + "'," + 
                             "'" +  img + "' ," +
                             frame + ","
                             + nImg + "," 
                             + delay + ", " 
                             + extraDelay + ")", del); 
} 

