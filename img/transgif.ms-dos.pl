#!/usr/local/bin/perl -w
## Make a gif "transparent"
##
## Jeffrey Friedl
## jfriedl@omrongw.wg.omron.co.jp
## 15 July 1994
## 2 Aug 1994 - added ability to select transparent color by RGB values.
## 940825.3 -- modified to work with possible future versions of the
##             GIF standard... just in case.
##
#$version = "940825.3";
##
## BLURB:
## Transforms a "normal" gif into a "transparent background" gif.
##
##>
##
## I wrote this because people ask for something like this all the time.
## I just learned the format of GIFs a week ago, so this will likely be
## lacking in many respects.
##
##
## Usage:
##      transgif [options] regular.gif > transparent.gif
##   or
##      cat regular.gif | transgif [options] transparent.gif
##
## The default is that whatever color happens to fall into the first colormap
## slot (often black) will be made transparent. This can be changed via the
## the options.
##
## The options are from:
##   -p              print the colormap (to STDERR).
##		     The new gif still goes to STDOUT.
##
##   -###            make colormap index-### transparent (default is -0)
##
##   -rgb ## ## ##   Take the three numbers as R G B values (in the range
##		     of 0..255 (or 0x00..0xff). The first colormap entry
##		     with those RGB values is made transparent.
##
##   -rgb name       Use the R G B values of the color 'name' if known
##		     by this program (data from X11's rgb.txt)
##
## COLORNUM is the index of the color entry to make transparent, and 
## defaults to zero. For those that like the looks of it, you can put
## a leading '-'.
##
##<

sub usage {
   die "@_\nUsage: $0 [-p] [-## | -rgb name | -rgb ## ## ##] [file]\n";
}

$trans_index = 0;
$print_color_map = 0;
$select_via_rgb = 0;

