package de.amidar.filter;

import com.jhlabs.image.ContrastFilter;

public class ContrastFilterTest_pixel_long {

    public static void main(String[] args) throws Exception {

	ContrastFilterTest_pixel_long contrast = new ContrastFilterTest_pixel_long();
	contrast.run();

    }

    public void run() throws Exception {
	int[] rgb = {
	    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
	    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
	    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
	    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
	    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
	    -1
	};

	ContrastFilter filter = new ContrastFilter();

	filter.filter(rgb);

    }

}
