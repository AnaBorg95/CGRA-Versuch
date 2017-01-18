package de.amidar.digests;

import org.bouncycastle.crypto.digests.MD5Digest_inline;

public class MD5Test_inline_long {

    public static void main(String[] args) {

	int[] data = {	
	    17,  234, 58, 177,
	    143, 222, 27, 162, 
	    155, 39,  49, 174,
	    241, 10,  43, 99
	};

	MD5Test_inline_long md5test = new MD5Test_inline_long();
	md5test.run(data);

    }

    public void run(int[] data) {

	MD5Digest_inline digest = new MD5Digest_inline();
	
	digest.processBlock(data);
	digest.processBlock(data);
	digest.processBlock(data);
	    
    }

}