while (@ARGV && $ARGV[0] =~ m/^-/) {
    $arg = shift;
    if ($arg eq '-p') { 	     ## print color map
	$print_color_map = 1;

    } elsif ($arg =~ m/^-(\d+)$/) {  ## set color map index number
	$trans_index = $1;

    } elsif ($arg eq '-rgb') {	     ## set what color to make transparent

	## if next three args look numerical (## or 0x##), use as R B G.
	if (@ARGV >= 3 &&
	    $ARGV[0] =~ m/^(0x[\da-f]+|\d+)$/i &&
	    $ARGV[1] =~ m/^(0x[\da-f]+|\d+)$/i &&
	    $ARGV[2] =~ m/^(0x[\da-f]+|\d+)$/i)
	{
	    ($R, $G, $B) = splice(@ARGV, 0, 3);
	    $select_via_rgb = 1;
	    $R = eval($R); ## eval these to process any hex or octal values.
	    $G = eval($G); ## eval these to process any hex or octal values.
	    $B = eval($B); ## eval these to process any hex or octal values.

	## if next arg looks like a color name, use those R G B values.
	} elsif (@ARGV && (@RGB = &name2rgb($ARGV[0]), @RGB == 3)) {
	    shift; ## eat name;
	    ($R, $G, $B) = @RGB;
	    $select_via_rgb = 1;

	} else {
	   warn(qq/(don't understand "$ARGV[0]" as a color name)\n/) if @ARGV;
	   die qq/$0: expected color name or a numerical triplet for $arg\n/;
	}
    } else {
	&usage(qq/unknown arg "$arg".\n/);
    }
}

&usage('too many args.') if @ARGV > 1;

if (@ARGV == 0) {
    &giftrans(*STDIN, *STDOUT, $trans_index);
} else {
    binmode( INPUT );
    binmode( STDOUT );
    open(INPUT,  $file =shift) || die "$0: couldn't open [$file] for input\n";
    &giftrans(*INPUT, *STDOUT, $trans_index);
    close(INPUT);
}
exit(0);



##
## Given indirect references to two filehandles, pass the file from
## one to the other, changing nothing unless it's a GIF that we know
## how to deal with, and if so do so.
##
## This is written rather verbosely for the sake of clarity... speed not
## much of an issue for something like this, and the difference is minimal
## anyway.
##
sub giftrans
{
    local(*IN, *OUT, $trans_index) = @_;
    $trans_index = 0 if !defined $trans_index;
    local($header, $color_table, $nextblock, $buffer) = ('') x 4;

    ## The header looks like:
    ##   byte 0 - 5:  "GIF89a" or "GIF87a"
    ##   byte 6, 7:   width  (low order first)
    ##   byte 8, 9:   height (low order first)
    ##   byte 10:     various flags
    ##   byte 11:     background color index
    ##   byte 12:     aspect ratio
    sysread(IN, $header, 13) || die "sysread header: $!";
    substr($header, 0, 6) = 'GIF89a' if substr($header,0,6) eq 'GIF87a';
    print OUT $header;

    if (substr($header, 0, 3) ne 'GIF') {
	print STDERR "don't know input filetype, passing unchanged\n";
    } else {
	##
	## Look at flags (8 bits): hi[MCCCSPPP]low
	##   M   = global colormap present?
	##   CCC = bits/color/colormapentry - 1
	##   S   = color map sorted by importance?
	##   PPP = bits/pixel - 1
	## therefore
	##   Bits/pixel = PPP+1
	##   Number of possible colors (entries in colormap): 2 ** (PPP+1)
	##                                                  : 1 << (PPP+1)
	##   Size (bytes) of colormap: 3 * Number of possible colors
	##                           : 3 * (1 << (PPP+1))
	##
	local($flags) = ord(substr($header, 10, 1));
	local($has_global_colormap) = $flags & 0x80;

	## Copy over the colormap if need be.
	if (!$has_global_colormap)
	{
	   die "$0: picture has no colormap, so -rgb arg invalid\n"
		if $select_via_rgb;
	   die "$0: no colormap, so any index except 0 or 1 makes no sense\n"
		if $trans_index > 1;
	} else {
	    local($bits_per_pixel) = 1 + ($flags & 0x07);
	    local($colormap_entries) = 1 << $bits_per_pixel;
	    local($color_tbl_size) = 3 * $colormap_entries;

	    sysread(IN, $color_table, $color_tbl_size) || die "sysread color";
	    print OUT $color_table;

	    if ($print_color_map || $select_via_rgb)
	    {
		## For each byte of each colormap's RGB triplit, we'll have
		## to mask off bits that aren't used when looking at the
		## color values.
		local($bits_color_byte) = 1 + (($flags >> 4) & 0x07);
		local($rgb_byte_mask) = (1 << $bits_color_byte) - 1;
		local($r,$g,$b);

		local($best_delta) = 1000; ## any big number ok
		local(@delta, @r, @b, @g);

		for ($i = 0; $i < $colormap_entries; $i++)
		{
		   ($r, $g, $b) = unpack("CCC", substr($color_table, $i*3, 3));
		   $r &= $rgb_byte_mask;
		   $g &= $rgb_byte_mask;
		   $b &= $rgb_byte_mask;

		   if ($select_via_rgb) {
			if ($r == $R && $g == $G && $b == $B) {
			    $select_via_rgb = 0;
			    $trans_index = $i;
			    print(STDERR "Found exact match (index #$i).\n");
			} else {
			    $delta = ($r < $R ? $R - $r : $r - $R) +
				     ($g < $G ? $G - $g : $g - $G) +
				     ($b < $B ? $B - $b : $b - $B);
			    if ($delta < $best_delta) {
				@delta = ($i);
				@r = $r; @g = $g; @b = $b;
				$best_delta = $delta;
			    } elsif ($delta == $best_delta) {
				push(@delta, $i);
				push(@r, $r); push(@g, $g); push(@b, $b);
			    }
			}
		   }

		   printf(STDERR "%03d: %3d %3d %3d (x%02x x%02x x%02x)\n", $i,
			$r, $g, $b, $r, $g, $b) if $print_color_map;
		}

		if ($select_via_rgb) {
		    ## Mmm, didn't find it. Use one of the close ones.
		    #MONIKA $trans_index = shift(delta);
		    $trans_index = shift(@delta);
		    $r = shift(@r);
		    $g = shift(@g);
		    $b = shift(@b);

		    printf(STDERR "requested color not found, using index ".
				  "#%d: %3d %3d %3d (x%02x x%02x x%02x)\n",
				  $trans_index,
				   $r, $g, $b, $r, $g, $b);
		    if (@delta)
		    {
			$count = @delta;
			print(STDERR
			    "note: %d other entrie%s seem equally close:\n",
				$count, $count == 1 ? "" : "s");
			while (@delta) {
			    $index = shift(@delta);
			    $r = shift(@r);
			    $g = shift(@g);
			    $b = shift(@b);
		   	    printf(STDERR "  index %03d: %3d %3d %3d ".
					  "(x%02x x%02x x%02x)\n",
					  $index, $r, $g, $b, $r, $g, $b);
			}
		    }
		}
	    }
	}

	##
	## The next 8 bytes will either be an already-there graphic-extension
	## block, or something else that we'll not care about. In the latter
	## case, we'll add a graphic-extension block saying "color such-and-
	## such is transparent". If there's already one there, we'll just
	## ensure that it says that.
	##
	sysread(IN, $nextblock, 8) || die "sysread nextblock";
	local($extension, $label) = unpack('CC', $nextblock);
	## If extension is 0x21 and label is 0xf9, that's the magic tha means
	## there's already a graphic extension there.
	if ($extension == 0x21 && $label == 0xf9) {
	    substr($nextblock, 3, 1) = pack('C', 1|substr($nextblock, 3, 1));
	    substr($nextblock, 6, 1) = pack('C', $trans_index);
	} else {
	    print OUT pack('CCC CCCC C',
		0x21,  ## magic: "Extension Introducer"
		0xf9,  ## magic: "Graphic Control Label"
		   4,  ## bytes in block (between here and terminator)
		0x01,  ## indicates that 'transparet index' is given
		0, 0,  ## delay time.
                $trans_index, ## index number of colormap entry
		0x00); ## terminator.
	}
	print OUT $nextblock;
    }

    ## Now just pass the rest of the file over unchanged.

    print OUT $buffer while sysread(IN, $buffer, 4096);
    close(IN);
    close(OUT);
}

##
## Change a name to a triplet of RGB values.
## name and RGB data taken from the X11 lib/rgb.txt, with the
## name regexe-compressed by me.
##
sub name2rgb
{
    local($_) = @_;  ## name;
    study;
    %rgb = (
	'  0,  0,  0', 'black|gr[ae]y0',
	'  0,  0,128', 'navy([ \-]?blue)?',
	'  0,  0,139', 'blue4',
	'  0,  0,205', 'blue3|medium[ \-]?blue',
	'  0,  0,238', 'blue2',
	'  0,  0,255', 'blue1?',
	'  0,100,  0', 'dark[ \-]?green',
	'  0,104,139', 'deepskyblue4',
	'  0,134,139', 'turquoise4',
	'  0,139,  0', 'green4',
	'  0,139, 69', 'springgreen4',
	'  0,139,139', 'cyan4',
	'  0,154,205', 'deepskyblue3',
	'  0,178,238', 'deepskyblue2',
	'  0,191,255', 'deep( sky blue|-sky-blue|skyblue1?)',
	'  0,197,205', 'turquoise3',
	'  0,205,  0', 'green3',
	'  0,205,102', 'springgreen3',
	'  0,205,205', 'cyan3',
	'  0,206,209', 'dark[ \-]?turquoise',
	'  0,229,238', 'turquoise2',
	'  0,238,  0', 'green2',
	'  0,238,118', 'springgreen2',
	'  0,238,238', 'cyan2',
	'  0,245,255', 'turquoise1',
	'  0,250,154', 'medium[ \-]?spring[ \-]?green',
	'  0,255,  0', 'green1?',
	'  0,255,127', 'spring[ \-]?green1?',
	'  0,255,255', 'cyan1?',
	'  3,  3,  3', 'gr[ae]y1',
	'  5,  5,  5', 'gr[ae]y2',
	'  8,  8,  8', 'gr[ae]y3',
	' 10, 10, 10', 'gr[ae]y4',
	' 13, 13, 13', 'gr[ae]y5',
	' 15, 15, 15', 'gr[ae]y6',
	' 16, 78,139', 'dodgerblue4',
	' 18, 18, 18', 'gr[ae]y7',
	' 20, 20, 20', 'gr[ae]y8',
	' 23, 23, 23', 'gr[ae]y9',
	' 24,116,205', 'dodgerblue3',
	' 25, 25,112', 'midnight[ \-]?blue',
	' 26, 26, 26', 'gr[ae]y10',
	' 28, 28, 28', 'gr[ae]y11',
	' 28,134,238', 'dodgerblue2',
	' 30,144,255', 'dodger[ \-]?blue1?',
	' 31, 31, 31', 'gr[ae]y12',
	' 32,178,170', 'light[ \-]?sea[ \-]?green',
	' 33, 33, 33', 'gr[ae]y13',
	' 34,139, 34', 'forest[ \-]?green',
	' 36, 36, 36', 'gr[ae]y14',
	' 38, 38, 38', 'gr[ae]y15',
	' 39, 64,139', 'royalblue4',
	' 41, 41, 41', 'gr[ae]y16',
	' 43, 43, 43', 'gr[ae]y17',
	' 46, 46, 46', 'gr[ae]y18',
	' 46,139, 87', 'sea[ \-]?green4?',
	' 47, 79, 79', 'dark( slate gr[ae]|-slate-gr[ae]|slategr[ae])y',
	' 48, 48, 48', 'gr[ae]y19',
	' 50,205, 50', 'lime[ \-]?green',
	' 51, 51, 51', 'gr[ae]y20',
	' 54, 54, 54', 'gr[ae]y21',
	' 54,100,139', 'steelblue4',
	' 56, 56, 56', 'gr[ae]y22',
	' 58, 95,205', 'royalblue3',
	' 59, 59, 59', 'gr[ae]y23',
	' 60,179,113', 'medium[ \-]?sea[ \-]?green',
	' 61, 61, 61', 'gr[ae]y24',
	' 64, 64, 64', 'gr[ae]y25',
	' 64,224,208', 'turquoise',
	' 65,105,225', 'royal[ \-]?blue',
	' 66, 66, 66', 'gr[ae]y26',
	' 67,110,238', 'royalblue2',
	' 67,205,128', 'seagreen3',
	' 69, 69, 69', 'gr[ae]y27',
	' 69,139,  0', 'chartreuse4',
	' 69,139,116', 'aquamarine4',
	' 70,130,180', 'steel[ \-]?blue',
	' 71, 60,139', 'slateblue4',
	' 71, 71, 71', 'gr[ae]y28',
	' 72, 61,139', 'dark[ \-]?slate[ \-]?blue',
	' 72,118,255', 'royalblue1',
	' 72,209,204', 'medium[ \-]?turquoise',
	' 74, 74, 74', 'gr[ae]y29',
	' 74,112,139', 'skyblue4',
	' 77, 77, 77', 'gr[ae]y30',
	' 78,238,148', 'seagreen2',
	' 79, 79, 79', 'gr[ae]y31',
	' 79,148,205', 'steelblue3',
	' 82, 82, 82', 'gr[ae]y32',
	' 82,139,139', 'darkslategray4',
	' 83,134,139', 'cadetblue4',
	' 84, 84, 84', 'gr[ae]y33',
	' 84,139, 84', 'palegreen4',
	' 84,255,159', 'seagreen1',
	' 85, 26,139', 'purple4',
	' 85,107, 47', 'dark[ \-]?olive[ \-]?green',
	' 87, 87, 87', 'gr[ae]y34',
	' 89, 89, 89', 'gr[ae]y35',
	' 92, 92, 92', 'gr[ae]y36',
	' 92,172,238', 'steelblue2',
	' 93, 71,139', 'mediumpurple4',
	' 94, 94, 94', 'gr[ae]y37',
	' 95,158,160', 'cadet[ \-]?blue',
	' 96,123,139', 'lightskyblue4',
	' 97, 97, 97', 'gr[ae]y38',
	' 99, 99, 99', 'gr[ae]y39',
	' 99,184,255', 'steelblue1',
	'100,149,237', 'cornflower[ \-]?blue',
	'102,102,102', 'gr[ae]y40',
	'102,139,139', 'paleturquoise4',
	'102,205,  0', 'chartreuse3',
	'102,205,170', 'aquamarine3|medium[ \-]?aquamarine',
	'104, 34,139', 'darkorchid4',
	'104,131,139', 'lightblue4',
	'105, 89,205', 'slateblue3',
	'105,105,105', 'dim( gr[ae]|-gr[ae]|gr[ae])y|gr[ae]y41',
	'105,139, 34', 'olivedrab4',
	'105,139,105', 'darkseagreen4',
	'106, 90,205', 'slate[ \-]?blue',
	'107,107,107', 'gr[ae]y42',
	'107,142, 35', 'olive[ \-]?drab',
	'108,123,139', 'slategray4',
	'108,166,205', 'skyblue3',
	'110,110,110', 'gr[ae]y43',
	'110,123,139', 'lightsteelblue4',
	'110,139, 61', 'darkolivegreen4',
	'112,112,112', 'gr[ae]y44',
	'112,128,144', 'slate( gr[ae]|-gr[ae]|gr[ae])y',
	'115,115,115', 'gr[ae]y45',
	'117,117,117', 'gr[ae]y46',
	'118,238,  0', 'chartreuse2',
	'118,238,198', 'aquamarine2',
	'119,136,153', 'light( slate gr[ae]|-slate-gr[ae]|slategr[ae])y',
	'120,120,120', 'gr[ae]y47',
	'121,205,205', 'darkslategray3',
	'122, 55,139', 'mediumorchid4',
	'122,103,238', 'slateblue2',
	'122,122,122', 'gr[ae]y48',
	'122,139,139', 'lightcyan4',
	'122,197,205', 'cadetblue3',
	'123,104,238', 'medium[ \-]?slate[ \-]?blue',
	'124,205,124', 'palegreen3',
	'124,252,  0', 'lawn[ \-]?green',
	'125, 38,205', 'purple3',
	'125,125,125', 'gr[ae]y49',
	'126,192,238', 'skyblue2',
	'127,127,127', 'gr[ae]y50',
	'127,255,  0', 'chartreuse1?',
	'127,255,212', 'aquamarine1?',
	'130,130,130', 'gr[ae]y51',
	'131,111,255', 'slateblue1',
	'131,139,131', 'honeydew4',
	'131,139,139', 'azure4',
	'132,112,255', 'light[ \-]?slate[ \-]?blue',
	'133,133,133', 'gr[ae]y52',
	'135,135,135', 'gr[ae]y53',
	'135,206,235', 'sky[ \-]?blue',
	'135,206,250', 'light[ \-]?sky[ \-]?blue',
	'135,206,255', 'skyblue1',
	'137,104,205', 'mediumpurple3',
	'138, 43,226', 'blue[ \-]?violet',
	'138,138,138', 'gr[ae]y54',
	'139,  0,  0', 'red4',
	'139,  0,139', 'magenta4',
	'139, 10, 80', 'deeppink4',
	'139, 26, 26', 'firebrick4',
	'139, 28, 98', 'maroon4',
	'139, 34, 82', 'violetred4',
	'139, 35, 35', 'brown4',
	'139, 37,  0', 'orangered4',
	'139, 54, 38', 'tomato4',
	'139, 58, 58', 'indianred4',
	'139, 58, 98', 'hotpink4',
	'139, 62, 47', 'coral4',
	'139, 69,  0', 'darkorange4',
	'139, 69, 19', 'chocolate4|saddle[ \-]?brown',
	'139, 71, 38', 'sienna4',
	'139, 71, 93', 'palevioletred4',
	'139, 71,137', 'orchid4',
	'139, 76, 57', 'salmon4',
	'139, 87, 66', 'lightsalmon4',
	'139, 90,  0', 'orange4',
	'139, 90, 43', 'tan4',
	'139, 95,101', 'lightpink4',
	'139, 99,108', 'pink4',
	'139,101,  8', 'darkgoldenrod4',
	'139,102,139', 'plum4',
	'139,105, 20', 'goldenrod4',
	'139,105,105', 'rosybrown4',
	'139,115, 85', 'burlywood4',
	'139,117,  0', 'gold4',
	'139,119,101', 'peachpuff4',
	'139,121, 94', 'navajowhite4',
	'139,123,139', 'thistle4',
	'139,125,107', 'bisque4',
	'139,125,123', 'mistyrose4',
	'139,126,102', 'wheat4',
	'139,129, 76', 'lightgoldenrod4',
	'139,131,120', 'antiquewhite4',
	'139,131,134', 'lavenderblush4',
	'139,134, 78', 'khaki4',
	'139,134,130', 'seashell4',
	'139,136,120', 'cornsilk4',
	'139,137,112', 'lemonchiffon4',
	'139,137,137', 'snow4',
	'139,139,  0', 'yellow4',
	'139,139,122', 'lightyellow4',
	'139,139,131', 'ivory4',
	'140,140,140', 'gr[ae]y55',
	'141,182,205', 'lightskyblue3',
	'141,238,238', 'darkslategray2',
	'142,229,238', 'cadetblue2',
	'143,143,143', 'gr[ae]y56',
	'143,188,143', 'dark[ \-]?sea[ \-]?green',
	'144,238,144', 'palegreen2',
	'145, 44,238', 'purple2',
	'145,145,145', 'gr[ae]y57',
	'147,112,219', 'medium[ \-]?purple',
	'148,  0,211', 'dark[ \-]?violet',
	'148,148,148', 'gr[ae]y58',
	'150,150,150', 'gr[ae]y59',
	'150,205,205', 'paleturquoise3',
	'151,255,255', 'darkslategray1',
	'152,245,255', 'cadetblue1',
	'152,251,152', 'pale[ \-]?green',
	'153, 50,204', 'dark[ \-]?orchid',
	'153,153,153', 'gr[ae]y60',
	'154, 50,205', 'darkorchid3',
	'154,192,205', 'lightblue3',
	'154,205, 50', 'olivedrab3|yellow[ \-]?green',
	'154,255,154', 'palegreen1',
	'155, 48,255', 'purple1',
	'155,205,155', 'darkseagreen3',
	'156,156,156', 'gr[ae]y61',
	'158,158,158', 'gr[ae]y62',
	'159,121,238', 'mediumpurple2',
	'159,182,205', 'slategray3',
	'160, 32,240', 'purple',
	'160, 82, 45', 'sienna',
	'161,161,161', 'gr[ae]y63',
	'162,181,205', 'lightsteelblue3',
	'162,205, 90', 'darkolivegreen3',
	'163,163,163', 'gr[ae]y64',
	'164,211,238', 'lightskyblue2',
	'165, 42, 42', 'brown',
	'166,166,166', 'gr[ae]y65',
	'168,168,168', 'gr[ae]y66',
	'171,130,255', 'mediumpurple1',
	'171,171,171', 'gr[ae]y67',
	'173,173,173', 'gr[ae]y68',
	'173,216,230', 'light[ \-]?blue',
	'173,255, 47', 'green[ \-]?yellow',
	'174,238,238', 'paleturquoise2',
	'175,238,238', 'pale[ \-]?turquoise',
	'176, 48, 96', 'maroon',
	'176,176,176', 'gr[ae]y69',
	'176,196,222', 'light[ \-]?steel[ \-]?blue',
	'176,224,230', 'powder[ \-]?blue',
	'176,226,255', 'lightskyblue1',
	'178, 34, 34', 'firebrick',
	'178, 58,238', 'darkorchid2',
	'178,223,238', 'lightblue2',
	'179,179,179', 'gr[ae]y70',
	'179,238, 58', 'olivedrab2',
	'180, 82,205', 'mediumorchid3',
	'180,205,205', 'lightcyan3',
	'180,238,180', 'darkseagreen2',
	'181,181,181', 'gr[ae]y71',
	'184,134, 11', 'dark[ \-]?goldenrod',
	'184,184,184', 'gr[ae]y72',
	'185,211,238', 'slategray2',
	'186, 85,211', 'medium[ \-]?orchid',
	'186,186,186', 'gr[ae]y73',
	'187,255,255', 'paleturquoise1',
	'188,143,143', 'rosy[ \-]?brown',
	'188,210,238', 'lightsteelblue2',
	'188,238,104', 'darkolivegreen2',
	'189,183,107', 'dark[ \-]?khaki',
	'189,189,189', 'gr[ae]y74',
	'190,190,190', 'gr[ae]y',
	'191, 62,255', 'darkorchid1',
	'191,191,191', 'gr[ae]y75',
	'191,239,255', 'lightblue1',
	'192,255, 62', 'olivedrab1',
	'193,205,193', 'honeydew3',
	'193,205,205', 'azure3',
	'193,255,193', 'darkseagreen1',
	'194,194,194', 'gr[ae]y76',
	'196,196,196', 'gr[ae]y77',
	'198,226,255', 'slategray1',
	'199, 21,133', 'medium[ \-]?violet[ \-]?red',
	'199,199,199', 'gr[ae]y78',
	'201,201,201', 'gr[ae]y79',
	'202,225,255', 'lightsteelblue1',
	'202,255,112', 'darkolivegreen1',
	'204,204,204', 'gr[ae]y80',
	'205,  0,  0', 'red3',
	'205,  0,205', 'magenta3',
	'205, 16,118', 'deeppink3',
	'205, 38, 38', 'firebrick3',
	'205, 41,144', 'maroon3',
	'205, 50,120', 'violetred3',
	'205, 51, 51', 'brown3',
	'205, 55,  0', 'orangered3',
	'205, 79, 57', 'tomato3',
	'205, 85, 85', 'indianred3',
	'205, 91, 69', 'coral3',
	'205, 92, 92', 'indian[ \-]?red',
	'205, 96,144', 'hotpink3',
	'205,102,  0', 'darkorange3',
	'205,102, 29', 'chocolate3',
	'205,104, 57', 'sienna3',
	'205,104,137', 'palevioletred3',
	'205,105,201', 'orchid3',
	'205,112, 84', 'salmon3',
	'205,129, 98', 'lightsalmon3',
	'205,133,  0', 'orange3',
	'205,133, 63', 'peru|tan3',
	'205,140,149', 'lightpink3',
	'205,145,158', 'pink3',
	'205,149, 12', 'darkgoldenrod3',
	'205,150,205', 'plum3',
	'205,155, 29', 'goldenrod3',
	'205,155,155', 'rosybrown3',
	'205,170,125', 'burlywood3',
	'205,173,  0', 'gold3',
	'205,175,149', 'peachpuff3',
	'205,179,139', 'navajowhite3',
	'205,181,205', 'thistle3',
	'205,183,158', 'bisque3',
	'205,183,181', 'mistyrose3',
	'205,186,150', 'wheat3',
	'205,190,112', 'lightgoldenrod3',
	'205,192,176', 'antiquewhite3',
	'205,193,197', 'lavenderblush3',
	'205,197,191', 'seashell3',
	'205,198,115', 'khaki3',
	'205,200,177', 'cornsilk3',
	'205,201,165', 'lemonchiffon3',
	'205,201,201', 'snow3',
	'205,205,  0', 'yellow3',
	'205,205,180', 'lightyellow3',
	'205,205,193', 'ivory3',
	'207,207,207', 'gr[ae]y81',
	'208, 32,144', 'violet[ \-]?red',
	'209, 95,238', 'mediumorchid2',
	'209,209,209', 'gr[ae]y82',
	'209,238,238', 'lightcyan2',
	'210,105, 30', 'chocolate',
	'210,180,140', 'tan',
	'211,211,211', 'light( gr[ae]|-gr[ae]|gr[ae])y',
	'212,212,212', 'gr[ae]y83',
	'214,214,214', 'gr[ae]y84',
	'216,191,216', 'thistle',
	'217,217,217', 'gr[ae]y85',
	'218,112,214', 'orchid',
	'218,165, 32', 'goldenrod',
	'219,112,147', 'pale[ \-]?violet[ \-]?red',
	'219,219,219', 'gr[ae]y86',
	'220,220,220', 'gainsboro',
	'221,160,221', 'plum',
	'222,184,135', 'burlywood',
	'222,222,222', 'gr[ae]y87',
	'224,102,255', 'mediumorchid1',
	'224,224,224', 'gr[ae]y88',
	'224,238,224', 'honeydew2',
	'224,238,238', 'azure2',
	'224,255,255', 'light[ \-]?cyan1?',
	'227,227,227', 'gr[ae]y89',
	'229,229,229', 'gr[ae]y90',
	'230,230,250', 'lavender',
	'232,232,232', 'gr[ae]y91',
	'233,150,122', 'dark[ \-]?salmon',
	'235,235,235', 'gr[ae]y92',
	'237,237,237', 'gr[ae]y93',
	'238,  0,  0', 'red2',
	'238,  0,238', 'magenta2',
	'238, 18,137', 'deeppink2',
	'238, 44, 44', 'firebrick2',
	'238, 48,167', 'maroon2',
	'238, 58,140', 'violetred2',
	'238, 59, 59', 'brown2',
	'238, 64,  0', 'orangered2',
	'238, 92, 66', 'tomato2',
	'238, 99, 99', 'indianred2',
	'238,106, 80', 'coral2',
	'238,106,167', 'hotpink2',
	'238,118,  0', 'darkorange2',
	'238,118, 33', 'chocolate2',
	'238,121, 66', 'sienna2',
	'238,121,159', 'palevioletred2',
	'238,122,233', 'orchid2',
	'238,130, 98', 'salmon2',
	'238,130,238', 'violet',
	'238,149,114', 'lightsalmon2',
	'238,154,  0', 'orange2',
	'238,154, 73', 'tan2',
	'238,162,173', 'lightpink2',
	'238,169,184', 'pink2',
	'238,173, 14', 'darkgoldenrod2',
	'238,174,238', 'plum2',
	'238,180, 34', 'goldenrod2',
	'238,180,180', 'rosybrown2',
	'238,197,145', 'burlywood2',
	'238,201,  0', 'gold2',
	'238,203,173', 'peachpuff2',
	'238,207,161', 'navajowhite2',
	'238,210,238', 'thistle2',
	'238,213,183', 'bisque2',
	'238,213,210', 'mistyrose2',
	'238,216,174', 'wheat2',
	'238,220,130', 'lightgoldenrod2',
	'238,221,130', 'light[ \-]?goldenrod',
	'238,223,204', 'antiquewhite2',
	'238,224,229', 'lavenderblush2',
	'238,229,222', 'seashell2',
	'238,230,133', 'khaki2',
	'238,232,170', 'pale[ \-]?goldenrod',
	'238,232,205', 'cornsilk2',
	'238,233,191', 'lemonchiffon2',
	'238,233,233', 'snow2',
	'238,238,  0', 'yellow2',
	'238,238,209', 'lightyellow2',
	'238,238,224', 'ivory2',
	'240,128,128', 'light[ \-]?coral',
	'240,230,140', 'khaki',
	'240,240,240', 'gr[ae]y94',
	'240,248,255', 'alice[ \-]?blue',
	'240,255,240', 'honeydew1?',
	'240,255,255', 'azure1?',
	'242,242,242', 'gr[ae]y95',
	'244,164, 96', 'sandy[ \-]?brown',
	'245,222,179', 'wheat',
	'245,245,220', 'beige',
	'245,245,245', 'gr[ae]y96|white[ \-]?smoke',
	'245,255,250', 'mint[ \-]?cream',
	'247,247,247', 'gr[ae]y97',
	'248,248,255', 'ghost[ \-]?white',
	'250,128,114', 'salmon',
	'250,235,215', 'antique[ \-]?white',
	'250,240,230', 'linen',
	'250,250,210', 'light[ \-]?goldenrod[ \-]?yellow',
	'250,250,250', 'gr[ae]y98',
	'252,252,252', 'gr[ae]y99',
	'253,245,230', 'old[ \-]?lace',
	'255,  0,  0', 'red1?',
	'255,  0,255', 'magenta1?',
	'255, 20,147', 'deep[ \-]?pink1?',
	'255, 48, 48', 'firebrick1',
	'255, 52,179', 'maroon1',
	'255, 62,150', 'violetred1',
	'255, 64, 64', 'brown1',
	'255, 69,  0', 'orange[ \-]?red1?',
	'255, 99, 71', 'tomato1?',
	'255,105,180', 'hot[ \-]?pink',
	'255,106,106', 'indianred1',
	'255,110,180', 'hotpink1',
	'255,114, 86', 'coral1',
	'255,127,  0', 'darkorange1',
	'255,127, 36', 'chocolate1',
	'255,127, 80', 'coral',
	'255,130, 71', 'sienna1',
	'255,130,171', 'palevioletred1',
	'255,131,250', 'orchid1',
	'255,140,  0', 'dark[ \-]?orange',
	'255,140,105', 'salmon1',
	'255,160,122', 'light[ \-]?salmon1?',
	'255,165,  0', 'orange1?',
	'255,165, 79', 'tan1',
	'255,174,185', 'lightpink1',
	'255,181,197', 'pink1',
	'255,182,193', 'light[ \-]?pink',
	'255,185, 15', 'darkgoldenrod1',
	'255,187,255', 'plum1',
	'255,192,203', 'pink',
	'255,193, 37', 'goldenrod1',
	'255,193,193', 'rosybrown1',
	'255,211,155', 'burlywood1',
	'255,215,  0', 'gold1?',
	'255,218,185', 'peach[ \-]?puff1?',
	'255,222,173', 'navajo[ \-]?white1?',
	'255,225,255', 'thistle1',
	'255,228,181', 'moccasin',
	'255,228,196', 'bisque1?',
	'255,228,225', 'misty[ \-]?rose1?',
	'255,231,186', 'wheat1',
	'255,235,205', 'blanched[ \-]?almond',
	'255,236,139', 'lightgoldenrod1',
	'255,239,213', 'papaya[ \-]?whip',
	'255,239,219', 'antiquewhite1',
	'255,240,245', 'lavender[ \-]?blush1?',
	'255,245,238', 'seashell1?',
	'255,246,143', 'khaki1',
	'255,248,220', 'cornsilk1?',
	'255,250,205', 'lemon[ \-]?chiffon1?',
	'255,250,240', 'floral[ \-]?white',
	'255,250,250', 'snow1?',
	'255,255,  0', 'yellow1?',
	'255,255,224', 'light[ \-]?yellow1?',
	'255,255,240', 'ivory1?',
	'255,255,255', 'gr[ae]y100|white',
    );
    while (($val, $regex) = each %rgb) {
	return split(',', $val) if m/^$regex$/i;
    }

}
__END__
