/* gnu.java.beans.editors.ColorEditor
   Copyright (C) 1998 Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.
 
GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */


package gnu.java.beans.editors;

import java.awt.Color;
import java.beans.PropertyEditorSupport;

/**
 ** NativeByteEditor is a property editor for the
 ** byte type.
 **
 ** @author John Keiser
 ** @version 1.1.0, 29 Jul 1998
 **/

public class ColorEditor extends PropertyEditorSupport {
	Color[] stdColors = {Color.black,Color.blue,Color.cyan,
	                     Color.darkGray,Color.gray,Color.green,
	                     Color.lightGray,Color.magenta,Color.orange,
	                     Color.pink,Color.red,Color.white,
	                     Color.yellow};
	String[] stdColorNames = {"black","blue","cyan",
	                          "dark gray","gray","green",
	                          "light gray","magenta","orange",
	                          "pink","red","white",
	                          "yellow"};

	/** setAsText for Color checks for standard color names
	 ** and then checks for a #RRGGBB value or just RRGGBB,
	 ** both in hex.
	 **/
	public void setAsText(String val) throws IllegalArgumentException {
		if(val.length() == 0) {
			throw new IllegalArgumentException("Tried to set empty value!");
		}
		for(int i=0;i<stdColorNames.length;i++) {
			if(stdColorNames[i].equalsIgnoreCase(val)) {
				setValue(stdColors[i]);
				return;
			}
		}
		if(val.charAt(0) == '#') {
			setValue(new Color(Integer.parseInt(val.substring(1),16)));
		} else {
			setValue(new Color(Integer.parseInt(val,16)));
		}
	}

	/** getAsText for Color turns the color into either one of the standard
	 ** colors or into an RGB hex value with # prepended. **/
	public String getAsText() {
		for(int i=0;i<stdColors.length;i++) {
			if(stdColors[i].equals(getValue())) {
				return stdColorNames[i];
			}
		}
		return "#" + Integer.toHexString(((Color)getValue()).getRGB() & 0x00FFFFFF);
	}

	/** getTags for Color returns a list of standard colors. **/
	public String[] getTags() {
		return stdColorNames;
	}
}
