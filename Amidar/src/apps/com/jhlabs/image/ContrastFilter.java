/*
Copyright 2006 Jerry Huxtable

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.jhlabs.image;

/**
 * A filter to change the brightness and contrast of an image.
 */
public class ContrastFilter {

    private float brightness = 0.8f;
    private float contrast = 0.8f;
	
    public int[] filter( int[] inPixels ) {

 	int length = inPixels.length;       
	int[] outPixels = new int[length];
	int res = 0;

	for ( int index = 0; index < length; index++ ) {
	    int rgb = inPixels[index];
	    int a = rgb & 0xff000000;
	    int r = (rgb >> 16) & 0xff;
	    int g = (rgb >> 8) & 0xff;
            int b = rgb & 0xff;
	    r = (int)(( 255 * (r / 255.0F) * brightness - 0.5F) * contrast + 0.5F);
	    if (r < 0) r = 0;
	    if (r > 255) r = 255;
	    g = (int)(( 255 * (g / 255.0F) * brightness - 0.5F) * contrast + 0.5F);
	    if (g < 0) g = 0;
	    if (g > 255) g = 255;
	    b = (int)(( 255 * (b / 255.0F) * brightness - 0.5F) * contrast + 0.5F);
	    if (b < 0) b = 0;
	    if (b > 255) b = 255;
	    res = a | (r << 16) | (g << 8) | b;
	    outPixels[index] = res;
	}

        return outPixels;

    }
    
}
