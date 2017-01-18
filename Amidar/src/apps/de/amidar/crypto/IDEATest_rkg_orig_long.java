package de.amidar.crypto;

import org.bouncycastle.crypto.engines.IDEAEngine;

import org.bouncycastle.crypto.params.KeyParameter;

public class IDEATest_rkg_orig_long {

    private byte[] key;

    public static void main(String[] args) {

        byte[] key = {
	    (byte)61,  (byte)182, (byte)188, (byte)145, 
	    (byte)64,  (byte)118, (byte)78,  (byte)3,
	    (byte)42,  (byte)171, (byte)130, (byte)235, 
	    (byte)249, (byte)88,  (byte)208, (byte)21
	};

	byte[] data = {	
	    (byte)17,  (byte)234, (byte)58, (byte)177,
	    (byte)143, (byte)222, (byte)27, (byte)162
	};

	IDEATest_rkg_orig_long ideatest = new IDEATest_rkg_orig_long(key);
	ideatest.run(data);

    }

    public IDEATest_rkg_orig_long(byte[] key) {
	this.key = key;
    }

    public void run(byte[] data) {

	byte[] encrypted = new byte[data.length];

	IDEAEngine engine = new IDEAEngine();

	KeyParameter param = new KeyParameter(key);

	engine.init(true, param);
	engine.init(true, param);
	engine.init(true, param);

    }

}
